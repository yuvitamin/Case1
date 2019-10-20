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

@WebServlet("/updateGoodsServlet1")
public class UpdateGoodsServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String g_id = req.getParameter("g_id");
        //根据id查询
        GoodsDao goodsDao = new GoodsDaoImpl();
        //根据id拿到学生的对象
        Goods goods = goodsDao.selectById(Integer.parseInt(g_id));
        //设置到req域里面
        req.setAttribute("goods",goods);
        //转发（数据共享）
        req.getRequestDispatcher("/goods_update.jsp").forward(req,resp);

    }
}
