package com.gaoxi.spring.test;

import com.gaoxi.spring.bean.Monster;
import com.gaoxi.spring.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class SpringBeanTest {

    //通过内部Bean来设置bean属性
    @Test
    public void setBeanByInnerBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        MemberServiceImpl memberServiceImpl = (MemberServiceImpl) ioc.getBean("memberService02");
        memberServiceImpl.add();
    }

    //通过ref来设置bean属性
    @Test
    public void setBeanByRef() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        MemberServiceImpl memberServiceImpl = (MemberServiceImpl) ioc.getBean("memberService");
        memberServiceImpl.add();
    }

    //演示通过Bean的类型来获取对象
//    @Test
//    public void getBeanByType() {
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
//        //直接传入一个Class对象/类型
//        Monster monster = ioc.getBean(Monster.class);
//        System.out.println("monster = " + monster);
//    }
    //演示通过指定构造器来设置属性，构造器设置的属性在bean.xml中
    @Test
    public void setBeanByConstructor() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Object monster03 = ioc.getBean("monster03");
        System.out.println("monster03 = " + monster03);
    }

    //通过p名称空间来设置属性
    @Test
    public void setBeanByPNameSpace() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Object monster06 = ioc.getBean("monster06");
        System.out.println("monster06 = " + monster06);
    }

    @Test
    public void getMonster() {
        //1.创建容器ApplicationContext
        //2.该容器和容器配置文件是关联的
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        //3.通过getBean获取对应的对象，默认返回的是一个Object，但是运行类型是Monster
        //Object monster01 = ioc.getBean("monster01");
        //Monster monster01 = (Monster) ioc.getBean("monster01");
        Monster monster01 = ioc.getBean("monster01", Monster.class);
        //4.输出
        System.out.println("monster01:" + monster01);
        System.out.println("属性name:" + monster01.getName());
        //5.可以重复获取
        Object monster2 = ioc.getBean("monster01", Monster.class);
        System.out.println(monster2);
        //6.查看容器注入了哪些bean对象，并输出bean的id
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String str : beanDefinitionNames) {
            System.out.print(str + "\t");
        }

    }
    //验证类加载路径
    @Test
    public void classPath() {
        File file = new File(this.getClass().getResource("/").getPath());
        //看到类的加载路径
        System.out.println("file="+file);
    }
}
