package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 07:05
 */
public class JdbcUtils {

    private static DataSource dataSource = null;

    static {
        try {
            Properties properties = new Properties();
            //InputStream resource = ClassLoader.getSystemResourceAsStream("jdbc.properties");
            //InputStream resource = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            //Java web 项目中必须这么写，否则返回的 InputStream 为 null
            InputStream resource = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resource);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据库连接池中获取数据库连接
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将数据库连接放回数据库连接池
     * 从连接池中获取的连接，已经重写了 close() 方法，不会真的关闭连接
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
