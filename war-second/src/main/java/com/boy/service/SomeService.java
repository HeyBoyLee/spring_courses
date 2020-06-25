package com.boy.service;

import com.boy.SomeInterface;
import org.springframework.stereotype.Service;

@Service
public class SomeService implements SomeInterface {
  @Override
  public String getSome() {
    return "Hello Some String";
  }
}
