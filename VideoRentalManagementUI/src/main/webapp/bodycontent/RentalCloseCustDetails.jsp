<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>

<s:form theme="simple" id="rentalCloseCustDetailsForm" name="rentalCloseCustDetailsForm">
	<table border="0" class="bigTable">
		<tr class="headerRow">
			<th>Rental Id</th>
			<th>Movie Name</th>
			<th>Rented Date</th>
			<th>Expected Return Date</th>
			<th>Status</th>
			<th>Close</th>
		</tr>
		<s:if test="#session.specificCustomerRentals.size()>0">
			<s:iterator value="#session.specificCustomerRentals">
				<tr>
					<td><s:property value="rentalId" /></td>
					<td><s:property value="movieDetails.movieName" /></td>
					<td><s:date name="rentalDate" format="dd/MM/yyyy" /></td>
					<td><s:date name="expectedReturnDate" format="dd/MM/yyyy" /></td>
					<td><s:property value="status" /></td>
					<td><s:if test="status=='OPEN'">
							<a href="javascript:void(0)" onclick="closeRental('${rentalId}')">Close</a>
						</s:if> 
						<s:else>
							<a href="javascript:void(0)">Closed</a>
						</s:else></td>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td style="color: red; text-align: center;" colspan="6">No rentals found for this customer</td>
			</tr>
		</s:else>
	</table>
	<s:hidden name="rentalEditId" id="rentalEditId"></s:hidden>
</s:form>