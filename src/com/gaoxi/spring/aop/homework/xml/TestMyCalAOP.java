package com.gaoxi.spring.aop.homework.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyCalAOP {
    @Test
    public void testMyCalByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans11.xml");
        Cal cal = (Cal) ioc.getBean("myCal");
        cal.call1(10);
        cal.call2(10);

    }
}
