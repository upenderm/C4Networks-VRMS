<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<header class="app-header">
	<script type="text/javascript">
		function submitThisForm(action) {
			document.headerForm.action = action;
			document.headerForm.submit();
		}
	</script>
	<s:form id="headerForm" name="headerForm" action="" theme="simple"
		cssStyle="display:contents">
		<div class="header-brand">
			<span class="header-menu-icon">☰</span>
		</div>
		<div class="header-search">
			<span class="icon">🔍</span> <input type="text"
				placeholder="Search movies, customers…" />
		</div>
		<div class="header-actions">
			<div class="theme-switcher">
				<button class="theme-btn" id="theme-light"
					onclick="setTheme('light')" title="Light">☀️</button>
				<button class="theme-btn" id="theme-dark" onclick="setTheme('dark')"
					title="Dark">🌙</button>
				<button class="theme-btn" id="theme-filmy"
					onclick="setTheme('filmy')" title="Filmy">🎞</button>
			</div>
			<div class="header-btn" title="Notifications">
				🔔<span class="badge">0</span>
			</div>
			<a href="userSettingsAction.action" class="avatar">UM</a>
		</div>
	</s:form>
</header>
