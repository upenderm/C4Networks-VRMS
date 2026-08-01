<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Add Movie</h1>
	<p>Add a new title to your catalogue.</p>
</div>
<s:form action="moviesAction_addMovie.action" theme="simple">
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
	<div class="panel" style="max-width: 640px">
		<div class="panel-header">
			<h2>Movie Details</h2>
		</div>
		<div style="padding: 1.5rem">
			<div class="form-grid">
				<div class="field form-full">
					<label>Movie Name</label>
					<s:textfield name="movieName" />
				</div>
				<div class="field form-full">
					<label>Description</label>
					<s:textfield name="movieDesc" />
				</div>
				<div class="field">
					<label>Category</label>
					<s:select list="#session['categoriesMap']" name="categoryId"
						listKey="key" listValue="value" />
				</div>
				<div class="field">
					<label>No. of Copies</label>
					<s:textfield name="availableCopies" />
				</div>
			</div>
			<div class="form-actions">
				<s:reset value="Reset" cssClass="btn btn-ghost" />
				<s:submit value="Save Movie" cssClass="btn btn-primary" />
			</div>
		</div>
	</div>
</s:form>
