<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Customers</h1>
	<p>Manage your customer base.</p>
</div>
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
<s:form theme="simple" id="customerList" name="customerList">
	<div style="display: flex; gap: 0.75rem; margin-bottom: 1.25rem">
		<button type="button" class="btn btn-primary btn-sm open-button">+
			Add New Customer</button>
	</div>
	<dialog class="modal" id="addCustModalDlg"> <object
		data="customerAction_defineCustomer.action"
		style="height: 33em; width: 50vh"></object>
	<template class="fallback"></template>
	<br>
	<button type="button" class="btn btn-danger btn-sm close-button">Close</button>
	</dialog>
	<div class="panel">
		<div class="tbl-wrap">
			<table>
				<thead>
					<tr>
						<th>VRMS ID</th>
						<th>Customer Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Address</th>
						<th>Status</th>
						<th>Rental History</th>
					</tr>
				</thead>
				<tbody>
					<s:if test="#session.customersList.size()>0">
						<s:iterator value="#session.customersList">
							<tr>
								<td class="mono"><s:property value="agCustomerId" /></td>
								<td><s:property value="firstName" />, <s:property
										value="lastName" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="mobile" /></td>
								<td><s:property value="addressLine1" /></td>
								<td><span class="pill pill-green"><s:property
											value="createdDate" /></span></td>
								<td><a href="javascript:void(0)"
									onclick="viewCustomerRentalHistory('${agCustomerOID}')"
									class="btn btn-ghost btn-sm">View</a></td>
							</tr>
						</s:iterator>
					</s:if>
				</tbody>
			</table>
		</div>
	</div>
	<s:hidden name="customerId" id="customerId"></s:hidden>
</s:form>
<script>
const modalDlg = document.getElementById('addCustModalDlg');
const openModal = document.querySelector(".open-button");
const closeModal = document.querySelector(".close-button");
document.addEventListener('DOMContentLoaded', () => { fillDialogContent(modalDlg); });
openModal.addEventListener("click", () => { localStorage["mymodaldlg"] = modalDlg; modalDlg.showModal(); });
if (closeModal != null) { closeModal.addEventListener("click", () => { modalDlg.close(); }); }
function fillDialogContent(modalDlg) {
	const template = modalDlg.querySelector(':scope > .fallback');
	const content = template.content.cloneNode(true);
	const objectEl = modalDlg.querySelector('object');
	objectEl.append(content);
}

function viewCustomerRentalHistory(customerId) {
	document.getElementById('customerId').value = customerId;
	document.customerList.action = "customerAction_viewRentalHistory.action";
	document.customerList.submit();
}
</script>
