package com.atguigu.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2020-05-11 07:44
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、判断提交的数据是否是多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            //2、创建用于解析上传数据的工具类 ServletFileUpload，传入一个 FileItemFactory 接口的实现类对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try {
                //3、解析上传的数据，得到 List<FileItem>
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                //4、遍历 List<FileItem>
                for (FileItem fileItem : fileItems) {
                    //5、判断是否是普通类型的表单项
                    if (fileItem.isFormField()) {
                        //6、如果是普通表单项
                        System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                        System.out.println("表单项的 value 值：" + fileItem.getString("UTF-8"));
                    } else {
                        //7、如果是文件表单项
                        System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileItem.write(new File("D:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
