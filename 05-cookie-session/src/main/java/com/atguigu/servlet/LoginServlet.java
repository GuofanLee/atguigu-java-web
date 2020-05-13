package com.atguigu.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-13 21:20
 */
public class LoginServlet extends BaseServlet {

    /**
     * 创建 Cookie
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (true) {
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            System.out.println("登录成功");
        } else {
            //登录失败
            System.out.println("登录失败");
        }
    }

}
