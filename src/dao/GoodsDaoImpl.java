package dao;

import entity.Goods;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    //查找全部
    @Override
    public List<Goods> selectAll() {
        List<Goods> goodsList = new ArrayList<>();
        //定义SQL语句
        String sql = "SELECT * FROM goods WHERE is_delete=0 ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int g_id1 = rs.getInt("g_id");
                String g_goods_name1 = rs.getString("g_goods_name");
                String g_goods_pic1 = rs.getString("g_goods_pic");
                double g_goods_price1 = rs.getDouble("g_goods_price");
                String g_goods_description1 = rs.getString("g_goods_description");

                //将查询到的封装为对象
                Goods goods1 = new Goods();
                goods1.setG_id(g_id1);
                goods1.setG_goods_name(g_goods_name1);
                goods1.setG_goods_pic(g_goods_pic1);
                goods1.setG_goods_price(g_goods_price1);
                goods1.setG_goods_description(g_goods_description1);
                goodsList.add(goods1);//将对象放入到集合中
            }
            return goodsList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.CloseAll(rs, pstmt, conn);
        }
        return null;
    }

    //按ID查询
    @Override
    public Goods selectById(int g_id) {
        List<Goods> goodsList = new ArrayList<>();
        //定义SQL语句
        String sql = "select * from goods where g_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, g_id);
            //执行SQL
            rs = pstmt.executeQuery();
            //处理结果集
            while (rs.next()) {
                int g_id1 = rs.getInt("g_id");
                String g_goods_name = rs.getString("g_goods_name");
                String g_goods_pic = rs.getString("g_goods_pic");
                double g_goods_price = rs.getDouble("g_goods_price");
                String g_goods_description = rs.getString("g_goods_description");
                int is_delete = rs.getInt("is_delete");
                int g_goods_stock = rs.getInt("g_goods_stock");

                //封装对象
                Goods goods = new Goods();
                goods.setG_id(g_id1);
                goods.setG_goods_name(g_goods_name);
                goods.setG_goods_pic(g_goods_pic);
                goods.setG_goods_price(g_goods_price);
                goods.setG_goods_description(g_goods_description);
                goods.setIs_delete(is_delete);
                goods.setG_goods_stock(g_goods_stock);
                return goods;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.CloseAll(rs, pstmt, conn);
        }
        return null;
    }

    //删除商品
    @Override
    public int deleteGoods(Goods goods) {
        String sql = "delete from goods where g_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, goods.getG_id());
            int result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.CloseAll(null, pstmt, conn);
        }
        return -1;
    }

    //修改商品
    @Override
    public int update(Goods goods) {
        //定义SQL
        String sql = "update goods set g_goods_name=?,g_goods_pic=?,g_goods_price=?,g_goods_description=?,is_delete=?,g_goods_stock=? where g_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            //设置参数
            pstmt.setString(1, goods.getG_goods_name());
            pstmt.setString(2, goods.getG_goods_pic());
            pstmt.setDouble(3, goods.getG_goods_price());
            pstmt.setString(4, goods.getG_goods_description());
            pstmt.setInt(5, goods.getIs_delete());
            pstmt.setInt(6, goods.getG_goods_stock());
            pstmt.setInt(7, goods.getG_id());
            //执行SQL
            int result = pstmt.executeUpdate();
            System.out.println("修改成功行数:" + result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.CloseAll(null, pstmt, conn);
        }

        return -1;
    }

    //新增商品
    @Override
    public int add(Goods goods) {
        //定义SQL
        String sql = "insert into goods(g_goods_name,g_goods_pic,g_goods_price,g_goods_description,is_delete,g_goods_stock)" + "values(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, goods.getG_goods_name());
            pstmt.setString(2, goods.getG_goods_pic());
            pstmt.setDouble(3, goods.getG_goods_price());
            pstmt.setString(4, goods.getG_goods_description());
            pstmt.setInt(5, 0);
            pstmt.setInt(6, goods.getG_goods_stock());
            // 执行SQL
            int result = pstmt.executeUpdate();
            System.out.println("新增行数:" + result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.CloseAll(null, pstmt, conn);
        }
        return -1;
    }


    //批量删除
    @Override
    public int deleteById(String[] ids) {
        StringBuffer sb = new StringBuffer();
        String idStr = null;
        if(ids!=null){
            for(String id:ids){
                sb.append(id).append(",");
            }
            //拼接完，会多一个,
            idStr = sb.toString().substring(0, sb.length()-1);
            //1,2,3
        }
        System.out.println("批量删除选中的id,idStr:"+idStr);


        //1,定义SQL
        String sql = "update goods set is_delete=? where g_id in ("+idStr+")";

        System.out.println("打印一下拼接的sql；"+sql);
        //
        Connection conn = null;
        PreparedStatement pstmt =null;
        try {
            //2,获取数据库连接
            conn = DBUtils.getConnection();
            //3,
            pstmt = conn.prepareStatement(sql);
            //设置参数
            pstmt.setString(1,"1");
            //4,执行SQL
            int result = pstmt.executeUpdate();
            System.out.println("受影响的行数："+result);
            return result;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.CloseAll(null,pstmt,conn);
        }
        return -1;
    }
}
