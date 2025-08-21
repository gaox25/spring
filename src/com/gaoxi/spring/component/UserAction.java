package com.gaoxi.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//@Controller标识该类是一个控制器Controller 通常这个类是Servlet
@Controller
public class UserAction {
    //基于注解配置bean，可以使用@Autowired或@Resource进行自动装配
    //1.在ioc容器中查找待装配的组件的类型，如果有唯一的bean匹配(按照类型来的)，则使用该bean装配
    //2.如果带装配的类型对应的bean在ioc容器中有多个，则使用待装配的属性的属性名作为id再进行查找，如果找到就装配
    //  如果找不到，就会按照类型去找，如果该类型在容器中只有一个bean，则装配成功，如果有多个，就报错
    //3.@Autowired+@Qualifier(value="")相当于@Resource(name="")，也可以完成指定名字/id来进行自动装配
    @Autowired
    @Qualifier(value = "userService200")
    //1.@Resource有两个属性比较重要，分别为name和type，name属性为autowire="byName"，type属性为autowire="byType"
    //  使用type属性时使用byType自动注入策略，比如@Resource(type=UserService.class)表示按照UserService.class类型进行装配
    //  这时要求容器中只能有一个UserService对象
    //2.如果@Resource没有指定name和age，则先试用byName注入策略，如果匹配不上，再使用byType注入策略
    //  如果都不成功，就会报错
    //@Resource(name="userService200")
    //@Resource(type=UserService.class)
    //@Resource
    private UserService userService300;
    public void sayOk() {
        System.out.println("UserAction的sayOk()");
        System.out.println("userAction装配的userService属性=" + userService300);
        userService300.hi();
    }
}
