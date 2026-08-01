<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>Add Customer</h1>
	<p>Register a new customer account.</p>
</div>
<s:form action="customerAction_addCustomer.action" theme="simple">
	<s:token></s:token>
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
			<h2>Customer Details</h2>
		</div>
		<div style="padding: 1.5rem">
			<div class="form-grid">
				<div class="field">
					<label>First Name <span style="color: var(--danger)">*</span></label>
					<s:textfield name="firstName" required="true" />
				</div>
				<div class="field">
					<label>Last Name <span style="color: var(--danger)">*</span></label>
					<s:textfield name="lastName" />
				</div>
				<div class="field">
					<label>Email <span style="color: var(--danger)">*</span></label>
					<s:textfield name="email" required="true" />
				</div>
				<div class="field">
					<label>Address <span style="color: var(--danger)">*</span></label>
					<s:textfield name="address" required="true" />
				</div>
				<div class="field">
					<label>Phone</label>
					<s:textfield name="phone" />
				</div>
				<div class="field">
					<label>Mobile <span style="color: var(--danger)">*</span></label>
					<s:textfield name="mobile" maxlength="10" />
				</div>
			</div>
			<div class="form-actions">
				<s:reset value="Reset" cssClass="btn btn-ghost" />
				<s:submit value="Save Customer" cssClass="btn btn-primary" />
			</div>
		</div>
	</div>
</s:form>
<script>
	window.onload = function() {
		doThis();
	};
	function doThis() {
		if (document.querySelector('.actionMessage')) {
			if (document.getElementById('addCustModalDlg') != null) {
				document.getElementById('addCustModalDlg').close();
			}
		}
	}
</script>
