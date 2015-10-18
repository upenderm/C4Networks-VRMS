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
<s:form action="moviesAction_addMovie.action" theme="simple">
	<s:actionmessage/>
	<s:actionerror/>
	<h2>Add Movie</h2>
	<center>
	<table class="midTable" border="2">
		<tr class="headerRow"><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td>Movie Name</td>
			<td><s:textfield name="movieName" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><s:textfield name="movieDesc" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr>
			<td>Category</td>
			<td>
				<s:select list="#session['categoriesMap']" name="categories" listKey="key" listValue="value" cssClass="selwidth" />
			</td>
		</tr>
		<tr>
			<td>No. of Copies</td>
			<td><s:textfield name="copies" cssClass="selwidth"></s:textfield></td>
		</tr>
		<tr class="submitClass">
			<td><s:submit value="Save" /></td>
			<td><s:reset value="Reset" /></td>
		</tr>
	</table>
	</center>
	<br />
	<br />
	<div class="homeImg">
		<a href="index.jsp"><img alt="" src="images/Home.png"></a>
	</div>

</s:form>
</body>
</html>