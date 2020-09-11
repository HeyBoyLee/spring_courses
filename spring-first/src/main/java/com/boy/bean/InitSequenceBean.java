package com.boy.bean;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/8 9:46
 */

public class InitSequenceBean implements InitializingBean {
    private Logger log = LoggerFactory.getLogger(InitSequenceBean.class.getName());
    InitSequenceBean(){
        log.info("constructor InitSequenceBean");
    }

    @PostConstruct
    public void postInitSequenceBean(){
        log.info("post constructor InitSequenceBean");
    }

    public void initMethod(){
        log.info("init method initSequenceBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitSequenceBean -> afterPropertiesSet");
    }
}
