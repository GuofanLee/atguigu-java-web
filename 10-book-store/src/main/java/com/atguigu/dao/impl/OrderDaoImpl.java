package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 01:05
 */
public class OrderDaoImpl extends BaseDao<OrderDao> implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order (order_id, create_time, total_price, status, user_id) values (?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getTotalPrice(), order.getStatus(), order.getUserId());
    }

}
