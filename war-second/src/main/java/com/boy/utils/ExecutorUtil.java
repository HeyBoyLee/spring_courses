package com.boy.utils;

import java.util.concurrent.*;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * Created by heyboy on 2020-08-28.
 */
public class ExecutorUtil {
  public static ExecutorService createExecutor(int nThreads){
    return new ThreadPoolExecutor(nThreads, nThreads,
      0L, TimeUnit.MILLISECONDS,
      new ArrayBlockingQueue<>(10),
      new BasicThreadFactory.Builder().namingPattern("ThreadPool-%d").build(),
      new ThreadPoolExecutor.DiscardPolicy()
      );
  }

  public static void main(String[] args) {

    try {
      ExecutorService executor = ExecutorUtil.createExecutor(3);
      executor.submit(()->{
        try {
          System.out.println("1:"+Thread.currentThread().getName());
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
      Thread.sleep(1000);
      executor.submit(()->{
        try {
          System.out.println("2:"+Thread.currentThread().getName());

        } catch (Exception e) {
          e.printStackTrace();
        }
      });
      Thread.sleep(1000);
      executor.submit(()->{
        try {
          System.out.println("3:"+Thread.currentThread().getName());

        } catch (Exception e) {
          e.printStackTrace();
        }
      });
      Thread.sleep(1000);
      executor.submit(()->{
        try {
          System.out.println("4:"+Thread.currentThread().getName());

        } catch (Exception e) {
          e.printStackTrace();
        }
      });
      Thread.sleep(9999999999999999L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }
}
