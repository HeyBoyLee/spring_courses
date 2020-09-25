package com.boy.breaker;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/25 10:42
 * https://www.jianshu.com/p/ef8983213bfe
 */
import com.boy.limiter.QpsRateLimiter;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class QpsCircuitBreaker<T> implements CircuitBreaker<T> {

    public Supplier<T> function;
    public Supplier<T> failback;

    private QpsRateLimiter rateLimiter;

    public QpsCircuitBreaker(Supplier<T> function, Supplier<T> failback, int rate, long interval, TimeUnit unit) {
        this.rateLimiter = new QpsRateLimiter(rate, interval, unit);
        this.failback = failback;
        this.function = function;
    }

    public QpsCircuitBreaker(Supplier<T> function, int rate, long interval, TimeUnit unit) {
        this(function, null, rate, interval, unit);
    }

    @Override
    public T execute() {
        if (this.rateLimiter.allowable()) {
            return function.get();
        }
        if (failback != null) {
            return failback.get();
        }
        return null;
    }
}
