<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />
<link type="text/css" href="css/vrms-content-styles.css" rel="stylesheet" />
<title>VRMS</title>
<script src="js/vrms.js"></script>
<script type="text/javascript">
function getRentalsByCustomerId(){
	var customerId = document.getElementById('customerName').value;
	x=getXmlHttpObject();
    if(x==null){
        alert("Browser doesn't support HTTP Request");
        return
    }
    var url = "rentalAction_viewRentalsByCustomer.action";
    url+="?customerId="+customerId;
    x.onreadystatechange=stateChangedForRentalClose;
    x.open("POST",url,true);
    x.send(null);
}
function stateChangedForRentalClose(){
    if(x.readyState==4||x.readyState=="complete"){
    		var result=x.responseText;
    		console.log("stateChangedForRentalClose - Ajax response is :"+result);
    		document.getElementById('rentalDetailsDiv').innerHTML = result;
    }else if (x.readyState == '803'){
		alert("No select option available on the server");
	}
}

function closeRental(rentalId)
{
	console.log("rental Id is :"+rentalId);
	document.getElementById('rentalEditId').value=rentalId;
	document.forms[0].action='rentalAction_rentalFinalize.action';
	document.forms[0].submit();
    return true;   
}
</script>
</head>
<body>
<div class="col bodyContainer">
<br />
<s:form action="rentalAction_addRental.action" theme="simple">
	<h2>Close a Rental</h2>
	<s:if test="hasActionMessages()">
	<div class="successMsg">
		<s:actionmessage/>
	</div>
	</s:if>
	<s:if test="hasFieldErrors()|| hasActionErrors()">
	<div class="errorMsg">
		<s:fielderror />
		<s:actionerror/>
	</div>
	</s:if>
	<br />
	<table class="midTable" border="0">
		<tr>
			<td>Customer Name</td>
			<td>
				<s:select list="#session['customerMap']" id="customerName" name="customerName" listKey="key" listValue="value" cssClass="selwidth" />
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
				<input type="button" class="submitClass" onclick="getRentalsByCustomerId();" value="View Active Rentals by this Customer" />
			</td>
		</tr>
	</table>
	<fieldset>
  		<legend>Rental Details</legend>
  		
		<div id="rentalDetailsDiv">&nbsp;</div>
 	</fieldset>
</s:form>
</div>
</body>
</html>