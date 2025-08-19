package com.gaoxi.spring.factory;

import com.gaoxi.spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

//实例工厂类
public class MyInstanceFactory {
    private Map<String, Monster> monster_map;
    //通过普通代码块进行初始化
    {
        monster_map = new HashMap<>();
        monster_map.put("monster03", new Monster(100, "牛魔王", "芭蕉扇"));
        monster_map.put("monster04", new Monster(200, "孙悟空", "金箍棒"));
    }
    //写一个方法返回Monster对象
    public Monster getMonster(String key) {
        return monster_map.get(key);
    }
}
