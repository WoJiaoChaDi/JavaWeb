package com.atguigu.javaweb;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class HelloServlet implements Servlet{

    public HelloServlet() {
        System.out.println("HelloServlet's constructor...");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet's init...");

        //获取<init-param>
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("name  -->  " + name);
            System.out.println("value  -->  " + value);
        }

        //获取<servlet-name>
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);

        //获取ServletContext对象
        //获取当前 WEB 应用的初始化参数设置初始化参数: 可以为所有的 Servlet 所获取, 而 Servlet 的初始化参数只用那个 Serlvet 可以获取.
        ServletContext servletContext = servletConfig.getServletContext();
        Enumeration<String> servletInitParameterNames = servletContext.getInitParameterNames();
        while (servletInitParameterNames.hasMoreElements()){
            String name = servletInitParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println("name  -->  " + name);
            System.out.println("value  -->  " + value);
        }

        //2. 获取当前 WEB 应用的某一个文件在服务器上的绝对路径, 而不是部署前的路径
        String realPath = servletContext.getRealPath("/note.txt");
        System.out.println("note 's realPath: " + realPath);

        //3. 获取当前 WEB 应用的名称:
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath: " + contextPath);

        //4. 获取当前 WEB 应用的某一个文件对应的输入流.
        InputStream is_1 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
        System.out.println("1. " +  is_1);

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is_2 = classLoader.getResourceAsStream("jdbc.properties");
        System.out.println("2. " +  is_2);
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
