package com.boy.aop.impl;

import com.boy.aop.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/4 16:32
 */
public class HelloWorldImpl1 implements HelloWorld {
    private Logger log = LoggerFactory.getLogger(HelloWorldImpl1.class.getName());
    @Override
    public void printHelloWorld() {
        log.info("Enter HelloWorldImpl1->printHelloWorld");
    }

    @Override
    public void doPrint() {
        log.info("Enter HelloWorldImpl1->doPrint");
    }
}
