package com.boy.limiter;

import java.util.concurrent.Semaphore;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/25 10:47
 */
public class ExecuteRateLimiter {

    private Semaphore rate;

    public ExecuteRateLimiter(int rate) {
        this.rate = new Semaphore(rate);
    }

    public boolean allowable() {
        boolean allowable = rate.tryAcquire(1);
        return allowable;
    }

    public void release() {
        rate.release(1);
    }

}