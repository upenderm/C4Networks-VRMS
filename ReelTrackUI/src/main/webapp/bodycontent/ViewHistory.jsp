<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Rental History</h1>
	<p>Complete rental history for this customer.</p>
</div>
<s:form theme="simple" id="viewHistoryForm" name="viewHistoryForm">
	<div class="panel">
		<div class="tbl-wrap">
			<table>
				<thead>
					<tr>
						<th>VRMS ID</th>
						<th>Customer</th>
						<th>Movie</th>
						<th>Category</th>
						<th>Rental Id</th>
						<th>Rented</th>
						<th>Returned</th>
						<th>Bonus</th>
						<th>Status</th>
						<th>Late Charges</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="#session.rentalHistoryList.size()>0">
						<s:iterator value="#session.rentalHistoryList">
							<tr>
								<td class="mono"><s:property
										value="agentCustomerDetails.agCustomerId" /></td>
								<td><s:property value="agentCustomerDetails.firstName" />,
									<s:property value="agentCustomerDetails.lastName" /></td>
								<td><s:property value="movieDetails.movieName" /></td>
								<td><span class="pill pill-purple"><s:property
											value="movieDetails.categories.categoryName" /></span></td>
								<td class="mono"><s:property value="rentalId" /></td>
								<td><s:date name="rentalDate" format="dd/MM/yyyy" /></td>
								<td><s:date name="actualReturnDate" format="dd/MM/yyyy" /></td>
								<td><s:property value="movieDetails.categories.bonus" /></td>
								<td><s:if test="status=='OPEN'">
										<span class="pill pill-green"><s:property
												value="status" /></span>
									</s:if> <s:elseif test="status=='CLOSED'">
										<span class="pill pill-grey"><s:property value="status" /></span>
									</s:elseif> <s:else>
										<span class="pill pill-yellow"><s:property
												value="status" /></span>
									</s:else></td>
								<td><s:property value="lateCharges" /></td>
								<td><s:property value="charges" /></td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						<tr>
							<td colspan="11"
								style="text-align: center; padding: 2rem; color: var(--muted)">No
								rental history found.</td>
						</tr>
					</s:else>
				</tbody>
			</table>
		</div>
	</div>
</s:form>
