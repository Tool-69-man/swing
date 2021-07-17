package com.xiong.servlet;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameter()//获取配置参数
//            this.getServletConfig()//获取servlet配置
//        this.getServletContext()//servlet上下文
        ServletContext servletContext = this.getServletContext();
        String usename = "情满";

        servletContext.setAttribute("usename",usename);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
