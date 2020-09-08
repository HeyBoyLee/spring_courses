package com.boy.config;

import com.boy.bean.InitSequenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by heyboy on 2020-08-29.
 */
@Configuration
public class MockConfiguration {
  @Bean(initMethod = "initMethod")
  public InitSequenceBean createInitSequenceBean(){
    return new InitSequenceBean();
  }
}
