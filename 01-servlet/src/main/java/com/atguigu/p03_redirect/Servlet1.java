package com.atguigu.p03_redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示请求重定向
 *
 * @author GuofanLee
 * @date 2020-05-09 01:16
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet1 执行了");
        /*
         * 重定向方式一
         */
        //设置响应状态码：302，表示重定向
        //response.setStatus(302);
        //设置响应头，指定重定向的地址
        //response.setHeader("Location", "http://localhost:8080/01-servlet/response2");

        /*
         * 重定向方式二
         */
        response.sendRedirect("http://localhost:8080/01-servlet/response2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
