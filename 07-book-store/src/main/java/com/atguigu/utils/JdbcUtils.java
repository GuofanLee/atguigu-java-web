package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 07:05
 */
public class JdbcUtils {

    private static DataSource dataSource = null;

    private static final ThreadLocal<Connection> CONNECTIONS = new ThreadLocal<>();

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
     * 从 ThreadLocal 中获取数据库连接
     */
    public static Connection getConnection() {
        //从 ThreadLocal 中获取数据库连接
        Connection connection = CONNECTIONS.get();
        if (connection == null) {
            try {
                //从数据库连接池中获取数据库连接
                connection = dataSource.getConnection();
                //关闭自动提交事务
                connection.setAutoCommit(false);
                //将数据库连接池存入到 ThreadLocal 中
                CONNECTIONS.set(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交事务，并关闭数据库连接
     */
    public static void commitAndClose() {
        Connection connection = CONNECTIONS.get();
        if (connection != null) {
            try {
                connection.commit();
                //不需要手动恢复自动提交，释放连接后，会自动恢复自动提交
                //connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //数据库连接池使用完，一定要将其从 ThreadLocal 中删除
        CONNECTIONS.remove();
    }

    /**
     * 回滚事务，并关闭数据库连接
     */
    public static void rollbackAndClose() {
        Connection connection = CONNECTIONS.get();
        if (connection != null) {
            try {
                connection.rollback();
                //不需要手动恢复自动提交，释放连接后，会自动恢复自动提交
                //connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //数据库连接池使用完，一定要将其从 ThreadLocal 中删除
        CONNECTIONS.remove();
    }

}
