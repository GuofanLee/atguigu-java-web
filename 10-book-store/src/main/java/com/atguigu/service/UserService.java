package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 08:52
 */
public interface UserService {

    /**
     * 注册用户
     */
    void registerUser(User user);

    /**
     * 用户登录
     */
    User login(String username, String password);

    /**
     * 检查用户名是否可用
     */
    boolean existUsername(String username);

}
