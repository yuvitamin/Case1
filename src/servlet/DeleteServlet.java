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

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String g_id = req.getParameter("g_id");
        Goods goods = new Goods();
        goods.setG_id(Integer.parseInt(g_id));
        GoodsDao goodsDao = new GoodsDaoImpl();
        int result = goodsDao.deleteGoods(goods);
        System.out.println("删除成功行数:"+result);
        resp.sendRedirect("/goodsServlet?method=list");

    }
}
