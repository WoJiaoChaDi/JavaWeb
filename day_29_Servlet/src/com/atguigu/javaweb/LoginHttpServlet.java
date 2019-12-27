package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginHttpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getMethod();
        System.out.println(method);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);

        String user = req.getParameter("user");
        System.out.println("user:" + user);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getMethod();
        System.out.println(method);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);

        String user = req.getParameter("user");
        System.out.println("user:" + user);

        PrintWriter writer = resp.getWriter();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>")
                .append("<head>")
                .append("<h1>12345</h1>")
                .append("</head>")
                .append("</html>");
        writer.print(stringBuffer.toString());

    }
}
