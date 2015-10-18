<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VRMS</title>
<!-- add styles -->
<link href="css/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/vrms.css" rel="stylesheet" />
<!-- add scripts -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
<script src="js/vrms.js"></script>
<script type="text/javascript">
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
</head>
<body>
<s:form action="rentalAction_closeRental.action" theme="simple">
	<s:actionmessage/>
	<s:actionerror/>
	<s:hidden name="rentalEditId" id="rentalEditId"></s:hidden>
	<h2>Final closing data</h2>
	<center>
	<table class="midTable" border="2">
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			<td>Customer Name</td>
			<td>
				<s:property value="finalData[3]" />
			</td>
		</tr>
		<tr>
			<td>Movie Name</td>
			<td>
				<s:property value="finalData[4]" />
			</td>
		</tr>
		<tr>
			<td>Actual Price</td>
			<td>
				<s:property value="finalData[0]" />
			</td>
		</tr>
		<tr>
			<td>Late charges</td>
			<td>
				<s:property value="finalData[2]" />
			</td>
		</tr>
		<tr>
			<td>Total</td>
			<td>
				<s:property value="finalData[1]" />
			</td>
		</tr>
		<tr>
			<td>Amount</td>
			<td>
				<s:textfield name="amount" cssClass="selwidth"></s:textfield>
			</td>
		</tr>
		<tr>
			<td>Comments</td>
			<td>
				<s:textarea name="comments" cols="30"></s:textarea>
			</td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0)" onclick="viewCustomerBonus(${finalData[5]})">View Bonus points</a>
			</td>
			<td><div id="bonusDiv" style="width: 50px; font-weight: bold;"></div></td>
		</tr>
		<tr>
			<td><s:checkbox disabled="true" id="bonusCheck" name="bonusCheck" /></td>
			<td>
				<s:text name="Use Bonus points for Billing" />
			</td>
		</tr>
		<tr>
			<td><s:submit value="Close" /></td>
			<td><s:reset value="Reset" /></td>
		</tr>
	</table>
	</center>
	<s:hidden name="customerName" id="customerName"></s:hidden>
	<br />
	<br />
	<div class="homeImg">
		<a href="index.jsp"><img alt="" src="images/Home.png"></a>
	</div>
</s:form>
</body>
</html>