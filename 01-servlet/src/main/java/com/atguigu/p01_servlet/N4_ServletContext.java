package com.atguigu.p01_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-08 16:25
 */
public class N4_ServletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        //1、使用 ServletContext 获取 web.xml 中配置的 web 工程上下文参数 context-param
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println("web 工程上下文参数 context-param：" + username);
        System.out.println("web 工程上下文参数 context-param：" + password);
        //2、使用 ServletContext 获取当前工程的根路径，格式：/工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println("当前工程的根路径：" + contextPath);
        //3、使用 ServletContext 获取工程部署后在服务器硬盘上的绝对路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("工程部署的绝对路径：" + realPath);
        //4、使用 ServletContext 获取资源文件的绝对路径
        String jsRealPath = servletContext.getRealPath("/js/1.js");
        String cssRealPath = servletContext.getRealPath("/css/1.css");
        System.out.println("js 资源文件路径：" + jsRealPath);
        System.out.println("css 资源文件路径：" + cssRealPath);
        //5、使用 ServletContext 存取数据，在 ServletContext 中存入的数据由所有 web 组件（ Servlet、Filter、Listener ）共享
        servletContext.setAttribute("key-1", "value-1");
        Object contextAttribute = servletContext.getAttribute("key-1");
        System.out.println(contextAttribute);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
