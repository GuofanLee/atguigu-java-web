package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 08:25
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user (username, password, email) values (?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "select id, username, password, email from t_user where username = ?";
        return queryForOne(sql, username);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        String sql = "select id, username, password, email from t_user where username = ? and password = ?";
        return queryForOne(sql, username, password);
    }

}
