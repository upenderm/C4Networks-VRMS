<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<script>
$(function() {
$( "#expectedReturnDate" ).datepicker();
});

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

<div class="col bodyContainer">
	<br />
	<s:form action="rentalAction_closeRental.action" theme="simple">
		<s:actionmessage />
		<s:actionerror />
		<s:hidden name="rentalEditId" id="rentalEditId"></s:hidden>
		<h2>Final closing data</h2>

		<table class="midTable">
			<tr>
				<td>Customer Name</td>
				<td>
					<div class="textDisplay">
						<s:property value="%{customerName}" />
					</div>
				</td>
			</tr>
			<tr>
				<td>Movie Name</td>
				<td>
					<div class="textDisplay">
						<s:property value="%{movieName}" />
					</div>
				</td>
			</tr>
			<tr>
				<td>Actual Price</td>
				<td>
					<div class="textDisplay">
						<s:property value="%{actualPrice}" />
					</div>
				</td>
			</tr>
			<tr>
				<td>Late charges</td>
				<td>
					<div class="textDisplay">
						<s:property value="%{lateCharges}" />
					</div>
				</td>
			</tr>
			<tr>
				<td>Total</td>
				<td>
					<div class="textDisplay">
						<s:property value="%{totalPrice}" />
					</div>
				</td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><s:textfield name="billedAmount" value="%{billedAmount}"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Comments</td>
				<td><s:textarea name="comments" value="%{comments}"></s:textarea>
				</td>
			</tr>
			<tr>
				<td><a href="javascript:void(0)"
					onclick="viewCustomerBonus('${customerId}')">View Bonus points</a>
				</td>
				<td><div id="bonusDiv" class="textDisplay"></div></td>
			</tr>
			<tr>
				<td><s:checkbox disabled="true" id="bonusCheck"
						name="bonusCheck" /></td>
				<td>
					<div class="textDisplay">
						<s:text name="Use Bonus points for Billing" />
					</div>
				</td>
			</tr>
			<tr>
				<td><s:reset value="Reset" cssClass="submitClass" /></td>
				<td><s:submit value="Save" cssClass="submitClass" /></td>
			</tr>
		</table>

		<s:hidden name="customerName" id="customerName"></s:hidden>
	</s:form>
</div>
