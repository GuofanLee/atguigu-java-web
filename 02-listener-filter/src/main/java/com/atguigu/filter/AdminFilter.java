package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 22:28
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1、Filter 的构造方法执行了");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2、Filter 的 init 方法执行了");
        //获取在 web.xml 中配置的 Filter 名称
        String filterName = filterConfig.getFilterName();
        System.out.println("在 Filter 的 init 方法中通过 filterConfig 获取在 web.xml 中配置的 Filter 名称：" + filterName);
        //获取在 web.xml 中配置的 Filter 的 init-param 初始化参数
        String username = filterConfig.getInitParameter("username");
        System.out.println("在 Filter 的 init 方法中通过 filterConfig 获取在 web.xml 中配置的 Filter 的 init-param 初始化参数：" + username);
        //获取 ServletContext 对象
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println("在 Filter 的 init 方法中通过 filterConfig 获取的 servletContext：" + servletContext);
    }

    /**
     * 拦截请求，做登录校验
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3、Filter 的 doFilter 方法执行了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login.jsp");
        } else {
            //通过校验，放行
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4、Filter 的 destroy 方法执行了");
    }

}
