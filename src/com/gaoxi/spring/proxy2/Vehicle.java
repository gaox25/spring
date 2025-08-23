package com.gaoxi.spring.proxy2;

public interface Vehicle {
    //动态代理解决思路，在调用方法时，使用反射机制，根据方法去决定调用哪个对象方法
    public void run();
    public String fly(int height);
}
