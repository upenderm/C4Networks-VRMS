<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<s:form theme="simple" id="rentalCloseCustDetailsForm"
	name="rentalCloseCustDetailsForm">
	<div class="tbl-wrap">
		<table>
			<thead>
				<tr>
					<th>Rental Id</th>
					<th>Movie Name</th>
					<th>Rented Date</th>
					<th>Expected Return</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="#session.specificCustomerRentals.size()>0">
					<s:iterator value="#session.specificCustomerRentals">
						<tr>
							<td class="mono"><s:property value="rentalId" /></td>
							<td><s:property value="movieDetails.movieName" /></td>
							<td><s:date name="rentalDate" format="dd/MM/yyyy" /></td>
							<td><s:date name="expectedReturnDate" format="dd/MM/yyyy" /></td>
							<td><s:if test="status=='OPEN'">
									<span class="pill pill-green">OPEN</span>
								</s:if> <s:else>
									<span class="pill pill-grey">CLOSED</span>
								</s:else></td>
							<td><s:if test="status=='OPEN'">
									<a href="javascript:void(0)"
										onclick="closeRental('${rentalId}')"
										class="btn btn-danger btn-sm">Close</a>
								</s:if> <s:else>
									<span class="pill pill-grey">Done</span>
								</s:else></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr>
						<td colspan="6" class="empty-state"
							style="padding: 2rem; text-align: center; color: var(--muted)">No
							active rentals found for this customer.</td>
					</tr>
				</s:else>
			</tbody>
		</table>
	</div>
</s:form>
