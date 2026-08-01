package com.c4networks.vrms.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SelectedMenuSelectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectedMenuSelectorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In doGet of SelectedMenuSelectorServlet");

		String selectItemToHighlight = request.getParameter("selectItemToHighlight");
		System.out.println("User selected menu item is :" + selectItemToHighlight);
		Map<String, String> selectedMenuMap = new HashMap<String, String>();
		selectedMenuMap.put("home", "");
		selectedMenuMap.put("viewCustomers", "");
		selectedMenuMap.put("addCustomer", "");
		selectedMenuMap.put("categories", "");
		selectedMenuMap.put("movies", "");
		selectedMenuMap.put("addMovie", "");
		selectedMenuMap.put("activeRentals", "");
		selectedMenuMap.put("allRentals", "");
		selectedMenuMap.put("makeRental", "");
		selectedMenuMap.put("closeRental", "");

		HttpSession session = request.getSession();
		session.setAttribute("selectItemToHighlight", selectItemToHighlight);

		selectedMenuMap.put(selectItemToHighlight, "active");
		session.setAttribute("selectedMenuMap", selectedMenuMap);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In doPost of SelectedMenuSelectorServlet");

		doGet(request, response);
	}

}
