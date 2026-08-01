<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Copies &amp; Stock</h1>
	<p>Track physical copies and their availability.</p>
</div>
<div class="stat-row" style="max-width: 700px">
	<div class="stat-card">
		<span class="sc-label">Total Copies</span><span class="sc-value">—</span><span
			class="sc-sub">In inventory</span>
	</div>
	<div class="stat-card">
		<span class="sc-label">Available</span><span class="sc-value"
			style="color: var(--success)">—</span><span class="sc-sub"
			style="color: var(--success)">Ready to rent</span>
	</div>
	<div class="stat-card">
		<span class="sc-label">Rented Out</span><span class="sc-value"
			style="color: var(--warning)">—</span><span class="sc-sub"
			style="color: var(--warning)">Currently out</span>
	</div>
	<div class="stat-card">
		<span class="sc-label">Damaged</span><span class="sc-value"
			style="color: var(--danger)">—</span><span class="sc-sub"
			style="color: var(--danger)">Needs attention</span>
	</div>
</div>
<div class="panel">
	<div class="panel-header">
		<h2>Copy Inventory</h2>
	</div>
	<div class="tbl-wrap">
		<table>
			<thead>
				<tr>
					<th>Copy ID</th>
					<th>Movie</th>
					<th>Category</th>
					<th>Available Copies</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<s:if
					test="#session.moviesList != null && #session.moviesList.size() > 0">
					<s:iterator value="#session.moviesList">
						<tr>
							<td class="mono"><s:property value="movieId" /></td>
							<td><strong><s:property value="movieName" /></strong></td>
							<td><span class="pill pill-purple"><s:property
										value="categories.categoryName" /></span></td>
							<td><s:property value="availableCopies" /></td>
							<td><s:if test="availableCopies > 0">
									<span class="pill pill-green">Available</span>
								</s:if> <s:else>
									<span class="pill pill-red">Out of Stock</span>
								</s:else></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr>
						<td colspan="5"
							style="text-align: center; padding: 2rem; color: var(--muted)">No
							copy data available.</td>
					</tr>
				</s:else>
			</tbody>
		</table>
	</div>
</div>
