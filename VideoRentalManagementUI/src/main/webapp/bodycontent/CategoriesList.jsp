<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Movie Categories</h1>
	<p>Define and manage genres for your catalogue.</p>
</div>
<s:form theme="simple" action="categoriesAction_defineCategory.action">
	<div style="display: flex; gap: 0.75rem; margin-bottom: 1.25rem">
		<s:submit cssClass="btn btn-primary btn-sm" value="+ Add Category"></s:submit>
	</div>
	<div class="panel">
		<div class="tbl-wrap">
			<table>
				<thead>
					<tr>
						<th>Category Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="#session.categoriesList.size()>0">
						<s:iterator value="#session.categoriesList">
							<tr>
								<td><s:property value="categoryName" /></td>
								<td><s:property value="categoryDesc" /></td>
								<td><s:property value="activePrice" /></td>
								<td><span class="pill pill-green"><s:property
											value="status" /></span></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
		</div>
	</div>
</s:form>
