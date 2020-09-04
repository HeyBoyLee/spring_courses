package com.boy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/4 17:44
 *
 *
 * 1.经典的基于代理的AOP
 * 2.@AspectJ注解驱动的切面
 * 3.纯POJO切面（纯粹通过<aop:fonfig>标签配置）
 * 4.注入式AspectJ切面
 */
public class LogHandler {
    private Logger log = LoggerFactory.getLogger(LogHandler.class.getName());
    public void logBefore(){
        log.info("Log Before method");
    }

    public void logAfter(){
        log.info("Log After method");
    }
}
