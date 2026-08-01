<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<span class="nav-section-label">Main</span>
<a class="nav-item ${selectedMenuMap.home}"
	onclick="setSelectedMenuItem('home')"
	href="${pageContext.request.contextPath}/index.jsp"> <span
	class="nav-icon">🏠</span> Dashboard
</a>

<span class="nav-section-label">Rentals</span>
<a class="nav-item ${selectedMenuMap.activeRentals}"
	onclick="setSelectedMenuItem('activeRentals')"
	href="${pageContext.request.contextPath}/rentalAction_viewActiveRentals.action">
	<span class="nav-icon">📋</span> List of Rentals
</a>
<a class="nav-item ${selectedMenuMap.makeRental}"
	onclick="setSelectedMenuItem('makeRental')"
	href="${pageContext.request.contextPath}/rentalAction_defineRental.action">
	<span class="nav-icon">➕</span> New Rental
</a>
<a class="nav-item ${selectedMenuMap.closeRental}"
	onclick="setSelectedMenuItem('closeRental')"
	href="${pageContext.request.contextPath}/rentalAction_closeRentalPage.action">
	<span class="nav-icon">✅</span> Rental Closure
</a>

<span class="nav-section-label">Customers</span>
<a class="nav-item ${selectedMenuMap.viewCustomers}"
	onclick="setSelectedMenuItem('viewCustomers')"
	href="${pageContext.request.contextPath}/customerAction_viewCustomerList.action">
	<span class="nav-icon">👥</span> Customers
</a>
<a class="nav-item ${selectedMenuMap.addCustomer}"
	onclick="setSelectedMenuItem('addCustomer')"
	href="${pageContext.request.contextPath}/customerAction_defineCustomer.action">
	<span class="nav-icon">➕</span> Add Customer
</a>

<span class="nav-section-label">Catalogue</span>
<a class="nav-item ${selectedMenuMap.movies}"
	onclick="setSelectedMenuItem('movies')"
	href="${pageContext.request.contextPath}/moviesAction_viewMoviesList.action">
	<span class="nav-icon">🎬</span> Movies
</a>
<a class="nav-item ${selectedMenuMap.categories}"
	onclick="setSelectedMenuItem('categories')"
	href="${pageContext.request.contextPath}/categoriesAction_viewCategories.action">
	<span class="nav-icon">🗂️</span> Categories
</a>
<a class="nav-item ${selectedMenuMap.copies}"
	onclick="setSelectedMenuItem('copies')"
	href="${pageContext.request.contextPath}/moviesAction_viewMoviesList.action">
	<span class="nav-icon">💿</span> Copies / Stock
</a>

<div class="sidebar-spacer"></div>
<span class="nav-section-label">Settings</span>
<a class="nav-item ${selectedMenuMap.pricing}"
	onclick="setSelectedMenuItem('pricing')"
	href="${pageContext.request.contextPath}/categoriesAction_viewCategories.action">
	<span class="nav-icon">💲</span> Pricing
</a>
<a class="nav-item ${selectedMenuMap.userSettings}"
	onclick="setSelectedMenuItem('userSettings')"
	href="${pageContext.request.contextPath}/userSettingsAction.action">
	<span class="nav-icon">🧑</span> My Profile <a class="nav-item logout"
	href="${pageContext.request.contextPath}/logoutAction.action"> <span
		class="nav-icon">🚪</span> Log Out
</a>