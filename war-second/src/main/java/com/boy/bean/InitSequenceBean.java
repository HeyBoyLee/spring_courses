package com.boy.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * Created by heyboy on 2020-08-29.
 */

public class InitSequenceBean implements InitializingBean {
  public InitSequenceBean(){
    System.out.println("InitSequenceBean -> constructor");
  }
  @PostConstruct
  public void postConstruct(){
    System.out.println("InitSequenceBean -> postConstruct");
  }

  public void initMethod(){
    System.out.println("InitSequenceBean -> initMethod");
  }
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("InitSequenceBean -> afterPropertiesSet");
  }
}
