package com.kust.utils;

import java.sql.*;

public class JdbcUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(String url, String root, String password) throws SQLException {
        return DriverManager.getConnection(url, root, password);
    }

    public static PreparedStatement creatStatement(Connection con, String sql) throws SQLException {
        PreparedStatement ps = con.prepareStatement(sql);
        return ps;
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        if (con != null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
