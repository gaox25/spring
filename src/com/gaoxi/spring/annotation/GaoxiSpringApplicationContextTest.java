package com.gaoxi.spring.annotation;

import com.gaoxi.spring.component.MyComponent;
import com.gaoxi.spring.component.UserAction;
import com.gaoxi.spring.component.UserDao;
import com.gaoxi.spring.component.UserService;
import com.gaoxi.spring.gaoxiapplicationcontext.GaoxiApplicationContext;

public class GaoxiSpringApplicationContextTest {
    public static void main(String[] args) {
        GaoxiSpringApplicationContext ioc = new GaoxiSpringApplicationContext(GaoxiSpringConfig.class);
        System.out.println("ok");
        UserAction userAction = (UserAction) ioc.getBean("userAction");
        UserDao userDao = (UserDao) ioc.getBean("userDao");
        UserService userService = (UserService) ioc.getBean("userService");
        MyComponent myComponent = (MyComponent) ioc.getBean("myComponent");
        System.out.println("userAction = " + userAction);
        System.out.println("userDao = " + userDao);
        System.out.println("userService = " + userService);
        System.out.println("myComponent = " + myComponent);
    }
}
