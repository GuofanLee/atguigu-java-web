package com.atguigu.p01_servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-04-09 00:25
 */
public class N1_HelloServlet implements Servlet {

    public N1_HelloServlet() {
        System.out.println("1、构造方法执行了！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2、初始化方法执行了！");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3、service方法执行了！");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            System.out.println("GET请求");
        } else if ("POST".equals(method)) {
            System.out.println("POST请求");
        } else {
            System.out.println(method + "请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、destroy方法执行了！");
    }

}
