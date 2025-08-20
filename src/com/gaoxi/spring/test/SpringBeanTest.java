package com.gaoxi.spring.test;

import com.gaoxi.spring.bean.*;
import com.gaoxi.spring.component.MyComponent;
import com.gaoxi.spring.component.UserAction;
import com.gaoxi.spring.component.UserDao;
import com.gaoxi.spring.component.UserService;
import com.gaoxi.spring.component.t.Piggy;
import com.gaoxi.spring.service.MemberServiceImpl;
import com.gaoxi.spring.web.OrderAction;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
@SuppressWarnings({"all"})
public class SpringBeanTest {
    //通过注解来配置bean
    @Test
    public void setBeanByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans05.xml");
        //按照类型从容器中获取对象
        UserDao userDao = ioc.getBean(UserDao.class);
        UserService userService = ioc.getBean(UserService.class);
        UserAction userAction = ioc.getBean(UserAction.class);
        MyComponent myComponent = ioc.getBean(MyComponent.class);
        System.out.println(userDao);
        System.out.println(userAction);
        System.out.println(userService);
        System.out.println(myComponent);
        Piggy piggy = ioc.getBean(Piggy.class);
        System.out.println(piggy);
        //在默认情况下，注解标识的类创建对象后，在容器中，id为类名的首字母小写
        //也可以在类的注解中添加value属性，作为bean id
        Object myComponent1 = ioc.getBean("component1");
        System.out.println(myComponent1);
        System.out.println("ok");
    }

    //测试通过Spring EL表达式对属性赋值
    @Test
    public void setBeanBySpel() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans04.xml");
        SpELBean spELBean = ioc.getBean("spELBean", SpELBean.class);
        System.out.println("spELBean = " + spELBean);
    }

    //测试自动装配对Bean属性赋值
    @Test
    public void setBeanByAutowire() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans03.xml");
        OrderAction orderAction = ioc.getBean("orderAction", OrderAction.class);
        System.out.println("orderAction = " + orderAction);
        //验证了是否自动装配了AutoService
        System.out.println(orderAction.getOrderService());
        //验证了是否自动装配了AutoDao
        System.out.println(orderAction.getOrderService().getOrderDao());
        orderAction.getOrderService().getOrderDao().saveOrder();
    }

    //测试属性文件给bean属性赋值
    @Test
    public void setBeanByFile() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans03.xml");
        Monster monster1000 = ioc.getBean("monster1000", Monster.class);
        System.out.println("monster1000 = " + monster1000);
    }

    //测试bean后置处理器
    @Test
    public void beanPostProcessor() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans02.xml");
        House house = ioc.getBean("house", House.class);
        System.out.println("使用house,house = " + house);
        ((ClassPathXmlApplicationContext)ioc).close();
    }

    //测试Bean的生命周期
    @Test
    public void testBeanLife() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        House house = ioc.getBean("house", House.class);
        System.out.println("使用house=" + house);
        //关闭ioc容器，以调用destroy方法
        //1.ioc的编译类型是接口类型ApplicationContext，运行类型是ClassPathXmlApplicationContext
        //2.因为ClassPathXmlApplication实现了接口ConfigurableApplicationContext
        //3.ConfigurableApplicationContext是有close方法的
        //4.所以将ioc转成ClassPathXmlApplicationContext(向下转型)，再调用close即可
        ((ClassPathXmlApplicationContext)ioc).close();
    }

    //测试Scope
    @Test
    public void testBeanScope() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Cat cat1 = ioc.getBean("cat", Cat.class);
        Cat cat2 = ioc.getBean("cat", Cat.class);
        Cat cat3 = ioc.getBean("cat", Cat.class);
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
    }

    //测试bean创建顺序
    @Test
    public void testBeanByCreate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
    }

    //配置bean通过继承(extends)
    @Test
    public void getBeanByExtends() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster11 = ioc.getBean("monster11", Monster.class);
        System.out.println("monster11 = " + monster11);
//        Monster monster12 = ioc.getBean("monster12", Monster.class);
//        System.out.println("monster12 = " + monster12);
        Monster monster13 = ioc.getBean("monster13", Monster.class);
        System.out.println("monster13 = " + monster13);
    }

    //通过FactoryBean获取bean
    @Test
    public void getBeanByFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster my_monster05 = ioc.getBean("my_monster05", Monster.class);
        System.out.println(my_monster05);
    }

    //通过实例工厂来获取bean
    @Test
    public void getBeanByInstanceFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster my_monster02 = ioc.getBean("my_monster02", Monster.class);
        Monster my_monster03 = ioc.getBean("my_monster02", Monster.class);
        System.out.println("my_monster02=" + my_monster02);
        System.out.println(my_monster02 == my_monster03);
    }

    //通过静态工厂来获取bean
    @Test
    public void getBeanByStaticFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster my_monster01 = ioc.getBean("my_monster01", Monster.class);
        Monster my_monster02 = ioc.getBean("my_monster01", Monster.class);
        System.out.println("my_monster01=" + my_monster01);
        System.out.println(my_monster02 == my_monster01);
    }

    //给属性进行级联赋值
    @Test
    public void setBeanByRelation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Emp emp = ioc.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    //使用util:list名称空间给属性赋值
    @Test
    public void setBeanByUtilList() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        BookStore bookStore = ioc.getBean("bookStore", BookStore.class);
        System.out.println("bookStore:" + bookStore);
    }

    //给集合数组属性进行赋值
    @Test
    public void setBeanByCollection() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Master master = ioc.getBean("master", Master.class);
        System.out.println(master);
    }

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
