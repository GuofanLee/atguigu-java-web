package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-16 22:08
 */
public class I18nTest {

    @Test
    public void testLocal() {
        //获取操作系统默认的语言信息
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale);  //当前默认即为：zh_CN
        //获取中国对应的 Local 对象
        Locale chinaLocale = Locale.CHINA;
        System.out.println(chinaLocale);         //zh_CN
        //获取美国对应的 Local 对象
        Locale usLocale = Locale.US;
        System.out.println(usLocale);           //en_US
    }

    @Test
    public void testI18n() {
        //英文-美国
        Locale usLocale = Locale.US;
        //通过 baseName 和 local 对象，读取相应的配置文件
        ResourceBundle usBundle = ResourceBundle.getBundle("i18n", usLocale);
        String usUsername = usBundle.getString("username");
        System.out.println("usUsername：" + usUsername);
        //中文-中国
        Locale zhLocale = Locale.CHINA;
        //通过 baseName 和 local 对象，读取相应的配置文件
        ResourceBundle zhBundle = ResourceBundle.getBundle("i18n", zhLocale);
        String zhUsername = zhBundle.getString("username");
        System.out.println("zhUsername：" + zhUsername);
    }

}
