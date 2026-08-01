<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<div class="page-heading">
	<h1>My Profile</h1>
	<p>Manage your account details and preferences.</p>
</div>
<s:if test="hasActionMessages()">
	<div class="successMsg">
		<s:actionmessage />
	</div>
</s:if>
<s:if test="hasFieldErrors()|| hasActionErrors()">
	<div class="errorMsg">
		<s:fielderror />
		<s:actionerror />
	</div>
</s:if>
<div
	style="display: grid; grid-template-columns: auto 1fr; gap: 1.5rem; max-width: 820px; align-items: start">
	<div class="profile-card" style="max-width: 260px">
		<div class="profile-avatar-lg">AU</div>
		<div class="profile-name">Admin User</div>
		<div class="profile-role">Store Manager · Full Access</div>
		<hr class="divider" />
		<div style="font-size: 0.8rem; color: var(--muted); line-height: 2">
			<div>✉️ admin@reeltrack.com</div>
			<div>
				🔑 Role: <span style="color: var(--accent)">Admin</span>
			</div>
		</div>
	</div>
	<div class="panel">
		<div class="panel-header">
			<h2>Edit Profile</h2>
		</div>
		<div style="padding: 1.5rem">
			<div class="form-grid">
				<div class="field">
					<label>First Name</label><input type="text"
						placeholder="First name" />
				</div>
				<div class="field">
					<label>Last Name</label><input type="text" placeholder="Last name" />
				</div>
				<div class="field">
					<label>Email</label><input type="email" placeholder="Email address" />
				</div>
				<div class="field">
					<label>Phone</label><input type="tel" placeholder="Phone number" />
				</div>
			</div>
			<hr class="divider" />
			<div class="form-grid">
				<div class="field">
					<label>New Password</label><input type="password"
						placeholder="••••••••" />
				</div>
				<div class="field">
					<label>Confirm Password</label><input type="password"
						placeholder="••••••••" />
				</div>
			</div>
			<div class="form-actions">
				<button type="button" class="btn btn-ghost">Cancel</button>
				<button type="button" class="btn btn-primary">Save Changes</button>
			</div>
		</div>
	</div>
</div>
