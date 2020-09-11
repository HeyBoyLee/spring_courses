package com.boy.aop.impl;

import com.boy.aop.Person;
import com.boy.aop.annotation.PersonAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/7 10:52
 */
@Service
public class Chinese implements Person {
    private Logger log = LoggerFactory.getLogger(Chinese.class.getName());
    public Chinese(){
        log.info("实例化 Chinese 对象");
    }


    @Override
    @PersonAnnotation(name="Chinese")
    public String say(String name) {
        log.info("chinese say:{}", name);
        return "Chinese say:"+ name;
    }

    @Override
    public void eat(String food) {
        log.info("Chinese eat food:{}", food);
    }
}
