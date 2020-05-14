package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-14 22:39
 */
public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    /**
     * 向购物车中添加商品
     */
    public void addItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = WebUtils.parseStringToInt(request.getParameter("id"), 0);
        Book book = bookService.getBookById(id);
        if (book != null) {
            CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                request.getSession().setAttribute("cart", cart);
            }
            request.getSession().setAttribute("lastName", cartItem.getName());
            cart.addItem(cartItem);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 从购物车中删除商品
     */
    public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = WebUtils.parseStringToInt(request.getParameter("id"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 清空购物车
     */
    public void clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 修改购物车商品数量
     */
    public void updateCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = WebUtils.parseStringToInt(request.getParameter("id"), 0);
        int count = WebUtils.parseStringToInt(request.getParameter("count"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

}
