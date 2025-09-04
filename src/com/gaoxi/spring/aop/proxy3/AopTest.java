package com.gaoxi.spring.aop.proxy3;

import org.junit.jupiter.api.Test;

public class AopTest {
    @Test
    public void smartDogTest() {
        SmartAnimalable smartDog = new SmartDog();
        smartDog.getSum(10, 2);
        System.out.println("=======================");
        smartDog.getSub(10, 2);
    }
}
