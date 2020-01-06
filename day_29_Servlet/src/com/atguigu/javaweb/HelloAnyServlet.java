package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloAnyServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取ServletPath： /edit.do 或 addCustomer.do
        String servletPath = req.getServletPath();

        //2. 去除/ 和 .do ， 得到类似于edit 或 addCustomer 这样的字符串
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0, methodName.length() - 3);

        try {
            //3. 利用反射获取methodName() 对应的方法
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //4. 利用反射调用对应的方法
            method.invoke(this, req, resp);

        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
            System.out.println("未找到方法！");
            //未找到方法，进行响应
            resp.sendRedirect("Test_404_Error.jsp");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse response) {
        System.out.println("edit方法");
    }

    private void addCustomer(HttpServletRequest req, HttpServletResponse response) {
        System.out.println("addCustomer方法");
    }
}
