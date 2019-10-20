package dao;

import entity.Goods;
import entity.User;
import utils.DBUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {


    @Override
    public User findUser(String u_username, String u_password) {
        //定义SQL语句
        String sql = "select * from user where u_username=? and u_password=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            //获取数据库连接
            conn = DBUtils.getConnection();
            //获得执行SQL语句的对象
            pstmt = conn.prepareStatement(sql);
            //设置参数
            pstmt.setString(1, u_username);
            pstmt.setString(2, u_password);
            //执行查询
            rs = pstmt.executeQuery();
            //处理结果
            if (rs.next()) {
                String u_username1 = rs.getString("u_username");
                String u_password1 = rs.getString("u_password");
                //将查询到的数据封装为对象
                User user = new User();
                user.setU_username(u_username1);
                user.setU_password(u_password1);
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.CloseAll(rs, pstmt, conn);
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        //定义sql语句
        String sql = "INSERT INTO USER(u_username,u_password,u_sex,u_hobbies,u_phone,u_email,u_address)VALUES(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //获取数据库连接
            conn = DBUtils.getConnection();
            //获取执行SQL语句的对象
            pstmt = conn.prepareStatement(sql);
            //设置参数
            pstmt.setString(1, user.getU_username());
            pstmt.setString(2, user.getU_password());
            pstmt.setString(3, user.getU_sex());
            pstmt.setString(4, user.getU_hobbies());
            pstmt.setString(5, user.getU_phone());
            pstmt.setString(6, user.getU_email());
            pstmt.setString(7, user.getU_address());

            //执行响应的SQL
            int result = pstmt.executeUpdate();
            //返回受影响的行数
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭响应的连接
            DBUtils.CloseAll(null, pstmt, conn);
        }
        return -1;
    }


}
