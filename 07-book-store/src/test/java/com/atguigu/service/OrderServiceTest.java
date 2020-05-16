package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 01:34
 */
public class OrderServiceTest {

    private final OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Python", 1, new BigDecimal(5), new BigDecimal(5)));
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        String orderId = orderService.createOrder(cart, 1);
        System.out.println("订单号：" + orderId);
        System.out.println(cart);
    }

}