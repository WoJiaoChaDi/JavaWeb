package com.atguigu.javaweb;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class SecondFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SecondFilter init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("3. Before SecondFilter's chain.doFilter ...");

        //将请求放行，继续执行后面的filter
		chain.doFilter(request, response);
		
		System.out.println("4. After SecondFilter's chain.doFilter ...");
	}

	//
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter destroy");
	}

}
