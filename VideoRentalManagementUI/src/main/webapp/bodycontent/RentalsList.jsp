<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />
<link type="text/css" href="css/vrms-content-styles.css" rel="stylesheet" />
<title>VRMS</title>
<script type="text/javascript">
	function closeRental(rentalId) {
		document.getElementById('rentalEditId').value = rentalId;
		document.rentalsListForm.action = 'rentalAction_closeRental.action';
		document.rentalsListForm.submit();
		return true;
	}
</script>
</head>
<body>
	<div class="col bodyContainer">
		<s:actionmessage />
		<br />
		<s:form theme="simple" id="rentalsListForm" name="rentalsListForm">
			<h2>Rentals List</h2>
			<table border="0" class="bigTable">
				<tr class="headerRow">
					<th>Rental Id</th>
					<th>Customer Name</th>
					<th>VRMSID</th>
					<th>Email</th>
					<th>Movie</th>
					<th>Rented Date</th>
					<th>To be Return</th>
					<th>Rent Status</th>
				</tr>
				<s:if test="#session.rentalsList.size()>0">
					<s:iterator value="#session.rentalsList">
						<tr>
							<td><s:property value="rentalId" /></td>
							<td><s:property value="customerDetails.firstName" /></td>
							<td><s:property value="customerDetails.customerId" /></td>
							<td><s:property value="customerDetails.email" /></td>
							<td><s:property value="movieDetails.movieName" /></td>
							<td><s:date name="rentalDate" format="dd/MM/yyyy" /></td>
							<td><s:date name="expectedReturnDate" format="dd/MM/yyyy" /></td>
							<td><s:property value="status" /></td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
		</s:form>
	</div>
</body>
</html>