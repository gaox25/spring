package com.gaoxi.spring.aop.aspectj;

import org.springframework.stereotype.Component;

@Component //把Car作为一个组件[对象]注入到Spring容器中
public class Car {
    public void run() {
        System.out.println("Car.run()-小汽车在running");
    }
}
