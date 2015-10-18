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
</head>
<body>
	<s:actionmessage/>
	<s:form theme="simple">
		<h2>Movies List</h2>
		<br>
		<table border="2" class="bigTable">
			<tr class="headerRow">
				<td>Movie Name</td>
				<td>Description</td>
				<td>Category</td>
				<td>Price</td>
				<td>Copies</td>
			</tr>
			<s:if test="#session.moviesList.size()>0">
			<s:iterator value="#session.moviesList">
			<tr>
				<td><s:property value="movieName" /></td>
				<td><s:property value="movieDesc" /></td>
				<td><s:property value="categories.categoryName" /></td>
				<td><s:property value="categories.price" /></td>
				<td><s:property value="copies" /></td>
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