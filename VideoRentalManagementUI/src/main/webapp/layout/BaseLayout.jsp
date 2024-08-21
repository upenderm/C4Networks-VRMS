<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<jsp:directive.page import="java.util.ArrayList" />
<%
	final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
	logger.info("In " + this.getClass().getSimpleName().replace("_", "."));
%>
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>VRMS</title>

<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<meta name="description" content="Video Rental Management System" />
<meta name="keywords" content="C4VRMS, VRMS" />
<meta name="robots" content="index, follow" />

<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />
<link type="text/css" href="css/vrms-content-styles.css" rel="stylesheet" />
<link href="css/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
<script src="js/vrms.js"></script>
<script src="js/vrms-topnav.js"></script>

<!--[if lt IE 7]>
	<style media="screen" type="text/css">
	#container {
		height:100%;
	}
	</style>
	<![endif]-->
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="topnav" id="menuItemList">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="body">
			<!-- Body start -->
			<div class="col-container">
				<tiles:insertAttribute name="leftBanner" />
				<tiles:insertAttribute name="body" />
				<tiles:insertAttribute name="rightBanner" />
			</div>
			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</div>
</body>
</html>