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
</head>
<body>
	<div class="col bodyContainer">
		<s:actionmessage />
		<br />
		<s:form theme="simple">
			<h2>Movies List</h2>
			<br>
			<table border="0" class="bigTable">
				<tr class="headerRow">
					<th>Movie Name</th>
					<th>Description</th>
					<th>Category</th>
					<th>Price</th>
					<th>Copies</th>
				</tr>
				<s:if test="#session.moviesList.size()>0">
					<s:iterator value="#session.moviesList">
						<tr>
							<td><s:property value="movieName" /></td>
							<td><s:property value="movieDesc" /></td>
							<td><s:property value="categories.categoryName" /></td>
							<td><s:property value="categories.activePrice" /></td>
							<td><s:property value="availableCopies" /></td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
		</s:form>
	</div>
</body>
</html>