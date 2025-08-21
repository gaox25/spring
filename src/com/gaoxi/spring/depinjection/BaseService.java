package com.gaoxi.spring.depinjection;

import org.springframework.beans.factory.annotation.Autowired;
//自定义泛型类
public abstract class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    public void save() {
        baseDao.save();
    }
}
