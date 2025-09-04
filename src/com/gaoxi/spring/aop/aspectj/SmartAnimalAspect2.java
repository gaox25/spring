package com.gaoxi.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//切面类
@Aspect //表示是一个切面类，底层切面编程的支撑是动态代理+反射+动态绑定
@Component //会将SmartAnimalAspect2注入Spring容器
public class SmartAnimalAspect2 {
    /*
     解读：
     1.@Around：表示这是一个环绕通知，可以完成其他四个通知的功能
     2.value 是切入表达式
     3.doAround 表示切入方法
     4.joinPoint使用ProceedingJoinPoint
     5.调用基本结构是try-catch-finally
     */
    //演示环绕通知@Around的使用，一个可以抵@Before + @AfterReturning + @AfterThorowing + @After
    @Around(value = "execution(public float com.gaoxi.spring.aop.aspectj.SmartDog.getMul(float, float))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        try {
            //1.相当于前置通知完成的事情 @Before
            Object[] args = joinPoint.getArgs();
            List<Object> list = Arrays.asList(args);
            System.out.println("SmartAnimalAspect2-AOP环绕通知--" + methodName + "方法开始了--参数有：" + list);
            //在环绕通知中一定要通过joinPoint.proceed()来执行目标方法
            result = joinPoint.proceed();
            //2.相当于返回通知完成的事情 @Before的returning
            System.out.println("SmartAnimalAspect2-AOP环绕通知" + methodName + "方法结束了--结果是：" + result);
        } catch (Throwable throwable) {
            //3.相当于异常通知完成的事情 @AfterThrowing
            System.out.println("SmartAnimalAspect2-AOP环绕通知" + methodName + "方法抛异常了--异常对象：" + throwable);
        } finally {
            //4.相当于最终通知完成的事情 @After
            System.out.println("SmartAnimalAspect2-AOP后置通知" + methodName + "方法最终结束了...");
        }
        return result;
    }
}
