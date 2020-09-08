package com.boy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.boy")

@SpringBootApplication
public class WarSecondApplication {
  public static void main(String[] args) {
    SpringApplication.run(WarSecondApplication.class, args);
  }

}
