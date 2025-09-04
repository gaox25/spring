package com.gaoxi.spring.aop.aspectj;

import org.springframework.stereotype.Component;

@Component //将Camera作为组件注入到容器中
public class Camera implements UsbInterface {
    @Override
    public void work() {
        System.out.println("Camera.work()");
    }
}
