package com.atguigu.dao;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 08:41
 */
public class UserDaoTest {

    private final UserDao userDao = new UserDaoImpl();

    @Test
    public void saveUser() {
        User user = new User(null, "tom", "tom", "tom@atguigu.com");
        int i = userDao.saveUser(user);
        System.out.println(i);
    }

    @Test
    public void getUserByUsername() {
        User admin = userDao.getUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void getUserByUsernameAndPassword() {
        User admin = userDao.getUserByUsernameAndPassword("admin", "admin");
        System.out.println(admin);
    }

}