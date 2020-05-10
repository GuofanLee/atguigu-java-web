package com.atguigu.p02_dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示请求转发
 *
 * @author GuofanLee
 * @date 2020-05-09 01:16
 */
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet1获取请求参数，相当于柜台1拿到办事材料
        String userName = request.getParameter("userName");
        //在Servlet1中查看参数，相当于柜台1查看办事材料
        System.out.println("在 Servlet1 中查看参数：" + userName);
        //在Servlet1中设置Attribute，相当于柜台1给材料盖个章
        request.setAttribute("key", "value");
        /*
         * Servlet1寻找转发目标Servlet2，相当于柜台1寻找柜台2在哪
         * getRequestDispatcher 的入参为 Servlet2 的 url-pattern，必须以 / 开头
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/request2");
        //Servlet1将请求转发给Servlet2，相当于柜台1将材料交给柜台2
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
