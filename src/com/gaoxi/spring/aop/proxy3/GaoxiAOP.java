package com.gaoxi.spring.aop.proxy3;

import java.lang.reflect.Method;
import java.util.Arrays;

//一个极简的AOP类
public class GaoxiAOP {
    public static void before(Object proxy, Method method, Object[] args) {
        System.out.println("GaoxiAOP before方法执行前-日志-方法名-" + method.getName() + "-参数 "
                + Arrays.asList(args));
    }
    public static void after(Method method, Object result) {
        System.out.println("GaoxiAOP after方法执行异常-日志-方法名-" + method.getName()
                + "结果=" + result);
    }
}
