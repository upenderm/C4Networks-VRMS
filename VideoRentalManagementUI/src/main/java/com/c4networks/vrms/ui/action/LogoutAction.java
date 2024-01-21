package com.c4networks.vrms.ui.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LogoutAction.class.getName());

	public String execute() {
		logger.info("Logout Action call invoked");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean isSecure = false;
//		String contextPath = null;
		if (request != null) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			isSecure = request.isSecure();
//			contextPath = request.getContextPath();
		}
//	    SecurityContext context = SecurityContextHolder.getContext();
//	    SecurityContextHolder.clearContext();
//	    context.setAuthentication(null);
		if (response != null) {
			Cookie cookie = new Cookie("JSESSIONID", null);
			String cookiePath = "/";
			cookie.setPath(cookiePath);
			cookie.setMaxAge(0);
			cookie.setSecure(isSecure);
			response.addCookie(cookie);
			Cookie cookie2 = new Cookie("C4TOKEN", null);
			cookie2.setPath(cookiePath);
			cookie2.setMaxAge(0);
			cookie2.setSecure(isSecure);
			response.addCookie(cookie2);
			Cookie cookie3 = new Cookie("SSOSESSIONID", null);
			cookie3.setPath(cookiePath);
			cookie3.setMaxAge(0);
			cookie3.setSecure(isSecure);
			response.addCookie(cookie3);
		}
		return SUCCESS;
	}

}
