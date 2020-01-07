package com.atguigu.javaweb.encoding;

import com.atguigu.javaweb.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter extends HttpFilter {

	private String encoding;
	
	@Override
	protected void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println(encoding); 
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);
	}

}
