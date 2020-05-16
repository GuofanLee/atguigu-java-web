package com.atguigu.service;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 08:59
 */
public class UserServiceTest {

    private final UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "jack", "jack", "jack@atguigu.com"));
    }

    @Test
    public void login() {
        User user = userService.login("jack", "jack");
        System.out.println(user);
    }

    @Test
    public void existUsername() {
        boolean exist = userService.existUsername("jack");
        System.out.println(exist);
    }
}