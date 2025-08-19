package com.gaoxi.spring.factory;

import com.gaoxi.spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

//静态工厂类-可以返回Monster对象
public class MyStaticFactory {
    private static Map<String, Monster> monsterMap;
    //使用static代码块进行初始化
    static {
         monsterMap = new HashMap<>();
         monsterMap.put("monster01", new Monster(100, "牛魔王", "芭蕉扇"));
         monsterMap.put("monster02", new Monster(200, "孙悟空", "金箍棒"));
    }
    //提供一个方法，返回Monster对象
    public static Monster getMonster(String key) {
        return monsterMap.get(key);
    }
}
