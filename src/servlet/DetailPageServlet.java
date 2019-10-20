package servlet;

import dao.GoodsDao;
import dao.GoodsDaoImpl;
import entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/detailPageServlet")
public class DetailPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String g_id = req.getParameter("g_id");
        GoodsDao goodsDao = new GoodsDaoImpl();
        Goods goods = goodsDao.selectById(Integer.parseInt(g_id));
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("/details.jsp").forward(req,resp);

    }
}
