<%@ taglib uri="/struts-tags" prefix="s" %>
<jsp:directive.page import="java.util.ArrayList"  />
<% final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In "+this.getClass().getSimpleName().replace("_",".")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/vrms.css" rel="stylesheet" />
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
    x.onreadystatechange=stateChanged;
    x.open("POST",url,true);
    x.send(null);
}
function stateChanged(){
    if(x.readyState==4||x.readyState=="complete"){
    		var result=x.responseText;
    		console.log("Ajax response is :"+result);
    		document.getElementById('rentalDetailsDiv').innerHTML = result;
    }else if (x.readyState == '803'){
		alert("No select option available on the server");
	}
}

function closeRental(rentalId)
{
	document.getElementById('rentalEditId').value=rentalId;
	document.forms[0].action='rentalAction_rentalFinalize.action';
	document.forms[0].submit();
    return true;   
}
</script>
</head>
<body>
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
	<table class="midTable" border="2">
		<tr><td colspan="3">&nbsp;</td></tr>
		<tr>
			<td>Customer Name</td>
			<td>&nbsp;</td>
			<td>
				<s:select list="#session['customerMap']" id="customerName" name="customerName" listKey="key" listValue="value" cssClass="selwidth" />
			</td>
		</tr>
		<tr><td colspan="3"><input type="button" onclick="getRentalsByCustomerId();" value="View Active Rentals by this Customer" /></td></tr>
	</table>
	<fieldset>
  		<legend>Rental Details</legend>
  		<div>&nbsp;</div>
		<div id="rentalDetailsDiv"></div>
 	</fieldset>
	
	
	<br />
	<br />
	<div class="homeImg">
		<a href="index.jsp"><img alt="" src="images/Home.png"></a>
	</div>
</s:form>
</body>
</html>