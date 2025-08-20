package com.gaoxi.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//这是一个后置处理器类
public class MyBeanPostProcessor implements BeanPostProcessor {
    //什么时候被调用：在bean的init方法前调用
    //bean 传入的bean 是在IOC容器中创建/配置的bean
    //beanName 传入的在IOC容器中创建/配置Bean的id
    //Object 程序员对传入的bean进行修改/处理(如果有需要的话)，返回
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization()... bean=" + bean + " beanName=" + beanName);
        //初步体验案例：如果类型是House，统一改成 上海豪宅
        //对多个对象进行处理/编程->切面编程
        if (bean instanceof House) {
            ((House)bean).setName("上海豪宅");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    //什么时候被调用：在bean的init方法后调用
    //bean 传入的bean 是在IOC容器中创建/配置的bean
    //beanName 传入的在IOC容器中创建/配置Bean的id
    //Object 程序员对传入的bean进行修改/处理(如果有需要的话)，返回
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization()... bean=" + bean + " beanName=" + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
