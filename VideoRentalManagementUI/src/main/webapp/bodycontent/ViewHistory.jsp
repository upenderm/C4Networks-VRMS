<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />
<title>VRMS</title>
</head>
<body>
	<div class="col bodyContainer">
	<s:actionmessage/>
	<br />
	<s:form theme="simple" id="viewHistoryForm" name="viewHistoryForm">
		<h2>Customer Rental History</h2>
		<table border="0" class="bigTable">
			<tr class="headerRow">
				<th>VRMSID</th>
				<th>Customer Name</th>
				<th>Movie</th>
				<th>Category</th>
				<th>Rental Id</th>
				<th>Rented Date</th>
				<th>Return Date</th>
				<th>Bonus</th>
				<th>Rent Status</th>
				<th>Late charges</th>
				<th>Amount</th>
			</tr>
			<s:if test="#session.rentalHistoryList.size()>0">
			<s:iterator value="#session.rentalHistoryList">
			<tr>
				<td><s:property value="customerDetails.customerId" /></td>
				<td><s:property value="customerDetails.firstName" /></td>
				<td><s:property value="movieDetails.movieName" /></td>
				<td><s:property value="movieDetails.categories.categoryName" /></td>
				<td><s:property value="rentalId" /></td>
				<td><s:date name="rentalDate"  format="dd/MM/yyyy"/></td>
				<td><s:date name="actualReturnDate"  format="dd/MM/yyyy"/></td>
				<td><s:property value="movieDetails.categories.bonus" /></td>
				<td><s:property value="status" /></td>
				<td><s:property value="lateCharges" /></td>
				<td><s:property value="charges" /></td>
			</tr>		
			</s:iterator>
			</s:if>	
			<s:else>
				<tr><td colspan="11" style="text-align:center">Results not found</td></tr>
			</s:else>
		</table>
	</s:form>
	</div>
</body>
</html>