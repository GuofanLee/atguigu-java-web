package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 23:52
 */
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter1：chain.doFilter() 调用之前的代码");
        chain.doFilter(request, response);
        System.out.println("Filter1：chain.doFilter() 调用之后的代码");
    }

    @Override
    public void destroy() {

    }

}
