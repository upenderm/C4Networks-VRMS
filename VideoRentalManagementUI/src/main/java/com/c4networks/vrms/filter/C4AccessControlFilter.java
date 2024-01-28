package com.c4networks.vrms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class C4AccessControlFilter implements Filter {

	private static final Logger logger = Logger.getLogger(C4AccessControlFilter.class.getName());

	@Override
	public void destroy() {
		logger.info("C4AccessControlFilter.destroy");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		logger.info("C4AccessControlFilter.doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Cookie[] cookies = httpRequest.getCookies();
		boolean authenticatedRequest = false;
		System.out.println("cookies ::" + cookies);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if (cookie.getName().equals("C4TOKEN") && cookie.getValue().equals("C4NetworkToken")) {
					System.out.println("Allowed to login");
					authenticatedRequest = true;
				}
			}
		}
		if (authenticatedRequest) {
			filterChain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/errorpages/HTTP403.html").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("C4AccessControlFilter.init");

	}

}
