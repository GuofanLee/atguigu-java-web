package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 03:25
 */
public class WebUtils {

    /**
     * 把 Map 中的值注入到 Java Bean 中
     */
    public static <T> T copyMapToBean(Map<String, ?> map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

}
