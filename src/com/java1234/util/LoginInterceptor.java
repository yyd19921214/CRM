package com.java1234.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginCheck", urlPatterns = { "*.jsp" }, initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8"),
		@WebInitParam(name = "loginPage", value = "/login.jsp"), })
public class LoginInterceptor implements Filter{
	private FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}
	
	@Override
	public void destroy() {
		this.config=null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String encoding=config.getInitParameter("encoding");
		String loginPage=config.getInitParameter("loginPage");
		request.setCharacterEncoding(encoding);
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session=req.getSession(true);
		String reqPath=req.getServletPath();
		if((session.getAttribute("currentUser")==null)&&(!reqPath.endsWith(loginPage))){
			request.setAttribute("tips", "请您先登录");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		else{
			chain.doFilter(request, response);
		}

		
		ServletContext context=this.config.getServletContext();
		
//		long before=System.currentTimeMillis();
//		System.out.println("开始过滤");
//		HttpServletRequest req=(HttpServletRequest) request;
//		System.out.println("已截获到用户请求："+req.getServletPath());
//		chain.doFilter(request, response);
//		long after=System.currentTimeMillis();
//		System.out.println("请求被定位到"+req.getRequestURI()+"所花时间为："+(after-before));
		
	}

}
