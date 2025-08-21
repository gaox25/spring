package com.gaoxi.spring.depinjection;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book>{
    @Override
    public void save() {
        System.out.println("BookDao 的 save()...");
    }
}
