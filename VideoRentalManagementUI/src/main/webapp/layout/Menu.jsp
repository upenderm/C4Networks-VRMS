<%@ taglib uri="/struts-tags" prefix="s" %>
<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />

<a class="menuItem ${selectedMenuMap.home}" onclick="setSelectedMenuItem('home')" href="index.jsp">HOME</a> 
<a class="menuItem ${selectedMenuMap.viewCustomers}" onclick="setSelectedMenuItem('viewCustomers')" href="customerAction_viewCustomerList.action">VIEW CUSTOMERS</a> 
<a class="menuItem ${selectedMenuMap.addCustomer}" onclick="setSelectedMenuItem('addCustomer')" href="customerAction_defineCustomer.action">ADD CUSTOMER</a> 
<a class="menuItem ${selectedMenuMap.categories}" onclick="setSelectedMenuItem('categories')" href="categoriesAction_viewCategories.action">CATEGORIES</a> 
<a class="menuItem ${selectedMenuMap.movies}" onclick="setSelectedMenuItem('movies')" href="moviesAction_viewMoviesList.action">MOVIES</a> 
<a class="menuItem ${selectedMenuMap.addMovie}" onclick="setSelectedMenuItem('addMovie')" href="moviesAction_defineMovie.action">ADD MOVIE</a> 
<a class="menuItem ${selectedMenuMap.activeRentals}" onclick="setSelectedMenuItem('activeRentals')" href="rentalAction_viewActiveRentals.action">ACTIVE RENTALS</a> 
<a class="menuItem ${selectedMenuMap.allRentals}" onclick="setSelectedMenuItem('allRentals')" href="rentalAction_viewAllRentals.action">ALL RENTALS</a> 
<a class="menuItem ${selectedMenuMap.makeRental}" onclick="setSelectedMenuItem('makeRental')" href="rentalAction_defineRental.action">MAKE A RENTAL</a> 
<a class="menuItem ${selectedMenuMap.closeRental}" onclick="setSelectedMenuItem('closeRental')" href="rentalAction_closeRentalPage.action">CLOSE A RENTAL</a>