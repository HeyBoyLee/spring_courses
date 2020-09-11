package com.boy.controller;

import com.boy.validator.CannotHaveBlank;
import com.sun.istack.internal.NotNull;
import lombok.Data;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/4 15:47
 */
@Data
public class BodyVO {
    @CannotHaveBlank(message = "不能有空格")
    private String name;
    private Integer age;
}
