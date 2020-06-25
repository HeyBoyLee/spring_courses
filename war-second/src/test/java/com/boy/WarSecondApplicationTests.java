package com.boy;

import com.boy.service.SomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WarSecondApplicationTests {

  @Autowired
  SomeService someService;

  @Test
  void contextLoads() {
    System.out.println(someService.getSome());
  }

}
