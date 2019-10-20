package servlet;

import dao.GoodsDao;
import dao.GoodsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletionServlet")
public class DeletionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] uids = req.getParameterValues("g_id");
        System.out.println("g_id:" + uids);
        //调用DAO层的方法，
        GoodsDao infoDao = new GoodsDaoImpl();
        //调用删除方法的时候，直接将获取的参数的值的数组，传递过去
        int result = infoDao.deleteById(uids);
        PrintWriter out = resp.getWriter();
        if (result > 0) {
            out.println("<script>alert('删除成功！');window.location.href='/goodsServlet?method=list'</script>");
        } else {
            out.println("<script>alert=('删除失败！');history.back();</script>");

        }
    }
}