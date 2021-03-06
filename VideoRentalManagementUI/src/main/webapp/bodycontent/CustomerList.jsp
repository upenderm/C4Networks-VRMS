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

<title>VRMS</title>
<script type="text/javascript">
function viewCustomerRentalHistory(customerId){
	console.log("customer id is :"+customerId);
	document.getElementById('customerId').value = customerId;
	document.customerList.action="customerAction_viewRentalHistory.action";
	document.customerList.submit();
}
</script>
</head>
<body>
	<div class="col bodyContainer">
		<s:if test="hasActionMessages()">
			<div class="successMsg">
				<s:actionmessage />
			</div>
		</s:if>
		<s:if test="hasFieldErrors()|| hasActionErrors()">
			<div class="errorMsg">
				<s:fielderror />
				<s:actionerror />
			</div>
		</s:if>
		<br />
		<s:form theme="simple" id="customerList" name="customerList">
			<h2>Customers List</h2>
			<div style="position: relative;">
				<table border="0" class="bigTable">
					<tr class="headerRow">
						<th>VRMS ID</th>
						<th>Customer Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Address</th>
						<th>Status</th>
						<th>Rental History</th>
					</tr>
					<s:if test="#session.customersList.size()>0">
						<s:iterator value="#session.customersList">
							<tr>
								<td><s:property value="customerId" /></td>
								<td><s:property value="firstName" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="mobile" /></td>
								<td><s:property value="addressLine1" /></td>
								<td><s:property value="addressLine2" /></td>
								<td><a href="javascript:void(0)" onclick="viewCustomerRentalHistory('${customerId}')">View</a></td>
							</tr>
						</s:iterator>
					</s:if>
				</table>
			</div>
			<s:hidden name="customerId" id="customerId"></s:hidden>
		</s:form>
	</div>
</body>
</html>