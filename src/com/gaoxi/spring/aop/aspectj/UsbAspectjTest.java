package com.gaoxi.spring.aop.aspectj;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsbAspectjTest {
    @Test
    public void testUsbAspectProxy() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans08.xml");
        UsbInterface usbInterface1 = (UsbInterface) ioc.getBean("camera");
        UsbInterface usbInterface2 = (UsbInterface) ioc.getBean("phone");
        usbInterface1.work();
        usbInterface2.work();
    }
}
