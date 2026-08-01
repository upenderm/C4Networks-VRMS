<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<script>
	function getRentalsByCustomerId() {
		var customerId = document.getElementById('customerName').value;
		x = getXmlHttpObject();
		if (x == null) {
			alert("Browser doesn't support HTTP Request");
			return;
		}
		var url = "rentalAction_viewRentalsByCustomer.action?customerId="
				+ customerId;
		x.onreadystatechange = stateChangedForRentalClose;
		x.open("POST", url, true);
		x.send(null);
	}
	function stateChangedForRentalClose() {
		if (x.readyState == 4 || x.readyState == "complete") {
			document.getElementById('rentalDetailsDiv').innerHTML = x.responseText;
		} else if (x.readyState == '803') {
			alert("No select option available on the server");
		}
	}

	function closeRental(rentalId) {
		document.getElementById('rentalEditId').value = rentalId;
		document.forms[1].action = 'rentalAction_rentalFinalize.action';
		document.forms[1].submit();
		return true;
	}
</script>
<div class="page-heading">
	<h1>Close a Rental</h1>
	<p>Look up a customer's active rentals and process a return.</p>
</div>
<s:form action="rentalAction_addRental.action" theme="simple">
	<s:hidden name="rentalEditId" id="rentalEditId"></s:hidden>
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
	<div class="panel" style="max-width: 600px; margin-bottom: 1.5rem">
		<div class="panel-header">
			<h2>Find Customer</h2>
		</div>
		<div style="padding: 1.5rem">
			<div class="form-grid">
				<div class="field">
					<label>Customer Name</label>
					<s:select list="#session['customerMap']" id="customerName"
						name="customerName" listKey="key" listValue="value" />
				</div>
				<div class="field"
					style="display: flex; flex-direction: column; justify-content: flex-end">
					<input type="button" class="btn btn-ghost"
						onclick="getRentalsByCustomerId();" value="View Active Rentals" />
				</div>
			</div>
		</div>
	</div>
	<div class="panel">
		<div class="panel-header">
			<h2>Rental Details</h2>
		</div>
		<div id="rentalDetailsDiv"
			style="padding: 1.25rem; color: var(--muted); font-size: 0.875rem">Select
			a customer above to view their active rentals.</div>
	</div>
</s:form>
