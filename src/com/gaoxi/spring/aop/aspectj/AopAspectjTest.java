package com.gaoxi.spring.aop.aspectj;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAspectjTest {

    @Test
    public void smartDogTestByProxy() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");
        //这里必须通过接口类型即SmartAnimalabe，而不是SmartDog来获取注入的SmartDog对象-就是代理对象
        SmartAnimalable smartAnimalable = ioc.getBean(SmartAnimalable.class);
        smartAnimalable.getSum(10, 20);
        System.out.println("smartAnimalable的运行类型为：" + smartAnimalable.getClass());
        System.out.println("=================");
        smartAnimalable.getSub(10, 20);
    }
}
