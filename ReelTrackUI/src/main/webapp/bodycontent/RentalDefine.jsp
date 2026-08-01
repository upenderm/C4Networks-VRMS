<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<script>
	function getAvailableCopies(movieId) {
		x = getXmlHttpObject();
		if (x == null) {
			alert("Browser doesn't support HTTP Request");
			return;
		}
		var url = "rentalAction_getAvailableCopies.action?movieId=" + movieId;
		x.onreadystatechange = stateChanged;
		x.open("POST", url, true);
		x.send(null);
	}
	function stateChanged() {
		if (x.readyState == 4 || x.readyState == "complete") {
			var result = x.responseText;
			document.getElementById('availableCopies').innerHTML = '<span class="pill pill-green">'
					+ result + ' copies available</span>';
		} else if (x.readyState == '803') {
			alert("No select option available on the server");
		}
	}
</script>

<div class="page-heading">
	<h1>Make a Rental</h1>
	<p>Select a customer, movie, and return date to create a rental.</p>
</div>

<s:form action="rentalAction_addRental.action" theme="simple">
	<s:actionmessage />
	<s:actionerror />
	<div class="panel" style="max-width: 680px">
		<div class="panel-header">
			<h2>Rental Details</h2>
		</div>
		<div style="padding: 1.5rem">
			<div class="form-grid">
				<div class="field">
					<label>Movie</label>
					<s:select list="#session['moviesMap']" name="movieId" listKey="key"
						listValue="value" onchange="getAvailableCopies(this.value)" />
				</div>
				<div class="field"
					style="display: flex; flex-direction: column; justify-content: flex-end">
					<div id="availableCopies"
						style="font-size: 0.85rem; color: var(--muted); padding: 0.6rem 0"></div>
				</div>
				<div class="field">
					<label>Customer</label>
					<s:select list="#session['customerMap']" name="customerId"
						listKey="key" listValue="value" />
				</div>
				<div class="field">
					<label>Return Date</label> <input type="date"
						name="expectedReturnDate" id="expectedReturnDate" />
				</div>
			</div>
			<div class="form-actions">
				<s:reset value="Reset" cssClass="btn btn-ghost" />
				<s:submit value="Create Rental" cssClass="btn btn-primary" />
			</div>
		</div>
	</div>
</s:form>
