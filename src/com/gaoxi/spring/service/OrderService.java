package com.gaoxi.spring.service;

import com.gaoxi.spring.dao.OrderDao;

public class OrderService {
    //OrderDao属性
    private OrderDao orderDao;

    //getter
    public OrderDao getOrderDao() {
        return orderDao;
    }

    //setter
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
