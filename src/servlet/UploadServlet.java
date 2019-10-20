package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如果<form>表单的enctype="multipart/form-data",
        // 如果直接通过req.getParameter("title");将取不到值
        String title = req.getParameter("title");
        System.out.println("title:"+title);

        String fileName = "";
        String errMsg = "";
        try {
            // 1、判断你的<form>表单的enctype="multipart/form-data",
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            // 2、判断是否为上传表单
            if(isMultipart){
                // 3、创建ServletFileUpload对象
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                // 4、通过ServletFileUpload对象解析请求获得上传的控件的集合
                List<FileItem> fileItemList = upload.parseRequest(req);

                // 5、遍历
                if(fileItemList!=null && fileItemList.size()>0){
                    for(FileItem item : fileItemList){
                        if(item.isFormField()){
                            // 表示普通控件
                            if("title".equals(item.getFieldName())){
                                // String getString()：如果值不为中文用这个
                                // String getString(String charset)：可能是中文用这个
                                title = item.getString("utf-8");
//                                int age = item.getString();
                            }
                        }else{
                            // 表示上传控件
                            // 5.1、获得upload目录在web服务中的绝对路径
                            String parentPath = req.getServletContext().getRealPath("/upload");
                            // 判断目录是否存在，如果不存在就创建出来
                            File parentFile = new File(parentPath);
                            // mkdirs()：创建目录
                            if(!parentFile.exists()) parentFile.mkdirs();

                            // 5.2、写入服务器中的新的文件的文件对象
                            File newFile = new File(parentPath,item.getName());
                            // 5.3、获得上传文件的输入流
                            InputStream inputStream = item.getInputStream();
                            // 5.4、创建输出流
                            OutputStream outputStream = new FileOutputStream(newFile);
                            // 5.5、进入读写操作
                            IOUtils.copy(inputStream,outputStream);

                            fileName = item.getName();
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }


        req.setAttribute("fileName",fileName);
        req.getRequestDispatcher("upload_success.jsp").forward(req,resp);
    }
}
