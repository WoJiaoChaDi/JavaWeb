package com.atguigu.javaweb;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class LoginServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("请求进来了....");

        //根据请求参数的名字，返回参数值
        String user = servletRequest.getParameter("user");
        //根据请求参数的名字，返回请求参数的一组的字符串数组
        String[] parameterValues = servletRequest.getParameterValues("password");
        //返回所有请求参数的键值对
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        //返回所有请求参数的名字
        Enumeration<String> parameterNames = servletRequest.getParameterNames();

        //获取HttpServletRequest请求对象
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的URL      http://localhost:8080/day29/loginServlet
        System.out.println(httpServletRequest.getRequestURL());
        //获取请求的URI      /day29/loginServlet
        System.out.println(httpServletRequest.getRequestURI());
        //获取请求的方式        GET
        System.out.println(httpServletRequest.getMethod());
        //获取请求的参数String     user=admin&password=admin
        System.out.println(httpServletRequest.getQueryString());
        //获取请求的servlet名字    /loginServlet
        System.out.println(httpServletRequest.getServletPath());

        //ServletResponse对象
        //网页输出内容
        //PrintWriter writer = servletResponse.getWriter();
        //writer.print("HelloWorld......");

        //输出MIME内容，可以参考 tomcat_home\conf\web.xml 中的内容
        servletResponse.setContentType("application/msword");//输出doc文档
        PrintWriter writer = servletResponse.getWriter();
        writer.println("HelloWorld......");
        writer.println("HelloWorld......");
        writer.println("HelloWorld......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
