package com.gaoxi.spring.gaoxiapplicationcontext;

import com.gaoxi.spring.bean.Monster;
import org.dom4j.DocumentException;

public class GaoxiApplicationContextTest {
    public static void main(String[] args) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        GaoxiApplicationContext ioc = new GaoxiApplicationContext("beans.xml");
        Monster monster01 = (Monster) ioc.getBean("monster01");
        System.out.println("monster01 = " + monster01);
        System.out.println("monster01.name = " + monster01.getName());
        System.out.println("ok");
    }
}
