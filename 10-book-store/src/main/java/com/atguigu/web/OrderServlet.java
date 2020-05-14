package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-15 01:38
 */
public class OrderServlet extends BaseServlet {

    private final OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User)request.getSession().getAttribute("user");
        String orderId = "";
        if (cart != null) {
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
                return;
            } else {
                orderId = orderService.createOrder(cart, user.getId());
            }
        }
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp?orderId=" + orderId);
    }

}
