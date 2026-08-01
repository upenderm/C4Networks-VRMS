<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>VRMS - ReelTrack</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="Video Rental Management System" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/vrms-styles.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/vrms-theme.js"></script>
<script src="${pageContext.request.contextPath}/js/vrms.js"></script>

<script src="${pageContext.request.contextPath}/js/vrms-topnav.js"></script>
</head>
<body>
	<div class="app">
		<div class="app-banner">
			<div class="banner-logo-area">
				<span class="logo-placeholder">🎬</span>
				<div class="banner-text">
					<span class="banner-title">Reel<span>Track</span></span> <span
						class="banner-subtitle">Video Rental Management System</span>
				</div>
			</div>
			<div class="banner-tagline">Your movies. Your customers. All in
				one place.</div>
		</div>
		<tiles:insertAttribute name="header" />
		<div class="app-body">
			<nav class="sidebar">
				<tiles:insertAttribute name="menu" />
			</nav>
			<main class="main-content">
				<tiles:insertAttribute name="body" />
			</main>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
