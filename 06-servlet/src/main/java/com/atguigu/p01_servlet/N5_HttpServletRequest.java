package com.atguigu.p01_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-08 20:36
 */
public class N5_HttpServletRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        //获取请求 URI
        System.out.println("请求 URI：" + req.getRequestURI());
        //获取请求 URL
        System.out.println("请求 URL：" + req.getRequestURL());
        //获取工程根路径
        System.out.println("工程根路径：" + req.getContextPath());
        //获取客户端 IP 地址
        System.out.println("客户端 IP 地址：" + req.getRemoteHost());
        //获取请求头中的 user-agent
        System.out.println("请求头中的 user-agent：" + req.getHeader("user-agent"));
        //获取请求方式
        System.out.println("请求方式：" + req.getMethod());
        //获取请求参数
        System.out.println("获取请求参数 userName：" + req.getParameter("userName"));
        System.out.println("获取请求参数 password：" + req.getParameter("password"));
        System.out.println("获取请求参数 hobby：" + Arrays.toString(req.getParameterValues("hobby")));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符集，解决 Post 请求中的中文乱码问题，需要在获取第一个请求参数前设置才会有效
        req.setCharacterEncoding("UTF-8");
        //获取请求方式
        System.out.println("请求方式：" + req.getMethod());
        //获取请求参数
        System.out.println("获取请求参数 userName：" + req.getParameter("userName"));
        System.out.println("获取请求参数 password：" + req.getParameter("password"));
        System.out.println("获取请求参数 hobby：" + Arrays.toString(req.getParameterValues("hobby")));
    }
}
