package com.atguigu.javaweb;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class HelloServlet implements Servlet{

    public HelloServlet() {
        System.out.println("HelloServlet's constructor...");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet's init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("HelloServlet's getServletConfig...");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet's service...");
    }

    @Override
    public String getServletInfo() {
        System.out.println("HelloServlet's getServletInfo...");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet's destroy...");
    }
}
