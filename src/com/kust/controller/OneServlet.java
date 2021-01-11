package com.kust.controller;

import com.kust.entity.HT;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OneServlet")
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        HT ht = new HT("17", "18");
        application.setAttribute("ht", ht);
        ht = new HT("18", "19");
        HT htt = (HT) application.getAttribute("ht");
        System.out.println(htt.getHumidity());
    }
}
