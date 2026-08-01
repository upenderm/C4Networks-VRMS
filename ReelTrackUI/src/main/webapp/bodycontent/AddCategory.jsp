<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Add Category</h1>
	<p>Define a new movie genre for your catalogue.</p>
</div>
<s:form action="categoriesAction_addCategory.action" theme="simple">
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
	<div class="panel" style="max-width: 540px">
		<div class="panel-header">
			<h2>Category Details</h2>
		</div>
		<div style="padding: 1.5rem">
			<div class="form-grid cols-1">
				<div class="field">
					<label>Category Name</label>
					<s:textfield name="categoryName" />
				</div>
				<div class="field">
					<label>Description</label>
					<s:textfield name="categoryDescription" />
				</div>
				<div class="field">
					<label>Price</label>
					<s:textfield name="activePrice" />
				</div>
				<div class="field">
					<label>Bonus Points</label>
					<s:textfield name="bonus" />
				</div>
			</div>
			<div class="form-actions">
				<s:reset value="Reset" cssClass="btn btn-ghost" />
				<s:submit value="Save Category" cssClass="btn btn-primary" />
			</div>
		</div>
	</div>
</s:form>
