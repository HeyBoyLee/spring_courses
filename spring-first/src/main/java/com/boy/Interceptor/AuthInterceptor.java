package com.boy.Interceptor;

import com.boy.controller.BodyVO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author: lihuifeng6
 * @Date: 2020/9/7 14:31
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;


        LoginRequired loginRequired = method.getMethodAnnotation(LoginRequired.class);
        if(Objects.nonNull(loginRequired)){

            String body = new RequestWrapper(request).getBody();
            log.info("body:{}", body);
            if(Strings.isNotBlank(body)){
                BodyVO v = new Gson().fromJson(body, BodyVO.class);
                log.info("v:{}", v.toString());
            }
        }
        MethodParameter[] parameters = method.getMethodParameters();
        for(MethodParameter parameter: parameters){
            log.info("parameter:{}", parameter.getParameterType());
        }
        return true;
    }
}
