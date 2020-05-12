package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-12 19:17
 */
public class BookServlet extends BaseServlet {

    private final BookService bookService = new BookServiceImpl();

    /**
     * 添加图书
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取求情参数
        Book book = WebUtils.copyMapToBean(request.getParameterMap(), new Book());
        //2、调用 bookService 保存图书信息
        bookService.addBook(book);
        //3、请求重定向到图书列表页
        response.sendRedirect( request.getContextPath() + "/manager/bookServlet?action=list");
    }

    /**
     * 删除图书
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取求情参数
        int id = WebUtils.parseStringToInt(request.getParameter("id"), 0);
        //2、调用 bookService 删除图书信息
        bookService.deleteBookById(id);
        //3、请求重定向到图书列表页
        response.sendRedirect( request.getContextPath() + "/manager/bookServlet?action=list");
    }

    /**
     * 查询图书信息，返回图书修改页面
     */
    public void getBookToUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取求情参数
        int id = WebUtils.parseStringToInt(request.getParameter("id"), 0);
        //2、调用 bookService 查询图书信息
        Book book = bookService.queryBookById(id);
        //3、将图书信息保存到 request 域中
        request.setAttribute("book", book);
        //3、请求转发到图书修改页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    /**
     * 修改图书
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、获取求情参数
        Book book = WebUtils.copyMapToBean(request.getParameterMap(), new Book());
        //2、调用 bookService 修改图书信息
        bookService.updateBook(book);
        //3、请求重定向到图书列表页
        response.sendRedirect( request.getContextPath() + "/manager/bookServlet?action=list");
    }

    /**
     * 查询图书，返回图书列表页面
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1、通过 bookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        //2、将查询结果保存到 request 域中
        request.setAttribute("books", books);
        //3、请求转发到 /pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

}
