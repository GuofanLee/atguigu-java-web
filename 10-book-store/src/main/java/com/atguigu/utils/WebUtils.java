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

    /**
     * 将 String 转为 int，转换失败返回默认值
     */
    public static int parseStringToInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

}
