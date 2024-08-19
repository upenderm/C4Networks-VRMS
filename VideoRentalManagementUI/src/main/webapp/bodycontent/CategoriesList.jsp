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
		<s:actionmessage />
		<br />
		<s:form theme="simple" action="categoriesAction_defineCategory.action">

			<h2>Categories List</h2>
			<div class="addCustDiv">
				<s:submit cssClass="buttonAddNew" value="Add Category"></s:submit>
			</div>
			<br>
			<table border="0" class="bigTable">
				<tr class="headerRow">
					<th>Category Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Status</th>
				</tr>
				<s:if test="#session.categoriesList.size()>0">
					<s:iterator value="#session.categoriesList">
						<tr>
							<td><s:property value="categoryName" /></td>
							<td><s:property value="categoryDesc" /></td>
							<td><s:property value="activePrice" /></td>
							<td><s:property value="status" /></td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
		</s:form>
	</div>
</body>
</html>