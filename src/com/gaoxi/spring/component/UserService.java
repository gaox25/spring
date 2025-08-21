package com.gaoxi.spring.component;

import org.springframework.stereotype.Service;
//@Service表示该类是一个Service类
@Service
public class UserService {
    public void hi() {
        System.out.println("UserService hi()~");
    }
}
