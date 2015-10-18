<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/vrms.css" rel="stylesheet" />
<title>VRMS</title>
<script type="text/javascript">
function closeRental(rentalId)
{
	document.getElementById('rentalEditId').value=rentalId;
	document.rentalsListForm.action='rentalAction_closeRental.action';
	document.rentalsListForm.submit();
    return true;   
}
</script>
</head>
<body>
	<s:actionmessage/>
	<s:form theme="simple" id="rentalsListForm" name="rentalsListForm">
		<h2>Rentals List</h2>
		<table border="2" class="bigTable">
			<tr class="headerRow">
				<td>Rental Id</td>
				<td>Customer Name</td>
				<td>VRMSID</td>
				<td>Email</td>
				<td>Movie</td>
				<td>Rented Date</td>
				<td>To be Return</td>
				<td>Rent Status</td>
			</tr>
			<s:if test="#session.rentalsList.size()>0">
			<s:iterator value="#session.rentalsList">
			<tr>
				<td><s:property value="rentalId" /></td>
				<td><s:property value="customerDetails.firstName" /></td>
				<td><s:property value="customerDetails.vrmsId" /></td>
				<td><s:property value="customerDetails.email" /></td>
				<td><s:property value="movies.movieName" /></td>
				<td><s:date name="rentalDate"  format="dd/MM/yyyy"/></td>
				<td><s:date name="expectedReturnDate"  format="dd/MM/yyyy"/></td>
				<td><s:property value="rentalStatus" /></td>
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