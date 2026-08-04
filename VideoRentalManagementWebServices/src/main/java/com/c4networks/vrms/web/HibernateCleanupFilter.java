package com.c4networks.vrms.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.c4networks.vrms.services.hibernate.VRMSContextManager;

public class HibernateCleanupFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        try {
            chain.doFilter(request, response);
        } finally {
            System.out.println(
                    "HibernateCleanupFilter cleanup called for URI: "
                            + ((HttpServletRequest)request).getRequestURI()
            );
            VRMSContextManager.cleanup();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}