package com.gaoxi.spring.test;

import com.gaoxi.spring.bean.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SuppressWarnings({"all"})
public class SpringBeanTest02 {
    @Test
    public void getCar() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Car car01 = (Car) ioc.getBean("car01");
        System.out.println(car01);
    }
}
