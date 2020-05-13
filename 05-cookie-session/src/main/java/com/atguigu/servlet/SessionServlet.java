package com.atguigu.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-14 01:03
 */
public class SessionServlet extends BaseServlet {

    /**
     * 创建、获取 Session 演示
     */
    public void createAndGetSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //创建、获取 Session
        HttpSession session = request.getSession();
        //判断当前 Session 对象是否是新创建的
        boolean isNew = session.isNew();
        //获取 Session 的 id
        String id = session.getId();
        response.getWriter().write("session is new: " + isNew + "\r");
        response.getWriter().write("session id: " + id);
    }

    /**
     * Session 域存储数据
     */
    public void setAttribute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //Session 域存储数据
        session.setAttribute("username", "liguofan");
        response.getWriter().write("Session 域中保存数据成功");
    }

    /**
     * Session 域获取数据
     */
    public void getAttribute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //Session 域获取数据
        Object username = session.getAttribute("username");
        response.getWriter().write("从 Session 域中获取的 username：" + username);
    }

    /**
     * Session 默认过期时间
     */
    public void defaultTime(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int maxInactiveInterval = session.getMaxInactiveInterval();
        response.getWriter().write("Session 默认过期时间：" + maxInactiveInterval + "秒");
    }

    /**
     * 设置 Session 过期时间
     */
    public void setTime(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10);
        response.getWriter().write("当前 Session 过期时间为：" + session.getMaxInactiveInterval() + "秒");
    }

    /**
     * 设置 Session 立即失效
     */
    public void sessionInvalidate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.invalidate();
        response.getWriter().write("当前 Session 已设置为失效");
    }

}
