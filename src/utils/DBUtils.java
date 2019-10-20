package utils;


import java.sql.*;

public class DBUtils {
    private static String url = DBConfig.getValue("mysql.jdbc.url");  //对应配置文件
    private static String username = DBConfig.getValue("mysql.jdbc.username");
    private static String password = DBConfig.getValue("mysql.jdbc.password");


    static {
        try {
            Class.forName(DBConfig.getValue("mysql.jdbc.driverClass"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    public static void CloseAll(ResultSet rs, Statement stmt,Connection conn){
        try {
            if (rs!=null){
                rs.close();
            }
            if (stmt!=null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
