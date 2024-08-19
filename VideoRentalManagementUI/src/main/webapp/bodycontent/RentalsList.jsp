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
	function submitThisForm(action) {
		document.rentalsListForm.action = action;
		document.rentalsListForm.submit();
	}
</script>
</head>
<body>
	<div class="col bodyContainer">
		<s:actionmessage />
		<br />
		<s:form theme="simple" id="rentalsListForm" name="rentalsListForm" action="">
			<s:if test="getShowRentals()=='active'">
				<h2>Active Rentals</h2>
			</s:if>
			<s:elseif test="getShowRentals()=='inactive">
				<h2>Inactive Rentals</h2>
			</s:elseif>
			<s:else>
				<h2>All Rentals List</h2>
			</s:else>
			
			<div class="addCustDiv">
				<s:submit cssClass="buttonAddNew" value="Create Rental" type="button" onclick="submitThisForm('rentalAction_defineRental.action')"></s:submit>
			</div>
			<div class="addCustDiv">
				<s:submit cssClass="buttonAddNew" value="Inactive Rentals" type="button" onclick="submitThisForm('rentalAction_viewInactiveRentals.action')"></s:submit>
			</div>
			<div class="addCustDiv">
				<s:submit cssClass="buttonAddNew" value="View All Rentals" type="button" onclick="submitThisForm('rentalAction_viewAllRentals.action')"></s:submit>
			</div>
			<br>

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
							<td><s:property value="agentCustomerDetails.firstName" />, <s:property value="agentCustomerDetails.lastName" /></td>
							<td><s:property value="agentCustomerDetails.agCustomerId" /></td>
							<td><s:property value="agentCustomerDetails.email" /></td>
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