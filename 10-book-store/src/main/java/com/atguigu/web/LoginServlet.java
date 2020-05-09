package com.atguigu.web;

import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-09 20:52
 */
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2、校验用户名密码是否正确
        if (userService.login(username, password) != null) {
            //登录成功，返回登录成功页面
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request, response);
        } else {
            //用户名或密码失败，登录失败，返回登陆页面
            System.out.println("用户名或密码失败，登录失败，返回登陆页面");
            request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
