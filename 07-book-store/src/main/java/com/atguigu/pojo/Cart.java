package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车
 *
 * @author GuofanLee
 * @date 2020-05-14 21:07
 */
public class Cart {

    private final Map<Integer, CartItem> items = new LinkedHashMap<>();

    /**
     * 添加商品项
     */
    public void addItem(CartItem cartItem) {
        //查看购物车中是否已经添加过此商品
        CartItem item = items.get(cartItem.getId());
        //如果未添加，则添加该商品到集合中
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            //如果已添加，则商品数量累加，并更新总金额
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 增加商品数量
     */
    public void updateCount(Integer id, Integer count) {
        //先查看购物车中是否有此商品
        CartItem item = items.get(id);
        //如果有，则修改商品数量，并更新总金额
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 获取购物车中商品总数量
     */
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }

    /**
     * 获取购物车中商品总价格
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item : items.values()) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

}
