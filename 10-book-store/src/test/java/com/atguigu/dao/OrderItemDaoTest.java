package com.atguigu.dao;

import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 01:16
 */
public class OrderItemDaoTest {

    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        OrderItem orderItem = new OrderItem(null, "Java", 2, new BigDecimal(5), new BigDecimal(10), "193bacd6-22a8-49b4-9e29-f41abd3fd759");
        orderItemDao.saveOrderItem(orderItem);
    }

}