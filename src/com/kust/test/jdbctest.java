package com.kust.test;

import com.kust.utils.JdbcUtil;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbctest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lianyi?serverTimezone=UTC";
        String root = "root";
        String password = "1234";
        String sql = "select * from loginUser";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        {
            try {
                con = JdbcUtil.getConnection(url, root, password);
                ps = JdbcUtil.creatStatement(con, sql);
                rs = ps.executeQuery();
                if (rs.next()){
                    System.out.println(rs.getString("id"));
                    System.out.println(rs.getString("username"));
                    System.out.println(rs.getString("password"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                JdbcUtil.close(con, ps, rs);
            }
        }
    }

}
