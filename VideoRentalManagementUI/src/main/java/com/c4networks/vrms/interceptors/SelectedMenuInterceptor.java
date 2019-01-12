package com.c4networks.vrms.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SelectedMenuInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("destroy......");
	}

	@Override
	public void init() {
		System.out.println("init......");
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("Interceptor Pre-Processing");

		String result = actionInvocation.invoke();
		System.out.println("Interceptor Post-Processing");

		return result;
	}

}
