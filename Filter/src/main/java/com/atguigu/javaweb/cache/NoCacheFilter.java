package com.atguigu.javaweb.cache;

import com.atguigu.javaweb.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println("cacheFilter's doFilter..");

		//清楚缓存的
		response.setDateHeader("Expires",-1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		
		filterChain.doFilter(request, response);
	}

    

}
