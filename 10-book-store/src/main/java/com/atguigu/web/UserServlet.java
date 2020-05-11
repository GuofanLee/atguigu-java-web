package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 01:42
 */
public class UserServlet extends BaseServlet {

    private final UserService userService = new UserServiceImpl();

    /**
     * 用户登录功能
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取请求参数
        User user = WebUtils.copyMapToBean(request.getParameterMap(), new User());
        //2、校验用户名密码是否正确
        if (userService.login(user.getUsername(), user.getPassword()) != null) {
            //登录成功，返回登录成功页面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            //用户名或密码错误，登录失败，返回登陆页面
            //把错误信息和表单信息保存到 request 域中，用于页面回显
            request.setAttribute("msg", "用户名或密码错误！");
            request.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    /**
     * 用户注册功能
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取请求参数
        User user = WebUtils.copyMapToBean(request.getParameterMap(), new User());
        //验证码
        String code = request.getParameter("code");
        //2、检查验证码是否正确，现在是写死的
        if ("bnbnp".equalsIgnoreCase(code)) {
            //3、检查用户名是否已被注册
            if (userService.existUsername(user.getUsername())) {
                //把错误信息和表单信息保存到 request 域中，用于页面回显
                request.setAttribute("msg", "用户名已存在！");
                request.setAttribute("username", user.getUsername());
                request.setAttribute("password", user.getPassword());
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //4、用户名未被注册
                userService.registerUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            //验证码不正确，跳回注册页面
            //把错误信息和表单信息保存到 request 域中，用于页面回显
            request.setAttribute("msg", "验证码错误！");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

}
