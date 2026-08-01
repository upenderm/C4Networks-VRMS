<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

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
