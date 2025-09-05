package com.gaoxi.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//这是开发的一个切面类，但是不用注解，而是使用xml配置的方式
public class SmartAnimalAspect {

    public void showBeginLog(JoinPoint joinPoint) {
        //通过连接点对象，来获取方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("基于XML配置--切面类showBeginLog()-方法执行异常-日志-方法名-" + signature.getName());
    }


    public void showSuccessEndLog(JoinPoint joinPoint, Object res) {
        Signature signature = joinPoint.getSignature();
        System.out.println("基于XML配置--切面类showSuccessEndLog()-方法执行正常结束-日志-方法名-" + signature.getName());//从AOP看，也是一个横切关注点-返回通知
        System.out.println("目标方法返回的结果为：" + res.toString());
    }

    public void showExceptionEndLog(JoinPoint joinPoint, Object throwable) {
        Signature signature = joinPoint.getSignature();
        System.out.println("基于XML配置--切面类showExceptionEndLog()-方法执行异常-日志-方法名-" + signature.getName());
        System.out.println("抛出的异常为：" + throwable.toString());
    }

    public void showFinallyEndLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("基于XML配置--切面类showFinallyEndLog()-方法最终执行完毕-日志-方法名-" + signature.getName());
    }

}
