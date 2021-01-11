package com.kust.dao;

import com.kust.entity.HT;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetList {

    public static List<HT> getHTListFirst(HttpServletRequest request) throws IOException {
        Integer flag = 1;

        List<HT> htList = new ArrayList<>();

        ServletContext application = request.getServletContext();
        ServerSocket serverSocket = (ServerSocket) application.getAttribute("ServerSocket");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        application.setAttribute("flag", flag);
        application.setAttribute("Socket", socket);
        application.setAttribute("InputStream", inputStream);
        int len = 0;
        byte[] buffer = new byte[1024 * 1024];
        if ((len = inputStream.read(buffer)) != -1) {
            String str = new String(buffer, 0, len, "GBK");
            String humidity = GetInf.getHumidity(str);
            String temperature = GetInf.getTemperatrure(str);
            System.out.println("湿度：" + humidity + "，温度：" + temperature);
            HT ht = new HT(humidity, temperature);
            htList.add(ht);
        }
        return htList;
    }

    public static List<HT> getHTList(HttpServletRequest request) throws IOException {
        List<HT> htList = new ArrayList<>();
        ServletContext application = request.getServletContext();
        InputStream inputStream = (InputStream) application.getAttribute("InputStream");
        int len = 0;
        byte[] buffer = new byte[1024 * 1024];
        if ((len = inputStream.read(buffer)) != -1) {
            String str = new String(buffer, 0, len, "GBK");
            String humidity = GetInf.getHumidity(str);
            String temperature = GetInf.getTemperatrure(str);
            System.out.println("湿度：" + humidity + "，温度：" + temperature);
            HT ht = new HT(humidity, temperature);
            htList.add(ht);
        }
        return htList;
    }
}
