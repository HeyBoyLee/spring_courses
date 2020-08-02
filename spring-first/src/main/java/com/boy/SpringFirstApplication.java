package com.boy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@SpringBootApplication
public class SpringFirstApplication {

  public static void main(String[] args) {
//    SpringApplication.run(SpringFirstApplication.class, args);

    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource res = resolver.getResource("classpath:com/baobaotao/beanfactory/beans.xml");
    BeanFactory bf = new XmlBeanFactory(res);
    System.out.println("init BeanFactory.");
//    Car car = bf.getBean("car",Car.class);
//    System.out.println("car bean is ready for use!");
  }

}
