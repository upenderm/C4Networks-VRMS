<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<div class="col bodyContainer">
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
	<br />
	<s:form theme="simple" id="customerList" name="customerList">
		<h2>Customers List</h2>
		<div class="addCustDiv">
			<button type="button" class="open-button buttonAddNew">Add
				New Customer</button>
		</div>

		<dialog class="modal" id="addCustModalDlg"> 
			<object data="customerAction_defineCustomer.action" style="height: 33em; width: 50vh"></object> 
			<template class="fallback"></template> 
			<br>
			<button type="button" class="button close-button" style="background: darkred">close</button>
		</dialog>

		<div style="position: relative;">
			<table class="bigTable">
				<tr class="headerRow">
					<th>VRMS ID</th>
					<th>Customer Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Address</th>
					<th>Status</th>
					<th>Rental History</th>
				</tr>
				<s:if test="#session.customersList.size()>0">
					<s:iterator value="#session.customersList">
						<tr>
							<td><s:property value="agCustomerId" /></td>
							<td><s:property value="firstName" />, <s:property
									value="lastName" /></td>
							<td><s:property value="email" /></td>
							<td><s:property value="mobile" /></td>
							<td><s:property value="addressLine1" /></td>
							<td><s:property value="createdDate" /></td>
							<td><a href="javascript:void(0)"
								onclick="viewCustomerRentalHistory('${agCustomerOID}')">View</a></td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
		</div>
		<s:hidden name="customerId" id="customerId"></s:hidden>
	</s:form>
</div>

<script>

const modalDlg = document.getElementById('addCustModalDlg');
const openModal = document.querySelector(".open-button");
const closeModal = document.querySelector(".close-button");

document.addEventListener('DOMContentLoaded', () => {
	fillDialogContent(modalDlg);
})
openModal.addEventListener("click", () => {
//	console.log("Modal clicked to open");
	localStorage["mymodaldlg"] = modalDlg;
	modalDlg.showModal();
})
if (closeModal!=null ){
	closeModal.addEventListener("click", () => {
		modalDlg.close();
	})
}

function fillDialogContent(modalDlg) {
	const template = modalDlg.querySelector(':scope > .fallback');
	const content = template.content.cloneNode(true);
	const objectE1 = modalDlg.querySelector('object');
	objectE1.append(content);
}

function viewCustomerRentalHistory(customerId){
	console.log("customer id is :"+customerId);
	document.getElementById('customerId').value = customerId;
	document.customerList.action="customerAction_viewRentalHistory.action";
	document.customerList.submit();
}
</script>