package com.boy.hystrix;

import com.netflix.hystrix.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 测试信号量隔离
 * 默认执行run()用的是主线程，为了模拟并行执行command，这里我们自己创建多个线程来执行command
 * 设置ExecutionIsolationSemaphoreMaxConcurrentRequests为3，意味着信号量最多允许执行run的并发数为3，超过则触发降级，即不执行run而执行getFallback
 * 设置FallbackIsolationSemaphoreMaxConcurrentRequests为1，意味着信号量最多允许执行fallback的并发数为1，超过则抛异常fallback execution rejected
 */
public class HystrixCommand4SemaphoreTest extends HystrixCommand<String> {

    private final String name;

    public HystrixCommand4SemaphoreTest(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("SemaphoreTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("SemaphoreTestKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("SemaphoreTestThreadPoolKey"))
                .andCommandPropertiesDefaults(	// 配置信号量隔离
                    HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)	// 信号量隔离
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(3)
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(1)
                )
            // 设置了信号量隔离后，线程池配置将变无效
//                .andThreadPoolPropertiesDefaults(
//                		HystrixThreadPoolProperties.Setter()
//                		.withCoreSize(13)	// 配置线程池里的线程数
//                )
        );
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "run(): name="+name+"，线程名是" + Thread.currentThread().getName() + "线程ID:"+Thread.currentThread().getId();
    }

    @Override
    protected String getFallback() {
        return "getFallback(): name="+name+"，线程名是" + Thread.currentThread().getName();
    }

    public static void main(String[] args) {

        try {
            System.out.println("main(): 线程名是" + Thread.currentThread().getName() + "线程ID:"+Thread.currentThread().getId());
            Future<String> f = new HystrixCommand4SemaphoreTest("HLX" ).queue();
            System.out.println("===========" + f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}