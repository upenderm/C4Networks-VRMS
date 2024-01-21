package com.c4networks.vrms.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.c4networks.vrms.vo.UserDetails;
import com.c4networks.vrms.wsclient.VideoRentalManagementClient;

/**
 * Servlet Filter implementation class UserHome
 */

public class UserHomeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserHomeFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Cookie[] cookies = httpRequest.getCookies();
		System.out.println("UserHome Filter cookies ::" + cookies);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if (cookie.getName().equals("SSOSESSIONID")) {
					UserDetails userDetails = VideoRentalManagementClient.getInstance()
							.getLoggedInUserDetails(cookie.getValue());
					System.out.println("In UserHomeFilter - UserDetails obtained from webservice call :" + userDetails);
					if (userDetails != null) {

						Map<String, String> selectedMenuMap = new HashMap<String, String>();
						selectedMenuMap.put("home", "active");
						selectedMenuMap.put("viewCustomers", "");
						selectedMenuMap.put("addCustomer", "");
						selectedMenuMap.put("categories", "");
						selectedMenuMap.put("movies", "");
						selectedMenuMap.put("addMovie", "");
						selectedMenuMap.put("activeRentals", "");
						selectedMenuMap.put("allRentals", "");
						selectedMenuMap.put("makeRental", "");
						selectedMenuMap.put("closeRental", "");
						httpRequest.getSession().setAttribute("selectedMenuMap", selectedMenuMap);

						httpRequest.getSession().setAttribute("userDetails", userDetails);
						request.getRequestDispatcher("/index.jsp").forward(request, response);
					} else {
						chain.doFilter(request, response);
					}

				}
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
