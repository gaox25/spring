package com.gaoxi.spring.factory;

import com.gaoxi.spring.bean.Monster;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

//FactorBean
public class MyFactoryBean implements FactoryBean<Monster> {
    //key就是你配置时，指定要获取的对象对应key
    private String key;
    private Map<String, Monster> monster_map;
    //代码块完成初始化任务
    {
        monster_map = new HashMap<>();
        monster_map.put("monster03", new Monster(100, "牛魔王", "芭蕉扇"));
        monster_map.put("monster04", new Monster(200, "孙悟空", "金箍棒"));
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public Monster getObject() throws Exception {
        return monster_map.get(key);
    }

    @Override
    public Class<?> getObjectType() {
        return Monster.class;
    }

    @Override
    public boolean isSingleton() {//这里指定是否返回是单例
        return true;
    }
}
