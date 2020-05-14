package com.atguigu.dao;

import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 01:12
 */
public class OrderDaoTest {

    private final OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        Order order = new Order(UUID.randomUUID().toString(), new Date(), new BigDecimal(10), 0, 1);
        orderDao.saveOrder(order);
    }

}