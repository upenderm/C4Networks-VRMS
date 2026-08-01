<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<script>
	function closeRental(rentalId) {
		document.getElementById('rentalEditId').value = rentalId;
		document.rentalsListForm.action = 'rentalAction_closeRental.action';
		document.rentalsListForm.submit();
		return true;
	}
	function submitThisForm(action) {
		document.rentalsListForm.action = action;
		document.rentalsListForm.submit();
	}
</script>
<div class="page-heading">
	<s:if test="getShowRentals()=='active'">
		<h1>Active Rentals</h1>
	</s:if>
	<s:elseif test="getShowRentals()=='inactive'">
		<h1>Inactive Rentals</h1>
	</s:elseif>
	<s:else>
		<h1>All Rentals</h1>
	</s:else>
	<p>Current and historical rental records.</p>
</div>
<s:form theme="simple" id="rentalsListForm" name="rentalsListForm"
	action="">
	<s:hidden name="rentalEditId" id="rentalEditId"></s:hidden>
	<div
		style="display: flex; gap: 0.75rem; margin-bottom: 1.25rem; flex-wrap: wrap">
		<s:submit cssClass="btn btn-primary btn-sm" value="+ Create Rental"
			type="button"
			onclick="submitThisForm('rentalAction_defineRental.action')"></s:submit>
		<s:submit cssClass="btn btn-ghost btn-sm" value="Inactive Rentals"
			type="button"
			onclick="submitThisForm('rentalAction_viewInactiveRentals.action')"></s:submit>
		<s:submit cssClass="btn btn-ghost btn-sm" value="View All Rentals"
			type="button"
			onclick="submitThisForm('rentalAction_viewAllRentals.action')"></s:submit>
	</div>
	<div class="panel">
		<div class="tbl-wrap">
			<table>
				<thead>
					<tr>
						<th>Rental Id</th>
						<th>Customer Name</th>
						<th>VRMS ID</th>
						<th>Email</th>
						<th>Movie</th>
						<th>Rented Date</th>
						<th>Return By</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="#session.rentalsList.size()>0">
						<s:iterator value="#session.rentalsList">
							<tr>
								<td class="mono"><s:property value="rentalId" /></td>
								<td><s:property value="agentCustomerDetails.firstName" />,
									<s:property value="agentCustomerDetails.lastName" /></td>
								<td class="mono"><s:property
										value="agentCustomerDetails.agCustomerId" /></td>
								<td><s:property value="agentCustomerDetails.email" /></td>
								<td><s:property value="movieDetails.movieName" /></td>
								<td><s:date name="rentalDate" format="dd/MM/yyyy" /></td>
								<td><s:date name="expectedReturnDate" format="dd/MM/yyyy" /></td>
								<td><s:if test="status=='OPEN'">
										<span class="pill pill-green"><s:property
												value="status" /></span>
									</s:if> <s:elseif test="status=='CLOSED'">
										<span class="pill pill-grey"><s:property value="status" /></span>
									</s:elseif> <s:else>
										<span class="pill pill-yellow"><s:property
												value="status" /></span>
									</s:else></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
		</div>
	</div>
</s:form>
