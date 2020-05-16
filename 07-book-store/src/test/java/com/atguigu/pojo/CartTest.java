package com.atguigu.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-14 22:14
 */
public class CartTest {

    Cart cart = new Cart();

    @Test
    public void addItem() {
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Python", 1, new BigDecimal(5), new BigDecimal(5)));
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Python", 1, new BigDecimal(5), new BigDecimal(5)));
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Python", 1, new BigDecimal(5), new BigDecimal(5)));
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "Python", 1, new BigDecimal(5), new BigDecimal(5)));
        cart.addItem(new CartItem(1, "Java", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.updateCount(2, 2);
        System.out.println(cart);
    }

}