package com.atguigu.utils;

import org.junit.Test;

import java.sql.Connection;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 07:47
 */
public class JdbcUtilsTest {

    @Test
    public void testGetConnection() {
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }

}
