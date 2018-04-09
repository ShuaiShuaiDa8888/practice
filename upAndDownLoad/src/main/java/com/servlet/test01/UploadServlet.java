package com.servlet.test01;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by WS on 2018/3/27.
 */
@WebServlet(name = "UploadServlet",urlPatterns = "/uploadServlet")
public class UploadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html, charset = utf-8");

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);
            List<FileItem> fileItems = sfu.parseRequest(request);
            if (null != fileItems && fileItems.size() > 0) {
                FileItem fileItem0 = fileItems.get(0);
                FileItem fileItem1 = fileItems.get(1);
                System.out.println("普通表单项：" + fileItem0.getFieldName() + "=" + fileItem0.getString("utf-8"));
                System.out.println("文件表单项：");
                System.out.print("Content-Type" + fileItem1.getName());
                System.out.print("size:" + fileItem1.getSize());
                System.out.println("fileName" + fileItem1.getName());
                //保存文件
                File file = new File("E:\\weiShuai\\upAndDownload");
                fileItem1.write(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
