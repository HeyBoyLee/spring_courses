package com.boy.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/7 11:15
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonAnnotation {
    String name();
}
