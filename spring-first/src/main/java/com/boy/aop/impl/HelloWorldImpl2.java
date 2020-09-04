package com.boy.aop.impl;

import com.boy.aop.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/4 16:37
 */
public class HelloWorldImpl2 implements HelloWorld {
    private Logger log = LoggerFactory.getLogger(HelloWorldImpl2.class.getName());
    @Override
    public void printHelloWorld() {
        log.info("Enter HelloWorldImpl2->printHelloWorld");
    }

    @Override
    public void doPrint() {
        log.info("Enter HelloWorldImpl2->doPrint");
    }
}
