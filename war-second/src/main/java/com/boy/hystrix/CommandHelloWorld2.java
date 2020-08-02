package com.boy.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by heyboy on 2020-07-26.
 */
public class CommandHelloWorld2 extends HystrixObservableCommand<String> {

  private final String name;

  public CommandHelloWorld2(String name) {
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    this.name = name;
  }

  @Override
  protected Observable<String> construct() {
    System.out.println("construct:"+Thread.currentThread().getId() + ":"+Thread.currentThread().getName());
    return Observable.create(new Observable.OnSubscribe<String>() {
      @Override
      public void call(Subscriber<? super String> observer) {
        try {
          if (!observer.isUnsubscribed()) {
            System.out.println("call:"+Thread.currentThread().getId() + ":"+Thread.currentThread().getName());
            // a real example would do work like a network call here
            observer.onNext("Hello");
            observer.onNext(name + "!");
            observer.onCompleted();
          }
        } catch (Exception e) {
          observer.onError(e);
        }
      }
    } ).subscribeOn(Schedulers.io());
  }

  public static void main(String[] args) {
    try {
      System.out.println("main:"+Thread.currentThread().getId() + ":"+Thread.currentThread().getName());
      new CommandHelloWorld2("hi").observe().subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
          System.out.println("call:"+Thread.currentThread().getId());
          System.out.println("11:"+s);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }
  }
}
