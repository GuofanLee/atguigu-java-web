package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 08:55
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean existUsername(String username) {
        return userDao.getUserByUsername(username) != null;
    }

}
