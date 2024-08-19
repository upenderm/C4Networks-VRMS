<%@ taglib uri="/struts-tags" prefix="s" %>
<!-- Header start -->
<script type="text/javascript">
	function submitThisForm(action) {
		document.headerForm.action = action;
		document.headerForm.submit();
	}
</script>
<s:form id="headerForm" name="headerForm" action="" theme="simple">
<p>&nbsp;</p>
<h1>VIDEO RENTAL MANAMEMENT SYSTEM</h1>
<p style="text-align: right">
	<s:submit cssClass="button buttonSettings" value="Settings" type="button" onclick="submitThisForm('userSettingsAction.action')"></s:submit>
	<s:submit cssClass="button buttonLogout" value="LogOut" type="button" onclick="submitThisForm('logoutAction.action')"></s:submit>
	<%-- <button class="button buttonSettings" style="vertical-align: middle"><span>Settings</span></button>
	<button class="button buttonLogout" style="vertical-align: middle" type="submit"><span>LogOut</span></button> --%>
</p>
</s:form>
<!-- Header end -->
