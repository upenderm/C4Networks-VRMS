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
</head>
<body>
	<div class="col bodyContainer">
		<br />
		<h2>User Settings</h2>
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
		<div>This Page is Under Construction</div>
	</div>
</body>
</html>