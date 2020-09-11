package com.boy.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/8 9:57
 */
@Configuration
@Slf4j
public class BeanConfigurer {
    @Bean(initMethod = "initMethod")
    public InitSequenceBean createInitSequence(){
        return new InitSequenceBean();
    }
}
