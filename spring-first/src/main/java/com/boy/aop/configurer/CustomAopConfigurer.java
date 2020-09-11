package com.boy.aop.configurer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/7 11:08
 */
@Configuration
@ComponentScan("com.boy.aop")
@EnableAspectJAutoProxy
public class CustomAopConfigurer {
}
