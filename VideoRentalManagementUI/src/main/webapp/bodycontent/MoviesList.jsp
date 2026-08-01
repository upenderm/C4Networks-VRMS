<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<div class="col bodyContainer">
	<s:actionmessage />
	<br />
	<s:form theme="simple" action="moviesAction_defineMovie.action">
		<h2>Movies List</h2>
		<div class="addCustDiv">
			<s:submit cssClass="buttonAddNew" value="Add Movie"></s:submit>
		</div>
		<br>
		<table class="bigTable">
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
