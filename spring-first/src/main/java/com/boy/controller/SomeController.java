package com.boy.controller;

import com.boy.Interceptor.LoginRequired;
import com.boy.aop.HelloWorld;
import com.boy.aop.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/some")
public class SomeController {
    private Logger log = LoggerFactory.getLogger(SomeController.class.getName());

    @Autowired
    @Qualifier("helloWorld1")
    HelloWorld helloWorld1;

    @Autowired
    @Qualifier("helloWorld2")
    HelloWorld helloWorld2;

    @Autowired
    Person chinese;

    @GetMapping("/getHandler")
    @LoginRequired
    public String someHandler(@RequestParam String name) {
        log.info("get handler: name:{}", name);
        helloWorld1.printHelloWorld();
        chinese.say("中文");
        return "spring boot hello " + name;
    }

    @PostMapping("/postHandler")
    @LoginRequired
    public String postHandler(@RequestBody @Validated BodyVO param) {
        log.info("post handler: BodyVO:{}", param);
        helloWorld2.printHelloWorld();
        return String.format("hello %s, %s years old", param.getName(), param.getAge());
    }
}
