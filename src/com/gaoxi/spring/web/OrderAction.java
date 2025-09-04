package com.gaoxi.spring.web;

import com.gaoxi.spring.service.OrderService;

import java.lang.reflect.InvocationHandler;

//Servlet就是Controller
public class OrderAction {
    public static void main(String[] args) {
        int result = countDigits(121);
        System.out.println(result);
        int[] array = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        int result1 = arraySign(array);
        System.out.println(result1);
    }
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService2(OrderService orderService) {
        this.orderService = orderService;
    }

    public static int countDigits(int num) {
        int count = 0;
        String str1 = num + "";
        String[] strs = str1.split("");
        for (String str : strs) {
            if (num % Integer.parseInt(str) == 0) {
                count++;
            }
        }
        return count;
    }

    public static int arraySign(int[] nums) {
        long temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp *= nums[i];
        }
        return signFunc(temp);
    }
    public static int signFunc(long x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
