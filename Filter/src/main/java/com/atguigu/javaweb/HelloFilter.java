package com.atguigu.javaweb;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HelloFilter..init..");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("1. Before HelloFilter..oFilter..");

        //将请求放行，继续执行后面的filter
        chain.doFilter(servletRequest, servletResponse);

        System.out.println("2. After HelloFilter..doFilter..");
    }

    @Override
    public void destroy() {
        System.out.println("HelloFilter..destroy..");

    }
}
