package com.gaoxi.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//切面类
@Aspect //表示是一个切面类，底层切面编程的支撑是动态代理+反射+动态绑定
@Component //会将SmartAnimalAspect注入Spring容器
public class SmartAnimalAspect {
    //希望将f1方法切入到SmartDog.getSum前执行-前置通知
    /*
     解读：1.@Before表示是一个前置通知，表示f1()会切入目标对象执行方法getSum()前执行
          2.value表示要切入的哪个类的哪个方法前，形式是访问修饰符 + 返回类型 + 全类名 + 方法名(形参列表)
          3.f1()方法可以理解成就是一个切入方法，这个方法名是可以程序员指定的，通常叫showBeginLog()，即开始前的日志
          4.JointPoint jointPoint在底层执行时，由AspectJ切面框架，会给该切入方法传入jointPoint对象，
            通过该方法，程序员可以获取到相关信息，比如真正执行的方法
     */
    //@Before(value = "execution(public float com.gaoxi.spring.aop.aspectj.SmartDog.getSum(float, float))")
    //切入表达式的模糊配置
    @Before(value = "execution(* com.gaoxi.spring.aop.aspectj.SmartDog.*(..))")
    //表示所有访问权限，所有包下的所有类的所有方法，都会被执行该前置通知方法
    //@Before(value = "execution(* *.*(..))")
    //public void f1(JoinPoint joinPoint) {
    //使用showBeginLog比较适合
    public void showBeginLog(JoinPoint joinPoint) {
        //通过连接点对象，来获取方法签名
        System.out.println("切面类SmartAnimalAspect方法showBeginLog()");
        System.out.println("方法签名 = " + joinPoint.getSignature());
        System.out.println("方法参数 = " + joinPoint.getArgs());
    }

    //返回通知，即把f2()切入到目标对象方法正常执行完毕后的位置
    @AfterReturning(value = "execution(public float com.gaoxi.spring.aop.aspectj.SmartDog.getSum(float, float))")
    //public void f2(JoinPoint joinPoint) {
    public void showSuccessEndLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类showSuccessEndLog()-方法执行正常结束-日志-方法名-" + signature.getName());//从AOP看，也是一个横切关注点-返回通知
    }

    //异常通知，即把f3()方法切入到目标对象方法执行发生异常的catch{}
    @AfterThrowing(value = "execution(public float com.gaoxi.spring.aop.aspectj.SmartDog.getSum(float, float))")
    //public void f3(JoinPoint joinPoint) {
    public void showExceptionEndLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类showExceptionEndLog()-方法执行异常-日志-方法名-" + signature.getName());
    }

    //最终通知，即把f4方法切入到目标方法执行后(不管是否发生异常，都要执行，即finally{})
    @After(value = "execution(public float com.gaoxi.spring.aop.aspectj.SmartDog.getSum(float, float))")
    //public void f4(JoinPoint joinPoint) {
    public void showFinallyEndLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类showFinallyEndLog()-方法最终执行完毕-日志-方法名-" + signature.getName());
    }

//    @Before(value = "execution(public void com.gaoxi.spring.aop.aspectj.*.work())")
//    public void beforeWork() {
//        System.out.println("work()方法前置");
//    }

    //切入接口方法前，所有实现了UsbInterface接口的类，执行work方法前，都会执行该切面类方法
    @Before(value = "execution(public void com.gaoxi.spring.aop.aspectj.UsbInterface.work())")
    public void beforeWork(JoinPoint joinPoint) {
        System.out.println("work()方法前置");
    }

    @After(value = "execution(* com.gaoxi.spring.aop.aspectj.*.*(..))")
    public void afterWork(JoinPoint joinPoint) {
        System.out.println("work()方法后置");
    }

    //前置通知，切入没有实现接口的类Car的方法
    @Before(value = "execution(public void Car.run())")
    public void ok(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类的ok1()-执行的目标方法-" + signature.getName());
    }
}
