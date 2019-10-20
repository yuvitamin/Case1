package servlet;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String u_username = req.getParameter("u_username");
        String u_password = req.getParameter("u_password");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(u_username, u_password);
        PrintWriter out = resp.getWriter();
        //判断用户名和密码是否正确
        if (user != null && u_username.equals(u_username) && u_password.equals(u_password)) {
            //免登陆cookie
            Cookie cookie = new Cookie("u_username", u_username);
            resp.addCookie(cookie);
            //将用户名存入session
            req.getSession().setAttribute("user", u_username);
                out.println("<script>alert('登录成功!');window.location.href='/goodsServlet?method=list'</script>"); } else {
            req.setAttribute("login_error", "用户名或密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }


    }
}
