package com.atguigu.javaweb.login;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class PasswordFilter
 */
public class PasswordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PasswordFilter() {
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

		//获取全局参数
		String initPassword = filterConfig.getServletContext().getInitParameter("password");
		String password = request.getParameter("password");
		
		if(!initPassword.equals(password)){
			request.setAttribute("message", "密码不正确");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	
	private FilterConfig filterConfig;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
