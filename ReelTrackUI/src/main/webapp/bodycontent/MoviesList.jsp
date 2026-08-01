<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Movies</h1>
	<p>Your complete movie catalogue.</p>
</div>
<s:form theme="simple" action="moviesAction_defineMovie.action">
	<div style="display: flex; gap: 0.75rem; margin-bottom: 1.25rem">
		<s:submit cssClass="btn btn-primary btn-sm" value="+ Add Movie"></s:submit>
	</div>
	<div class="panel">
		<div class="tbl-wrap">
			<table>
				<thead>
					<tr>
						<th>Movie Name</th>
						<th>Description</th>
						<th>Category</th>
						<th>Price</th>
						<th>Copies</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="#session.moviesList.size()>0">
						<s:iterator value="#session.moviesList">
							<tr>
								<td><strong><s:property value="movieName" /></strong></td>
								<td><s:property value="movieDesc" /></td>
								<td><span class="pill pill-purple"><s:property
											value="categories.categoryName" /></span></td>
								<td><s:property value="categories.activePrice" /></td>
								<td><s:property value="availableCopies" /></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
		</div>
	</div>
</s:form>
