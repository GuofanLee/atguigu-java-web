package com.atguigu.p01_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-08 15:17
 */
public class N3_ServletConfig extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过 ServletConfig 获取 Servlet 的别名 servlet-name 的值
        String servletName = getServletConfig().getServletName();
        System.out.println("servletName：" + servletName);
        //通过 GenericServlet 类中现成的方法获取 Servlet 的别名 servlet-name 的值
        servletName = getServletName();
        System.out.println("servletName：" + servletName);

        //通过 ServletConfig 获取 Servlet 的初始化参数 init-param
        String key1 = getServletConfig().getInitParameter("key1");
        System.out.println("servlet 初始化参数 init-param：" + key1);
        //通过 GenericServlet 类中现成的方法获取 Servlet 的初始化参数 init-param
        String key2 = getInitParameter("key2");
        System.out.println("servlet 初始化参数 init-param：" + key2);

        //通过 ServletConfig 获取 ServletContext 对象
        getServletConfig().getServletContext();
        //通过 GenericServlet 类中现成的方法获取 ServletContext 对象
        getServletContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
