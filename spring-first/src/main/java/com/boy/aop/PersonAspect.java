package com.boy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/7 10:55
 */
@Component
@Aspect
@Slf4j
public class PersonAspect {
    @Pointcut("@annotation(com.boy.aop.annotation.PersonAnnotation)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Exception{
        log.info("PersonAspect before method -> class:{}", joinPoint.getClass());
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) throws Exception{
        log.info("PersonAspect after method -> class:{}", joinPoint.getClass());
    }

}
