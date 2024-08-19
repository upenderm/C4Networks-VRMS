<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VRMS</title>
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<meta name="description" content="Video Rental Management System" />
<meta name="keywords" content="C4VRMS, VRMS" />
<meta name="robots" content="index, follow" />
<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />
<link type="text/css" href="css/vrms-content-styles.css" rel="stylesheet" />
<script src="js/vrms-topnav.js"></script>
<script src="js/vrms.js"></script>
<script type="text/javascript">
	function submitThisForm(action) {
		document.headerForm.action = action;
		document.headerForm.submit();
	}
</script>
<!--[if lt IE 7]>
	<style media="screen" type="text/css">
	#container {
		height:100%;
	}
	</style>
	<![endif]-->
</head>
<body>
	<s:form id="headerForm" name="headerForm" action="" theme="simple">
		<div id="container">
			<div id="header">
				<!-- Header start -->
				<p>&nbsp;</p>
				<h1>VIDEO RENTAL MANAMEMENT SYSTEM</h1>
				<p style="text-align: right">
					<s:submit cssClass="button buttonSettings" value="Settings" type="button" onclick="submitThisForm('userSettingsAction.action')"></s:submit>
					<s:submit cssClass="button buttonLogout" value="LogOut" type="button" onclick="submitThisForm('logoutAction.action')"></s:submit>
					<%-- <button class="button buttonSettings" style="vertical-align: middle">
						<span>Settings</span>
					</button>
					<button class="button buttonLogout" style="vertical-align: middle">
						<span>LogOut</span>
					</button> --%>
				</p>
				<!-- Header end -->
			</div>
			<div class="topnav" id="menuItemList">
				<a class="menuItem ${selectedMenuMap.home}" onclick="setSelectedMenuItem('home')" href="index.jsp">HOME</a> 
				<a class="menuItem ${selectedMenuMap.viewCustomers}" onclick="setSelectedMenuItem('viewCustomers')" href="customerAction_viewCustomerList.action">VIEW CUSTOMERS</a> 
				<!-- <a class="menuItem ${selectedMenuMap.addCustomer}" onclick="setSelectedMenuItem('addCustomer')"	href="customerAction_defineCustomer.action">ADD CUSTOMER</a>  --> 
				<a class="menuItem ${selectedMenuMap.categories}" onclick="setSelectedMenuItem('categories')" href="categoriesAction_viewCategories.action">CATEGORIES</a> 
				<a class="menuItem ${selectedMenuMap.movies}" onclick="setSelectedMenuItem('movies')" href="moviesAction_viewMoviesList.action">MOVIES</a> 
				<!-- <a class="menuItem ${selectedMenuMap.addMovie}" onclick="setSelectedMenuItem('addMovie')" href="moviesAction_defineMovie.action">ADD MOVIE</a>  --> 
				<a class="menuItem ${selectedMenuMap.activeRentals}" onclick="setSelectedMenuItem('activeRentals')" href="rentalAction_viewActiveRentals.action">RENTALS</a> 
				<!-- <a class="menuItem ${selectedMenuMap.allRentals}" onclick="setSelectedMenuItem('allRentals')" href="rentalAction_viewAllRentals.action">ALL RENTALS</a>  --> 
				<!-- <a class="menuItem ${selectedMenuMap.makeRental}" onclick="setSelectedMenuItem('makeRental')" href="rentalAction_defineRental.action">MAKE A RENTAL</a>  --> 
				<a class="menuItem ${selectedMenuMap.closeRental}" onclick="setSelectedMenuItem('closeRental')" href="rentalAction_closeRentalPage.action">CLOSE A RENTAL</a>
			</div>

			<div id="body">
				<!-- Body start -->
				<div class="col-container">
					<div class="col leftBanner" style="background-image: url('images/vb1.jpg')";>&nbsp;</div>
					<div class="col bodyContainer" style="background-image: url('images/InternetOfThings.jpg')";>&nsbp;</div>
					<div class="col rightBanner" style="background-image: url('images/vb2.jpg')";>&nbsp;</div>
					<!--	<image src="images/vb4.jpg" /> -->

				</div>
				<div id="footer">
					<!-- Footer start -->
					<p>
						<strong>Copyright © C4Networks</strong>
					</p>
					<!-- Footer end -->
				</div>
			</div>
		</div>
	</s:form>
</body>
</html>