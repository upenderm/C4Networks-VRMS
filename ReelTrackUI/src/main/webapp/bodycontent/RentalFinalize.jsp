<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<script>

function viewCustomerBonus(customerId){
	console.log("Customer id is :"+customerId);
	x=getXmlHttpObject();
    if(x==null){
        alert("Browser doesn't support HTTP Request");
        return
    }
    var url = "rentalAction_viewCustomerBonus.action";
    url+="?customerId="+customerId;
    x.onreadystatechange=stateChangedBonus;
    x.open("POST",url,true);
    x.send(null);
}
function stateChangedBonus(){
    if(x.readyState==4||x.readyState=="complete"){
    		var result=x.responseText;
    		console.log("Ajax response is :"+result);
    		document.getElementById('bonusDiv').innerHTML = result;
    		if(result >= 5){
    			console.log("In if block");
    			document.getElementById('bonusCheck').disabled = false;
    		}
    }else if (x.readyState == '803'){
		alert("No select option available on the server");
	}
}
</script>
<div class="page-heading">
	<h1>Finalize Rental</h1>
	<p>Review charges and confirm the return.</p>
</div>

<s:form action="rentalAction_closeRental.action" theme="simple">
	<s:actionmessage />
	<s:actionerror />
	<s:hidden name="rentalEditId" id="rentalEditId"></s:hidden>
	<s:hidden name="customerName" id="customerName"></s:hidden>

	<div
		style="display: grid; grid-template-columns: 1fr 1fr; gap: 1.5rem; max-width: 860px">

		<div class="panel">
			<div class="panel-header">
				<h2>Rental Summary</h2>
			</div>
			<div
				style="padding: 1.25rem; display: flex; flex-direction: column; gap: 0.75rem; font-size: 0.875rem">
				<div style="display: flex; justify-content: space-between">
					<span style="color: var(--muted)">Customer</span><span><s:property
							value="%{customerName}" /></span>
				</div>
				<div style="display: flex; justify-content: space-between">
					<span style="color: var(--muted)">Movie</span><span><s:property
							value="%{movieName}" /></span>
				</div>
				<hr class="divider" style="margin: 0.25rem 0" />
				<div style="display: flex; justify-content: space-between">
					<span style="color: var(--muted)">Actual Price</span><span><s:property
							value="%{actualPrice}" /></span>
				</div>
				<div style="display: flex; justify-content: space-between">
					<span style="color: var(--muted)">Late Charges</span><span
						style="color: var(--danger)"><s:property
							value="%{lateCharges}" /></span>
				</div>
				<div
					style="display: flex; justify-content: space-between; font-weight: 700">
					<span style="color: var(--muted)">Total</span><span><s:property
							value="%{totalPrice}" /></span>
				</div>
				<hr class="divider" style="margin: 0.25rem 0" />
				<div
					style="display: flex; justify-content: space-between; align-items: center">
					<a href="javascript:void(0)"
						onclick="viewCustomerBonus('${customerId}')"
						style="color: var(--accent); font-size: 0.8rem">View Bonus
						Points</a>
					<div id="bonusDiv" class="pill pill-purple"></div>
				</div>
				<div style="display: flex; align-items: center; gap: 0.5rem">
					<s:checkbox disabled="true" id="bonusCheck" name="bonusCheck" />
					<span style="color: var(--muted); font-size: 0.8rem">Use
						bonus points for billing</span>
				</div>
			</div>
		</div>

		<div class="panel">
			<div class="panel-header">
				<h2>Close Rental</h2>
			</div>
			<div style="padding: 1.5rem">
				<div class="form-grid cols-1">
					<div class="field">
						<label>Amount Billed</label>
						<s:textfield name="billedAmount" value="%{billedAmount}" />
					</div>
					<div class="field">
						<label>Comments</label>
						<s:textarea name="comments" value="%{comments}" />
					</div>
				</div>
				<div class="form-actions">
					<s:reset value="Reset" cssClass="btn btn-ghost" />
					<s:submit value="Confirm &amp; Close" cssClass="btn btn-success" />
				</div>
			</div>
		</div>

	</div>
</s:form>
