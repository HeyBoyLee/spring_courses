package com.boy.limiter;

import com.google.common.math.LongMath;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/24 16:41
 */
@Data
public class RedisPermits {

    /**
     * 最大存储令牌数
     */
    private double maxPermits;
    /**
     * 当前存储令牌数
     */
    private double storedPermits;
    /**
     * 添加令牌的时间间隔/毫秒
     */
    private double intervalMillis;
    /**
     * 下次请求可以获取令牌的时间，可以是过去（令牌积累）也可以是将来的时间（令牌预消费）
     */
    private long nextFreeTicketMillis;

    /**
     * 构建Redis令牌数据模型
     *
     * @param permitsPerSecond     每秒放入的令牌数
     * @param maxBurstSeconds      maxPermits由此字段计算，最大存储maxBurstSeconds秒生成的令牌
     * @param nextFreeTicketMillis 下次请求可以获取令牌的起始时间，默认当前系统时间
     */
    public RedisPermits(double permitsPerSecond, double maxBurstSeconds, Long nextFreeTicketMillis) {
        this.maxPermits = permitsPerSecond * maxBurstSeconds;
        this.storedPermits = maxPermits;
        this.intervalMillis = TimeUnit.SECONDS.toMillis(1) / permitsPerSecond;
        this.nextFreeTicketMillis = nextFreeTicketMillis;
    }

    /**
     * 基于当前时间，若当前时间晚于nextFreeTicketMicros，则计算该段时间内可以生成多少令牌，将生成的令牌加入令牌桶中并更新数据
     */
    public void resync(long nowMillis) {
        if (nowMillis > nextFreeTicketMillis) {
            double newPermits = (nowMillis - nextFreeTicketMillis) / intervalMillis;
            storedPermits = Math.min(maxPermits, storedPermits + newPermits);
            nextFreeTicketMillis = nowMillis;
        }
    }

    /**
     * 保留指定数量令牌，并返回需要等待的时间
     */
    public long reserveAndGetWaitLength(long nowMillis, int permits) {
        resync(nowMillis);
        double storedPermitsToSpend = Math.min(permits, storedPermits); // 可以消耗的令牌数
        double freshPermits = permits - storedPermitsToSpend; // 需要等待的令牌数
        long waitMillis = (long) (freshPermits * intervalMillis); // 需要等待的时间

        nextFreeTicketMillis = LongMath.saturatedAdd(nextFreeTicketMillis, waitMillis);
        storedPermits -= storedPermitsToSpend;
        return waitMillis;
    }

    /**
     * 在超时时间内，是否有指定数量的令牌可用
     */
    public boolean canAcquire(long nowMillis, int permits, long timeoutMillis) {
        return queryEarliestAvailable(nowMillis, permits) <= timeoutMillis;
    }

    /**
     * 指定数量令牌数可用需等待的时间
     *
     * @param permits 需保留的令牌数
     * @return 指定数量令牌可用的等待时间，如果为0或负数，表示当前可用
     */
    private long queryEarliestAvailable(long nowMillis, int permits) {
        resync(nowMillis);
        double storedPermitsToSpend = Math.min(permits, storedPermits); // 可以消耗的令牌数
        double freshPermits = permits - storedPermitsToSpend; // 需要等待的令牌数
        long waitMillis = (long) (freshPermits * intervalMillis); // 需要等待的时间

        return LongMath.saturatedAdd(nextFreeTicketMillis - nowMillis, waitMillis);
    }

}