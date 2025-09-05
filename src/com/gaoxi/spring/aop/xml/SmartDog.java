package com.gaoxi.spring.aop.xml;

import org.springframework.stereotype.Component;

//使用@Component，当Spring容器启动时，将SmartDog注入到容器中
//@Component
public class SmartDog implements SmartAnimalable {
    @Override
    public float getSum(float i, float j) {
        //验证异常通知切入方法
        //System.out.println(10 / 0);
        return 0;
    }

    @Override
    public float getSub(float i, float j) {
        return 0;
    }

    @Override
    public float getMul(float i, float j) {
        return i * j;
    }
}
