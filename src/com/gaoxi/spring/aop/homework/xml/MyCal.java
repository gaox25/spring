package com.gaoxi.spring.aop.homework.xml;

import org.springframework.stereotype.Component;

@Component //将MyCal作为组件注入到Spring容器中
public class MyCal implements Cal {
    @Override
    public int call1(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        System.out.println("call1()执行结果 = " + res);
        return res;
    }

    @Override
    public int call2(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        System.out.println("call2()执行结果 = " + res);
        return res;
    }
}
