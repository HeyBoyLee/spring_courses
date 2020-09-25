package com.boy.limiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/25 10:46
 * https://www.jianshu.com/p/6c7c109531b3
 */
public class QpsRateLimiter {

    private long lastTime;

    private long interval;

    private AtomicInteger remaind;

    private int rate;

    public QpsRateLimiter(int rate, long interval, TimeUnit unit) {
        this.rate = rate;
        this.interval = unit.toMillis(interval);
        this.lastTime = System.currentTimeMillis();
        this.remaind = new AtomicInteger(rate);
    }

    public boolean allowable() {
        long now = System.currentTimeMillis();
        if (now > lastTime + interval) {
            remaind.set(rate);
            lastTime = now;
        }

        int value = remaind.get();
        boolean flag = false;
        while (value > 0 && !flag) {
            flag = remaind.compareAndSet(value, value - 1);
            value = remaind.get();
        }

        return flag;
    }

}