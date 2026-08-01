<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<div class="col bodyContainer">
	<br />
	<s:form action="moviesAction_addMovie.action" theme="simple">
		<h2>Add Movie</h2>
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
		<table class="midTable">
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
				<td><s:select list="#session['categoriesMap']" name="categoryId" listKey="key" listValue="value" cssClass="selwidth" /></td>
			</tr>
			<tr>
				<td>No. of Copies</td>
				<td><s:textfield name="availableCopies" cssClass="selwidth"></s:textfield></td>
			</tr>
			<tr>
				<td><s:reset value="Reset" cssClass="submitClass" /></td>
				<td><s:submit value="Save" cssClass="submitClass" /></td>
			</tr>
		</table>
	</s:form>
</div>
