package com.gaoxi.spring.aop.homework;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyCalAOP {
    @Test
    public void testMyCalByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans10.xml");
        Cal cal = ioc.getBean(Cal.class);
        cal.call1(10);
        cal.call2(10);
    }
}
