package com.atguigu.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-13 16:52
 */
public class CookieServlet extends BaseServlet {

    /**
     * 创建 Cookie
     */
    public void createCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、创建 Cookie 对象
        Cookie cookie = new Cookie("key1", "value1");
        //2、通知客户端保存 Cookie
        response.addCookie(cookie);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("Cookie创建成功");
        //如有必要，Cookie 可以一次性创建多个
        Cookie cookie2 = new Cookie("key2", "value2");
        response.addCookie(cookie2);
    }

    /**
     * 获取 Cookie
     */
    public void getCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        //要得到想要的 Cookie，只能通过遍历
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                response.getWriter().write("Cookie:[" + cookie.getName() + "=" + cookie.getValue() + "]\r\n");
            }
        }
    }

    /**
     * 修改 Cookie
     */
    public void updateCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //方案一：new 一个与要修改的 Cookie 同名的 Cookie，同时赋予新值，再将其设置到 response 中
        Cookie cookie = new Cookie("key1", "newValue1");
        response.addCookie(cookie);
        //方案二：从客户端传过来的 Cookie 中找到要修改的 Cookie，并为其赋予新值，再将其设置到 response 中
        Cookie[] cookies = request.getCookies();
        Cookie cookieToUpdate = null;
        for (Cookie cookie1 : cookies) {
            if ("key2".equals(cookie1.getName())) {
                cookieToUpdate = cookie1;
            }
        }
        if (cookieToUpdate != null) {
            cookieToUpdate.setValue("newValue2");
            response.addCookie(cookieToUpdate);
        }
    }

    /**
     * 测试 Cookie 默认过期时间
     */
    public void defaultAge(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //不指定过期时间（默认为 -1）：关闭浏览器即过期
        Cookie cookie1 = new Cookie("defaultAge1", "defaultAge1");
        response.addCookie(cookie1);
        //指定过期过期时间为 -1：关闭浏览器即过期
        Cookie cookie2 = new Cookie("defaultAge2", "defaultAge2");
        cookie1.setMaxAge(-1);
        response.addCookie(cookie2);
    }

    /**
     * 删除 Cookie
     */
    public void deleteCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie cookie1 = new Cookie("defaultAge1", "defaultAge1");
        cookie1.setMaxAge(0);
        Cookie cookie2 = new Cookie("defaultAge2", "defaultAge2");
        cookie2.setMaxAge(0);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    /**
     * 设置 Cookie 过期时间
     */
    public void setMaxAge(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie cookie = new Cookie("expire10", "expire10");
        //设置 Cookie 过期时间为 30 秒
        cookie.setMaxAge(30);
        response.addCookie(cookie);
    }

    /**
     * 设置 Cookie 的 path 属性为 /工程路径/abc
     */
    public void setCookiePath(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie cookie = new Cookie("pathCookie", "pathCookie");
        cookie.setPath(request.getContextPath() + "/abc");
        response.addCookie(cookie);
    }

}
