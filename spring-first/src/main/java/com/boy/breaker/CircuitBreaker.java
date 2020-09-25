package com.boy.breaker;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/25 10:42
 */
public interface CircuitBreaker<T> {
    T execute();
}
