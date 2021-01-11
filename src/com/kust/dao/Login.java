package com.kust.dao;

import com.kust.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private static String url = "jdbc:mysql://localhost:3306/lianyi?serverTimezone=UTC";
    private static String root = "root";
    private static String pwd = "1234";

    public static Integer login(String username, String password){
        String sql = "select id from loginUser where username=? and password=?";
        Integer result = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JdbcUtil.getConnection(url, root, pwd);
            ps = JdbcUtil.creatStatement(con, sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                result = 1;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(con, ps, rs);
        }
        return result;
    }
}
