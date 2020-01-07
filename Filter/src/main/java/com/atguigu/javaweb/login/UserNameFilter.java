package com.atguigu.javaweb.login;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class UserNameFilter
 */
public class UserNameFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserNameFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//获取局部参数
		String initUser = filterConfig.getInitParameter("username");
		String username = request.getParameter("username");
		
		if(!initUser.equals(username)){
			request.setAttribute("message", "用户名不正确");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	private FilterConfig filterConfig;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
