<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="css/vrms.css" rel="stylesheet" />
<title>VRMS</title>
</head>
<body>
	<s:form theme="simple" action="customerAction_viewCustomerList.action">
		<div id="landingPageHeadDiv">Video Rental Management</div>
		<br/>
		<table class="bigTable" border="1">
			<tr>
				<td align="center"><s:submit cssClass="submitClass" value="View Customer List"></s:submit></td>
				<td align="center"><s:submit cssClass="submitClass" value="Add Customer" action="customerAction_defineCustomer"></s:submit></td>
				<td align="center"><s:submit cssClass="submitClass" value="View Categories" action="categoriesAction_viewCategories"></s:submit></td>
			</tr>
			<tr>
				<td align="center"><s:submit cssClass="submitClass" value="View Movies" action="moviesAction_viewMoviesList"></s:submit></td>
				<td align="center"><s:submit cssClass="submitClass" value="Add Movie" action="moviesAction_defineMovie"></s:submit></td>
				<td align="center"><s:submit cssClass="submitClass" value="View Active Rentals" action="rentalAction_viewActiveRentals"></s:submit></td>
			</tr>
			<tr>
				<td align="center"><s:submit cssClass="submitClass" value="View All Rentals" action="rentalAction_viewRentals"></s:submit></td>
				<td align="center"><s:submit cssClass="submitClass" value="Make a Rental" action="rentalAction_defineRental"></s:submit></td>
				<td align="center"><s:submit cssClass="submitClass" value="Close a Rental" action="rentalAction_closeRentalPage"></s:submit></td>
			</tr>
		</table>
		<img alt="" src="images/Home.png" />
	
	</s:form>
</body>
</html>