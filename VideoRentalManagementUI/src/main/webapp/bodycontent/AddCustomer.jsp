<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />
<link type="text/css" href="css/vrms-content-styles.css" rel="stylesheet" />
<title>VRMS</title>
</head>
<body>
<div class="col bodyContainer">
<br />
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
	<table class="midTable" border="0">
		
		<tr>
			<td>First Name<span style="color:red">&nbsp;*</span></td>
			<td><s:textfield name="firstName" cssClass="selwidth" required="true"></s:textfield></td>
		</tr>
		<tr>
			<td>Last Name<span style="color:red">&nbsp;*</span></td>
			<td><s:textfield name="lastName" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><s:textfield name="email" cssClass="selwidth" required="true"></s:textfield></td>
		</tr>
		<tr>
			<td>Address<span style="color:red">&nbsp;*</span></td>
			<td><s:textfield name="address" cssClass="selwidth" required="true"></s:textfield></td>
		</tr>
		<tr>
			<td>Phone</td>
			<td><s:textfield name="phone" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td>Mobile<span style="color:red">&nbsp;*</span></td>
			<td><s:textfield name="mobile" cssClass="selwidth" maxlength="10"></s:textfield></td>
		</tr>
		<tr>
			<td><s:reset value="Reset" cssClass="submitClass" /></td>
			<td><s:submit value="Save" cssClass="submitClass" /></td>
		</tr>
	</table>
</s:form>
</div>
</body>
</html>