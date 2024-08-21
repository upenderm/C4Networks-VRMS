<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<script>
$(function() {
	$( "#expectedReturnDate" ).datepicker({dateFormat: 'yy-mm-dd'});
});

function getAvailableCopies(movieId){
	x=getXmlHttpObject();
    if(x==null){
        alert("Browser doesn't support HTTP Request");
        return
    }
    var url = "rentalAction_getAvailableCopies.action";
    url+="?movieId="+movieId;
    x.onreadystatechange=stateChanged;
    x.open("POST",url,true);
    x.send(null);
}

function stateChanged(){
    if(x.readyState==4||x.readyState=="complete"){
    		var result=x.responseText;
    		console.log("Ajax response is :"+result);
    		document.getElementById('availableCopies').innerHTML = '<b>' + result + ' </b>copies available';
    }else if (x.readyState == '803'){
		alert("No select option available on the server");
	}
}
</script>

<div class="col bodyContainer">
	<br />
	<s:form action="rentalAction_addRental.action" theme="simple">
		<s:actionmessage />
		<s:actionerror />
		<h2>Make a Rental</h2>
		<table class="midTable" border="1">
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td width="35%">Movie Name</td>
				<td width="35%">
					<s:select list="#session['moviesMap']" name="movieId" listKey="key" listValue="value" onchange="getAvailableCopies(this.value)" cssClass="selwidth" />
				</td>
				<td><div id="availableCopies"></div></td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td colspan="2">
					<s:select cssClass="selwidth" list="#session['customerMap']" name="customerId" listKey="key" listValue="value" />
				</td>
			</tr>
			<tr>
				<td>Return Date</td>
				<td colspan="2">
					<s:textfield name="expectedReturnDate" id="expectedReturnDate" cssClass="selwidth" />
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><s:reset value="Reset" cssClass="submitClass" /></td>
				<td><s:submit value="Save" cssClass="submitClass" /></td>
			</tr>
		</table>
	</s:form>
</div>
