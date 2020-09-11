package com.boy.validator;

import java.lang.annotation.*;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/7 16:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface FlagValidator {
}
