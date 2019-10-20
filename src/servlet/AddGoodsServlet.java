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
import java.io.PrintWriter;

@WebServlet("/addGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String g_id = req.getParameter("g_id");
        String g_goods_name = req.getParameter("g_goods_name");
        String g_goods_pic = req.getParameter("g_goods_pic");
        String g_goods_price = req.getParameter("g_goods_price");
        String g_goods_description = req.getParameter("g_goods_description");
        String is_delete = req.getParameter("is_delete");
        String g_goods_stock = req.getParameter("g_goods_stock");

        //封装对象
        Goods goods = new Goods();
        goods.setG_id(Integer.parseInt(g_id));
        goods.setG_goods_name(g_goods_name);
        goods.setG_goods_pic("img/"+g_goods_pic);
        goods.setG_goods_price(Double.valueOf(g_goods_price));
        goods.setG_goods_description(g_goods_description);
        goods.setIs_delete(Integer.parseInt(is_delete));
        goods.setG_goods_stock(Integer.parseInt(g_goods_stock));

        //调用方法
        GoodsDao goodsDao = new GoodsDaoImpl();
        PrintWriter out = resp.getWriter();
        int result = goodsDao.add(goods);
        if (result > 0) {
            out.println("<script>alert('新增成功！');window.location.href='/goodsServlet?method=list'</script>");
        } else {
            out.println("<script>alert=('新增失败！');history.back();</script>");
        }
    }


}
