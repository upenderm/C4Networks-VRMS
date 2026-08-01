<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<link type="text/css" href="css/vrms-styles.css" rel="stylesheet" />
<script src="js/vrms-theme.js"></script>
<script src="js/vrms-topnav.js"></script>
<script src="js/vrms.js"></script>
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
		<jsp:include page="layout/Header.jsp" />
		<div class="app-body">
			<nav class="sidebar">
				<jsp:include page="layout/Menu.jsp" />
			</nav>
			<main class="main-content">
				<div class="page-heading">
					<h1>Dashboard</h1>
					<p>Welcome back – here's what's happening today.</p>
				</div>
				<div class="stat-row">
					<div class="stat-card">
						<span class="sc-label">Active Rentals</span><span class="sc-value">—</span><span
							class="sc-sub">Live data</span>
					</div>
					<div class="stat-card">
						<span class="sc-label">Due Today</span><span class="sc-value"
							style="color: var(--warning)">—</span><span class="sc-sub"
							style="color: var(--warning)">Needs attention</span>
					</div>
					<div class="stat-card">
						<span class="sc-label">Overdue</span><span class="sc-value"
							style="color: var(--danger)">—</span><span class="sc-sub"
							style="color: var(--danger)">Contact customers</span>
					</div>
					<div class="stat-card">
						<span class="sc-label">Total Customers</span><span
							class="sc-value">—</span><span class="sc-sub">Registered</span>
					</div>
					<div class="stat-card">
						<span class="sc-label">Movies in Stock</span><span
							class="sc-value">—</span><span class="sc-sub">Across all
							categories</span>
					</div>
					<div class="stat-card">
						<span class="sc-label">Revenue (Month)</span><span
							class="sc-value">—</span><span class="sc-sub">vs last
							month</span>
					</div>
				</div>
				<div class="panel">
					<div class="panel-header">
						<h2>Recent Rentals</h2>
						<a href="rentalAction_defineRental.action"
							class="btn btn-primary btn-sm">+ New Rental</a>
					</div>
					<div class="tbl-wrap">
						<table>
							<thead>
								<tr>
									<th>ID</th>
									<th>Customer</th>
									<th>Movie</th>
									<th>Rented</th>
									<th>Due</th>
									<th>Status</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="7"
										style="text-align: center; padding: 2rem; color: var(--muted)">No
										recent rentals.</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</main>
		</div>
		<jsp:include page="layout/Footer.jsp" />
	</div>
</body>
</html>