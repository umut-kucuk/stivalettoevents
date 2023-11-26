
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="it.generationitaly.events.entity.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="navbar.css">
	<script src="https://kit.fontawesome.com/43c824bcfa.js" crossorigin="anonymous"></script>

<title>Sign Up</title>
<style>
header {
	background-color: #306437;
}
</style>
</head>
<body>
	<header class="p-3 mb-3 border-bottom">
		<div class="container">
			<div
				class="d-flex  align-items-center justify-content-space-evenly justify-content-lg-start">
				
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
					<svg class="bi me-2" width="40" height="32" role="img"
						aria-label="Bootstrap">
					<use xlink:href="#bootstrap"></use></svg>
				</a>

				<div
					class="nav">
				
					<div class="logo-container"><img class="logo"  src="stivaletto-logo.png"  alt="logo"></div>
			
					<li><a href="servletCards" class="nav-link px-2 link-light"><i class="fa-solid fa-house" style="color: #ffffff;"></i> Home</a></li>
					<li><a href="servletSupportoCarrello" class="nav-link px-2 link-light"><i class="fa-solid fa-cart-shopping" style="color: #ffffff;"></i> Carrello</a></li>
				</ul>
				<div class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<a href="form-search.jsp"><button class="search-btn">Ricerca...</button></a>
				</div>

				<div class="text-end">
					<%
					User user = (User) session.getAttribute("user");
					if (user == null) {
					%>
					<a class="links-nav" href="login.jsp">LOG IN</a> <a class="links-nav" href="signup.jsp">SIGN UP</a>
					<%
					} else {
					%>
					
					<div class="dropdown">
						<a href="#"
							class="d-block link-dark text-decoration-none dropdown-toggle"
							id="dropdownUser1"
							aria-expanded="false">
							<img src="https://github.com/mdo.png" alt="pfp" width="32" height="32" class="rounded-circle">
						</a>
						<ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
							<li><a class="dropdown-item" href="#">Profile</a></li>
							<li><a class="dropdown-item" href="#">Settings</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="logout">LOG OUT</a></li>
						</div>
						<a class="links-nav" href="logout" class="nav-link px-2 link-light">LOG OUT</a>
					</div>
					<!--
					<a href="logout" class="nav-link px-2 link-light">LOG OUT</a>
					-->
					<%
					}
					%>
				</div>
			</div>
		</div>
	</header>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>