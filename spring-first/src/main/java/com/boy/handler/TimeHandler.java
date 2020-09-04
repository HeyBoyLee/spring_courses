package com.boy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/4 16:39
 */
public class TimeHandler {
    private Logger log = LoggerFactory.getLogger(TimeHandler.class.getName());
    public void printTime(){
        log.info("CurrentTime:{}", System.currentTimeMillis());
    }
}
