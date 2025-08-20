package com.gaoxi.spring.web;

import com.gaoxi.spring.service.OrderService;

//Servlet就是Controller
public class OrderAction {
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService2(OrderService orderService) {
        this.orderService = orderService;
    }
}
