package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if (user != null) {
            //登录成功，保存用户信息到 Session 域中
            request.getSession().setAttribute("user", user);
            //返回登录成功页面
            response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
        } else {
            //用户名或密码错误，登录失败，返回登陆页面
            //把错误信息和表单信息保存到 request 域中，用于页面回显
            request.setAttribute("msg", "用户名或密码错误！");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    /**
     * 用户注册功能
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、从 session 域中获取验证码的真实值
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //2、立即从 session 域中删除该验证码，以免该验证码被第二次使用
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //3、从请求参数中获取用户输入的验证码
        String code = request.getParameter("code");
        //4、封装请求参数
        User user = WebUtils.copyMapToBean(request.getParameterMap(), new User());
        //5、判断用户填写的验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            //6、检查用户名是否已被注册
            if (userService.existUsername(user.getUsername())) {
                //把错误信息和表单信息保存到 request 域中，用于页面回显
                request.setAttribute("msg", "用户名已存在！");
                request.setAttribute("username", user.getUsername());
                request.setAttribute("password", user.getPassword());
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //7、保存用户信息
                userService.registerUser(user);
                //将插入后带有id的用户信息查询出来
                user = userService.login(user.getUsername(), user.getPassword());
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
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

    /**
     * 用户注销功能
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、销毁 Session
        request.getSession().invalidate();
        //2、重定向到首页
        response.sendRedirect(request.getContextPath());
    }

}
