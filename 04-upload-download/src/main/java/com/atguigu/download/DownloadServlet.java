package com.atguigu.download;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-11 18:31
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取要下载的文件名
        String downloadFileName = "default.jpg";
        //2、以输入流的形式读取要下载的文件内容（通过ServletContext对象读取）
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //3、回传前，通过响应头，告诉客户端返回的数据类型
        //获取文件的 MIME 类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        //将文件的 MIME 类型设置到 Http 响应头的 Content-Type 参数中
        response.setContentType(mimeType);
        //4、解决不同浏览器文件名乱码问题
        String fileName;
        if (request.getHeader("User-Agent").contains("Firefox")) {
            //火狐浏览器使用 BASE64 编码
            fileName = "=?UTF-8?B?" + new BASE64Encoder().encode("美女.jpg".getBytes(StandardCharsets.UTF_8)) + "?=";
        } else {
            //其它浏览器（谷歌、IE）使用 URL 编码
            fileName = URLEncoder.encode("美女.jpg", "UTF-8");
        }
        /*
         * 5、回传前，通过响应头，告诉客户端返回的数据是用于下载使用
         * 响应头参数 Content-Disposition 表示告诉客户端收到的数据怎么处理
         * attachment表示以附件的方式处理，即返回的数据是文件，需要下载
         * filename表示下载后的文件名
         */
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //获取响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //5、把下载的内容回传给客户端
        //读取输入流中的数据，复制给输出流，输出给客户端
        IOUtils.copy(inputStream, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
