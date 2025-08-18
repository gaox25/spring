package com.gaoxi.spring.homework;

import com.gaoxi.spring.bean.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Homework01 {
    //此时加载bean.xml中，没有id属性
    @Test
    public void getMonster() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster bean1 = ioc.getBean("com.gaoxi.spring.bean.Monster#0", Monster.class);
        Monster bean2 = ioc.getBean("com.gaoxi.spring.bean.Monster#1", Monster.class);
        System.out.println("ok");//验证会不会走到这一步，也就是验证没有id会不会成功
        System.out.println("monster01.monsterId = " + bean1.getMonsterId());
        System.out.println("monster01.monsterId = " + bean2.getMonsterId());
    }
}
