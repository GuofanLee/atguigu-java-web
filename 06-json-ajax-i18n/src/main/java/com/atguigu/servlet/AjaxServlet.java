package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-16 18:07
 */
public class AjaxServlet extends BaseServlet {

    public void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("服务端接收到了 JavaScript 的 Ajax 请求！");
        Person person = new Person(1, "tom");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        //给客户端响应一个 Person 对象的 Json 字符串
        response.getWriter().write(personJsonStr);
    }

    public void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("服务端接收到了 JQuery 的 Ajax 请求！");
        Person person = new Person(1, "tom");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        //给客户端响应一个 Person 对象的 Json 字符串
        response.getWriter().write(personJsonStr);
    }

    public void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("服务端接收到了 JQuery 的 Get 请求！");
        Person person = new Person(1, "tom");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        //给客户端响应一个 Person 对象的 Json 字符串
        response.getWriter().write(personJsonStr);
    }

    public void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("服务端接收到了 JQuery 的 Post 请求！");
        Person person = new Person(1, "tom");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        //给客户端响应一个 Person 对象的 Json 字符串
        response.getWriter().write(personJsonStr);
    }

    public void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("服务端接收到了 JQuery 的 jQuerySerialize 请求！");
        System.out.println("username：" + request.getParameter("username"));
        System.out.println("password：" + request.getParameter("password"));
        response.setContentType("text/html;charset=UTF-8");
        Person person = new Person(1, "tom");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        //给客户端响应一个 Person 对象的 Json 字符串
        response.getWriter().write(personJsonStr);
    }

}
