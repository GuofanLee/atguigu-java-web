package com.atguigu.p01_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 04:41
 */
public class N6_HttpServletResponse extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置 Tomcat 服务器使用 UTF-8 编码，同时设置响应头的 Content-Type，告诉服务器也使用 UTF-8 编码
        response.setContentType("text/html;charset=UTF-8");
        //上面这行代码也必须在获取响应流之前调用
        PrintWriter writer = response.getWriter();
        writer.write("响应中文字符");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
