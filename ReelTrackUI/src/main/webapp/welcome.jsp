<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="refresh" content="2;url=UserHome" />
<title>ReelTrack</title>
<style>
*, ::after, ::before { box-sizing: border-box; margin: 0; padding: 0; }
body { background: linear-gradient(135deg, #7f1d1d 0%, #b91c1c 50%, #dc2626 100%); height: 100vh; display: flex; align-items: center; justify-content: center; flex-direction: column; gap: 1.5rem; font-family: 'Segoe UI', system-ui, sans-serif; }
.brand { font-size: 2.5rem; font-weight: 800; color: #fff; letter-spacing: -1px; }
.brand span { color: #fca5a5; }
.subtitle { font-size: 0.75rem; color: rgba(255,255,255,.6); text-transform: uppercase; letter-spacing: 2px; }
.spinner { width: 36px; height: 36px; border: 3px solid rgba(255,255,255,.2); border-top-color: #fff; border-radius: 50%; animation: spin 0.8s linear infinite; }
@keyframes spin { to { transform: rotate(360deg); } }
</style>
</head>
<body>
<div class="brand">Reel<span>Track</span></div>
<div class="subtitle">Video Rental Management System</div>
<div class="spinner"></div>
</body>
</html>