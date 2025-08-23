package com.gaoxi.spring.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings({"all"})
//该类可以返回一个代理对象
public class VehicleProxyProvider {
    //定义一个属性，将来真正要执行的对象，赋给它
    //target_vehicle表示真正要执行的对象，要求该对象的类实现了Vehicle接口
    private Vehicle target_vehicle;

    //构造器
    public VehicleProxyProvider(Vehicle target_vehicle) {
        this.target_vehicle = target_vehicle;
    }

    //编写一个方法，可以返回一个代理对象
    //1.这个方法非常重要，理解有一定难度
    public Vehicle getProxy() {
        //得到类加载器
        ClassLoader classLoader = target_vehicle.getClass().getClassLoader();

        //得到要代理的对象/被执行对象 的接口信息，底层是通过接口来完成调用
        Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();

        //创建InvocationHandler对象
        //因为InvocationHandler是接口，所以可以通过匿名对象的方式来创建该对象
        //invoke方法是将来执行target_vehicle的方法时，会调用到
        /*
         1.o表示代理对象
         2.method 就是通过代理对象调用方法时，的哪个方法，代理对象.run()
         3.args 表示调用 代理对象.run(xx) 传入的参数
         4.return 表示代理对象.run(xx)执行后的结果
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行了...");
                //这里是反射基础
                //1.method是 public abstract void com.gaoxi.spring.proxy2.Vehicle.run()
                //2.target_vehicle是 Ship对象 Ship@1706
                //3.args是 null，因为没有传值
                //这里通过反射+动态绑定机制，就会执行到被代理对象的方法
                Object result = method.invoke(target_vehicle, args);
                System.out.println("交通工具停止运行了...");
                return result;
            }
        };

        //Proxy类创建一个代理对象
        /*
         public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
         分析：
         1.newProxyInstance()方法可以返回一个代理对象
         2.ClassLoader loader：类的加载器，当前类的就行
         3.Class<?>[] interfaces：就是将来要代理的对象的接口信息，这里就是Vehicle的信息
         4.InvocationHandler h 调用处理器/对象 有一个非常重要的方法invoke()，可以通过反射来执行
         */
        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return (Vehicle) proxyInstance;
    }
}
