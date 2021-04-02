package com.boy.limiter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/22 11:07
 */
public class MyRateLimiter {
    public static void main(String[] args) {
        try {
            System.out.println(TimeUnit.SECONDS.toMillis(1));
            RateLimiter rateLimiter = RateLimiter.create(0.5);
            //Thread.sleep(10L);
            List<Integer> list = Arrays.asList(1,6,2);
            list.forEach(i->{
                Long start = System.currentTimeMillis();
                System.out.println("["+i+"] :"+ String.valueOf(start));
                rateLimiter.acquire(i);
                System.out.println("["+i+"]gap is :"+ String.valueOf(System.currentTimeMillis() - start));

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
