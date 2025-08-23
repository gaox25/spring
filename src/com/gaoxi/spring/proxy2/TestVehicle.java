package com.gaoxi.spring.proxy2;

import org.junit.jupiter.api.Test;

public class TestVehicle {
    @Test
    public void run() {
        Vehicle car = new Car();
        Vehicle ship = new Ship();
        //动态绑定
        car.run();
        System.out.println();
        ship.run();
    }

    //
    @Test
    public void proxyRun() {
        Vehicle vehicle = new Ship();
        //创建了VehicleProxyProvider对象，并且传入了要代理的对象
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(vehicle);
        //获取代理对象，该对象可以代理执行方法
        //proxy的编译类型是Vehicle，运行类型是代理类型class com.sun.proxy.$Proxy8
        Vehicle proxy = vehicleProxyProvider.getProxy();
        System.out.println("proxy的编译类型是：Vehicle");
        System.out.println("proxy的运行类型为：" + proxy.getClass());
        /*
         执行run()，并没有进入到Ship类的run方法，而是进入了代理对象proxy的invoke方法，
         之后通过反射来执行vehicle对象的方法
         */
        //proxy的编译类型为Vehicle，运行类型是class com.sun.proxy.$Proxy8
        //所以当执行run方法时，会执行到代理对象的invoke方法中
        //如何体现动态
        //1.target_vehicle可以变
        //2.method可以变
        proxy.run();
        String result = proxy.fly(10000);
    }
}
