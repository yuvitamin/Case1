package servlet;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/regeditServlet")
public class RegeditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数
        String u_username = req.getParameter("u_username");
        String u_password = req.getParameter("u_password");
        String confirm_password = req.getParameter("confirm_password");
        String u_sex = req.getParameter("u_sex");
        String u_hobbies = req.getParameter("u_hobbies");
        String u_phone = req.getParameter("u_phone");
        String u_email = req.getParameter("u_email");
        String u_address = req.getParameter("u_address");
        //封装为对象
        User user = new User();
        user.setU_username(u_username);
        user.setU_password(u_password);
        user.setU_sex(u_sex);
        user.setU_hobbies(u_hobbies);
        user.setU_phone(u_phone);
        user.setU_email(u_email);
        user.setU_address(u_address);

        PrintWriter out = resp.getWriter();
        if (!u_password.equals(confirm_password)){
            out.println("<script type='text/javascript'>alert('两次密码输入不一致,请重新输入!');history.back();</script>");
        }else {
            UserDao userDao = new UserDaoImpl();
            int result = userDao.addUser(user);
            System.out.println("受影响行数:" + result);
            if (result > 0) {
                out.println("<script type='text/javascript'>alert('注册成功！');location.href='login.jsp';</script>");
                System.out.println("注册成功，数据已保存到数据库。");
            } else {
                out.println("<script type='text/javascript'>alert('注册失败!');history.back();</script>");
                System.out.println("注册失败，返回注册页面。");
            }
        }


    }
}
