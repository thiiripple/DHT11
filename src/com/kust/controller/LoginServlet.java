package com.kust.controller;

import com.kust.dao.Login;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer result = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        result = Login.login(username, password);


        if(result != null){
            request.getRequestDispatcher("central.jsp").forward(request, response);
        }else{
            out.println("登录失败！");
        }
    }
}
