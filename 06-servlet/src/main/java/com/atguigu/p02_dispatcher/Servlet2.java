package com.atguigu.p02_dispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示请求转发
 *
 * @author GuofanLee
 * @date 2020-05-09 01:19
 */
public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet2获取请求参数，相当于柜台2拿到办事材料
        String userName = request.getParameter("userName");
        //在Servlet2中查看参数，相当于柜台2查看办事材料
        System.out.println("在 Servlet2 中查看参数：" + userName);
        //Servlet2获取并查看Servlet1是否有设置Attribute，相当于柜台2查看柜台1是否有盖章
        Object value = request.getAttribute("key");
        System.out.println("在Servlet2中查看Servlet1设置的域数据：" + value);
        //Servlet2处理自己的业务，相当于柜台2办理自己的业务
        System.out.println("Servlet2处理自己的业务");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}