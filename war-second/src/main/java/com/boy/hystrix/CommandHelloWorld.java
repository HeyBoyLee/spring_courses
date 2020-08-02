package com.boy.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.functions.Action1;

import java.util.concurrent.Future;

/**
 * Created by heyboy on 2020-07-26.
 */
public class CommandHelloWorld extends HystrixCommand<String> {

  private final String name;

  public CommandHelloWorld(String name) {
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    this.name = name;
  }

  @Override
  protected String run() {
    // a real example would do work like a network call here
    System.out.println("run:"+Thread.currentThread().getId() + ":"+Thread.currentThread().getName());
    return "Hello " + name + "!";
  }

  @Override
  protected String getFallback() {
    return "fallback:"+name;
//    return super.getFallback();
  }

  public static void main(String[] args) {
    try{
      System.out.println("main:"+Thread.currentThread().getId() + ":"+Thread.currentThread().getName());
      String s = new CommandHelloWorld("Bob").execute();
      Future<String> s1 = new CommandHelloWorld("Bob1").queue();
      Observable<String> s2 = new CommandHelloWorld("Bob2").observe();
      System.out.println(s);
      System.out.println(s1.get());
      s2.subscribe(new Action1<String>() {
        @Override
        public void call(String x) {
          System.out.println(x);
        }
      });

    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
