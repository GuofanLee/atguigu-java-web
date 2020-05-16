package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前台 Servlet
 *
 * @author GuofanLee
 * @date 2020-05-13 14:18
 */
public class ClientServlet extends BaseServlet {

    private final BookService bookService = new BookServiceImpl();

    /**
     * 用户请求首页
     */
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取分页参数 pageNo、pageSize
        int pageNo = WebUtils.parseStringToInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseStringToInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用 bookService 查询分页数据
        Page<Book> page = bookService.pageQuery(pageNo, pageSize);
        //3、将查询结果保存到 request 域中
        request.setAttribute("page", page);
        //4、请求转发到工程首页
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    /**
     * 按价格区间查询图书
     */
    public void queryByPrice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取分页参数 pageNo、pageSize
        int pageNo = WebUtils.parseStringToInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseStringToInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、获取价格参数
        int minPrice = WebUtils.parseStringToInt(request.getParameter("min"), 0);
        int maxPrice = WebUtils.parseStringToInt(request.getParameter("max"), Integer.MAX_VALUE);
        //3、调用 bookService 查询分页数据
        Page<Book> page = bookService.pageQueryByPrice(minPrice, maxPrice, pageNo, pageSize);
        //4、将查询结果保存到 request 域中
        request.setAttribute("page", page);
        //5、请求转发到工程首页
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

}
