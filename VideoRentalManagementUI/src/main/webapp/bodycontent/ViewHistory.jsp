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
	<s:actionmessage/>
	<br />
	<s:form theme="simple" id="viewHistoryForm" name="viewHistoryForm">
		<h2>Customer Rental History</h2>
		<table border="2" class="bigTable">
			<tr class="headerRow">
				<td>VRMSID</td>
				<td>Customer Name</td>
				<td>Movie</td>
				<td>Category</td>
				<td>Rental Id</td>
				<td>Rented Date</td>
				<td>Return Date</td>
				<td>Bonus</td>
				<td>Bonus status</td>
				<td>Late charges</td>
				<td>Rent Status</td>
				<td>Amount</td>
			</tr>
			<s:if test="#session.rentalHistoryList.size()>0">
			<s:iterator value="#session.rentalHistoryList">
			<tr>
				<td><s:property value="customerDetails.vrmsId" /></td>
				<td><s:property value="customerDetails.firstName" /></td>
				<td><s:property value="movies.movieName" /></td>
				<td><s:property value="movies.categories.categoryName" /></td>
				<td><s:property value="rentalId" /></td>
				<td><s:date name="rentalDate"  format="dd/MM/yyyy"/></td>
				<td><s:date name="actualReturnDate"  format="dd/MM/yyyy"/></td>
				<td><s:property value="bonusPoints" /></td>
				<td><s:property value="bonusStatus" /></td>
				<td><s:property value="lateCharges" /></td>
				<td><s:property value="rentalStatus" /></td>
				<td><s:property value="amount" /></td>
			</tr>		
			</s:iterator>
			</s:if>	
		</table>
	</s:form>
	<br><br>
	<div class="homeImg">
		<a href="index.jsp"><img alt="" src="images/Home.png"></a>
	</div>
</body>
</html>