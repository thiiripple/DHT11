package com.kust.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kust.dao.GetInf;
import com.kust.dao.GetList;
import com.kust.entity.HT;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HTServlet")
public class HTServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date begin = new Date();
        List<HT> htlist = new ArrayList<>();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletContext application = request.getServletContext();
        ServerSocket serverSocket = (ServerSocket) application.getAttribute("ServerSocket");

        if(null == application.getAttribute("flag")) {
           htlist = GetList.getHTListFirst(request);
//            Integer flag = 1;
//            application.setAttribute("flag", flag);
//            Socket socket = serverSocket.accept();
//            InputStream inputStream = socket.getInputStream();
//            application.setAttribute("Socket", socket);
//            application.setAttribute("InputStream", inputStream);
//            int len = 0;
//            byte[] buffer = new byte[1024 * 1024];
//            if ((len = inputStream.read(buffer)) != -1) {
//                String str = new String(buffer, 0, len, "GBK");
//                String humidity = GetInf.getHumidity(str);
//                String temperature = GetInf.getTemperatrure(str);
//                System.out.println("湿度：" + humidity + "，温度：" + temperature);
//                HT ht = new HT(humidity, temperature);
//                htlist.add(ht);
//            }
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(htlist);
            out.print(json);
            Date end = new Date();
            System.out.println("获取一次消耗" + (end.getTime() - begin.getTime()) + "毫秒。");
        }


        else{
            htlist = new ArrayList<>();
            htlist = GetList.getHTList(request);
//            InputStream inputStream = (InputStream) application.getAttribute("InputStream");
//            int len = 0;
//            byte[] buffer = new byte[1024 * 1024];
//            if ((len = inputStream.read(buffer)) != -1) {
//                String str = new String(buffer, 0, len, "GBK");
//                String humidity = GetInf.getHumidity(str);
//                String temperature = GetInf.getTemperatrure(str);
//                System.out.println("湿度：" + humidity + "，温度：" + temperature);
//                HT ht = new HT(humidity, temperature);
//                htlist.add(ht);
//            }
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(htlist);
            out.print(json);
            Date end = new Date();
            System.out.println("获取一次消耗" + (end.getTime() - begin.getTime()) + "毫秒。");

        }
    }
}
