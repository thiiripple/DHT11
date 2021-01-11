package com.kust.listenners;

import com.kust.dao.SocketClose;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

@WebListener()
public class OneListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public OneListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("hello");
        try {
            ServerSocket serverSocket = new ServerSocket(5080);

            //Socket socket = serverSocket.accept();
            //InputStream inputStream = socket.getInputStream();

            ServletContext application = sce.getServletContext();
            application.setAttribute("ServerSocket", serverSocket);

            //application.setAttribute("Socket", socket);
            //application.setAttribute("InputStream", inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        ServletContext application = sce.getServletContext();
        ServerSocket serverSocket = (ServerSocket) application.getAttribute("ServerSocket");
        /*if(!serverSocket.isClosed()){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SocketClose.close(
                        (ServerSocket) application.getAttribute("ServerSocket"),
                        (Socket) application.getAttribute("Socket"),
                        (InputStream) application.getAttribute("InputStream")
        );

        System.out.println("byebye");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
