package com.gaoxi.spring.proxy2;

public class Car implements Vehicle{
    @Override
    public void run() {
        /*
         System.out.println("交通工具开始运行了....");
         System.out.println("xxxxx running....");
         System.out.println("交通工具停止运行了....");
         这些内容就可以理解为切面
         扩展来说，就是执行不同的对象的不同方法前后，要执行的一样的操作
         比如，执行前检查权限，执行后写入日志
         此处引出动态代理，进而引出AOP，理解了AOP，才会真正理解AOP
         */
        //System.out.println("交通工具开始运行了....");
        System.out.println("小汽车在路上 running....");
        //System.out.println("交通工具停止运行了....");
    }

    @Override
    public String fly(int height) {
        System.out.println("小汽车可以飞翔，高度=" + height);
        return "小汽车可以飞翔，高度=" + height;
    }
}
