package com.c4networks.vrms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class C4AccessControlFilter implements Filter{
	
	private static final Logger logger = Logger.getLogger(C4AccessControlFilter.class.getName());

	@Override
	public void destroy() {
		logger.info("C4AccessControlFilter.destroy");
		
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		logger.info("C4AccessControlFilter.doFilter");
		
		/*String token = (String)request.getAttribute("c4Token");
		if(token.equals("C4NetworkToken")){
			filterChain.doFilter(request, response);
		}
		else{
			request.getRequestDispatcher("/error").forward(request, response);
		}*/
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("C4AccessControlFilter.init");
		
	}

}
