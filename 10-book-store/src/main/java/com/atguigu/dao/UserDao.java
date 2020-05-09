package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 08:20
 */
public interface UserDao {

    /**
     * 保存用户信息
     */
    int saveUser(User user);

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     */
    User getUserByUsernameAndPassword(String username, String password);

}
