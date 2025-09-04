package com.gaoxi.spring.aop.aspectj;

import org.springframework.stereotype.Component;

@Component //将Phone作为组件注入到容器中
public class Phone implements UsbInterface {
    @Override
    public void work() {
        System.out.println("Phone.work()");
    }
}
