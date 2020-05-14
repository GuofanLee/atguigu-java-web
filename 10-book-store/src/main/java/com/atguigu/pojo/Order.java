package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 00:57
 */
public class Order {

    private String orderId;
    private Date createTime;
    private BigDecimal totalPrice;
    //订单状态：0-未发货；1-已发货；2-已签收
    private Integer status = 0;
    private Integer userId;

    public Order() {}

    public Order(String orderId, Date createTime, BigDecimal totalPrice, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.totalPrice = totalPrice;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(createTime, order.createTime) &&
                Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(status, order.status) &&
                Objects.equals(userId, order.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, createTime, totalPrice, status, userId);
    }

}
