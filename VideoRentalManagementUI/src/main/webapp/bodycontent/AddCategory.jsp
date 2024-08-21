<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<div class="col bodyContainer">
	<br />
	<s:form action="categoriesAction_addCategory.action" theme="simple">
		<h2>Add Category</h2>
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
				<td>Category Name</td>
				<td><s:textfield name="categoryName" cssClass="selwidth"></s:textfield></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><s:textfield name="categoryDescription" cssClass="selwidth"></s:textfield></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><s:textfield name="activePrice" cssClass="selwidth"></s:textfield></td>
			</tr>
			<tr>
				<td>Bonus</td>
				<td><s:textfield name="bonus" cssClass="selwidth"></s:textfield></td>
			</tr>
			<tr>
				<td><s:reset value="Reset" cssClass="submitClass" /></td>
				<td><s:submit value="Save" cssClass="submitClass" /></td>
			</tr>
		</table>
	</s:form>
</div>
