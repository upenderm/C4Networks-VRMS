<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/vrms.css" rel="stylesheet" />
<title>VRMS</title>
</head>
<body>
	
<s:form action="customerAction_addCustomer.action" theme="simple">
	<s:token></s:token>
	<h2>Add Customer</h2>
	<s:if test="hasActionMessages()">
	<div class="successMsg">
		<s:actionmessage/>
	</div>
	</s:if>
	<s:if test="hasFieldErrors()|| hasActionErrors()">
	<div class="errorMsg">
		<s:fielderror />
		<s:actionerror/>
	</div>
	</s:if>
	<br />
	<center>
	<table class="midTable" border="2">
		<tr class="headerRow"><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td width="30%">First Name</td>
			<td><s:textfield name="firstName" cssClass="selwidth" required="true"></s:textfield></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><s:textfield name="lastName" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><s:textfield name="email" cssClass="selwidth" required="true"></s:textfield></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><s:textfield name="address" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td>Phone</td>
			<td><s:textfield name="phone" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td><s:textfield name="mobile" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td><s:submit value="Save" /></td>
			<td><s:reset value="Reset" /></td>
		</tr>
	</table></center>
	<br />
	<br />
</s:form>
	<div class="homeImg">
		<a href="index.jsp"><img alt="" src="images/Home.png"></a>
	</div>

</body>
</html>