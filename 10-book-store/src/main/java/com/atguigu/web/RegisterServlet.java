package com.atguigu.web;

import com.atguigu.pojo.User;
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
 * @date 2020-05-09 18:08
 */
public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //2、检查验证码是否正确，现在是写死的
        if ("bnbnp".equalsIgnoreCase(code)) {
            //3、检查用户名是否已被注册
            if (userService.existUsername(username)) {
                System.out.println("用户名：" + username + " 已被注册，返回注册页面");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
            } else {
                //4、用户名未被注册
                userService.registerUser(new User(null, username, password, email));
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
            }
        } else {
            //验证码不正确，跳回注册页面
            System.out.println("验证码：" + code + " 错误，返回注册页面");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
