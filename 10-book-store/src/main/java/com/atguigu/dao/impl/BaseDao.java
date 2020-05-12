package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 07:57
 */
public abstract class BaseDao<T> {

    private final Class<T> clazz;

    {
        //获取当前BaseDao的子类继承的带泛型的父类的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取所有泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        //获取第一个泛型参数
        clazz = (Class<T>) actualTypeArguments[0];
    }

    /**
     * 使用 commons-dbutils 的 QueryRunner 操作数据库
     */
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行增、删、改操作
     *
     * @return 返回 -1 说明执行失败，返回其它表示影响的行数
     */
    public int update(String sql, Object... params) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询一条纪律
     *
     * @return 返回查询的数据，返回 null 说明执行失败
     */
    public T queryForOne(String sql, Object... params) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询多条记录
     *
     * @return 返回查询的数据，返回 null 说明执行失败
     */
    public List<T> queryForList(String sql, Object... params) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询单值数据
     *
     * @return 返回查询的数据，返回 null 说明执行失败
     */
    public <E> E queryForValue(String sql, Object... params) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
