package com.gaoxi.spring.depinjection;
//自定义的泛型类
public abstract class BaseDao<T> {
    public abstract void save();
}
