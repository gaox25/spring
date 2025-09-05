package com.gaoxi.spring.aop.xml;

import com.gaoxi.spring.aop.aspectj.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAspectjXmlTest {
    @Test
    public void testAspectByXML() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans09.xml");
        SmartAnimalable bean = ioc.getBean(SmartAnimalable.class);
        bean.getSum(10, 2);

    }
}
