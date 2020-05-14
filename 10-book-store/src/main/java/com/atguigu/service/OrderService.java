package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 01:22
 */
public interface OrderService {

    String createOrder(Cart cart, Integer userId);

}
