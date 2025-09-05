package com.gaoxi.spring.aop.homework.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

public class MyCalAOP {
    //前置通知
    //注意，如果目标类和切面类在同一个包，可以省略包名
    //因为call1和call2方法都要输出时间，因此使用*通配符
    public void calStart(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + "基于XML配置-开始执行，开始执行的时间是：" + System.currentTimeMillis());
    }
    //返回通知
    public void calEnd(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + "基于XML配置-执行结束，执行结束的时间是：" + System.currentTimeMillis());
    }
}
