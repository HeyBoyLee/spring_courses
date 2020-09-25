package com.boy.breaker;

import com.boy.limiter.ExecuteRateLimiter;

import java.util.function.Supplier;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/25 11:14
 */
public class ExecuteCircuitBreaker<T> implements CircuitBreaker<T> {

    public Supplier<T> function;
    public Supplier<T> failback;

    private ExecuteRateLimiter rateLimiter;

    public ExecuteCircuitBreaker(Supplier<T> function, Supplier<T> failback, int rate) {
        this.rateLimiter = new ExecuteRateLimiter(rate);
        this.failback = failback;
        this.function = function;
    }

    public ExecuteCircuitBreaker(Supplier<T> function, int rate) {
        this(function, null, rate);
    }

    @Override
    public T execute() {
        if (this.rateLimiter.allowable()) {
            try {
                T t = function.get();
                return t;
            } finally {
                this.rateLimiter.release();
            }
        }
        if (failback != null) {
            return failback.get();
        }
        return null;
    }
}