package com.boy.controller;

import com.boy.aop.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/some")
public class SomeController {
    private Logger log = LoggerFactory.getLogger(SomeController.class.getName());

    @Autowired
    @Qualifier("helloWorld1")
    HelloWorld helloWorld;

    @GetMapping("/getHandler")
    public String someHandler(@RequestParam String name) {
        log.info("get handler: name:{}", name);
        helloWorld.printHelloWorld();
        return "spring boot hello " + name;
    }

    @PostMapping("/postHandler")
    public String postHandler(@RequestBody BodyVO param) {
        log.info("get handler: BodyVO:{}", param);
      return String.format("hello %s, %s years old", param.getName(), param.getAge());
    }
}
