<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewBornTracker</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css"></link>
</head>
<body>
	<h2>Sign in or Sign up!</h2> 
	<nav>
		<a href="/NewBornTracker">Home</a>
	</nav>
	<div class="container-fluid h-100">
		<div class="row h-100">
			<div class="col-6 left">
				<h3>Sign in</h3>
				<p>${loginerror}</p>
				<form id="login" method="post" action="user">
					<label for="luname">Username</label> <input id="luname" type="text"
						name="luname" /> <br> <label for="lpword">Password</label> <input
						id="lpword" type="password" name="lpword" /> <br>
					<button type="submit">sign in</button>
				</form>
			</div>

			<div class="col-6 right">
				<h3>Sign Up</h3>
				<form id="signup" method="post" action="user">
					<label for="suname">Username</label> <input id="suname" type="text"
						name="suname" /> <br> <label for="spword">Password</label> <input
						id="spword" type="password" name="spword" /> <br>
					<button type="submit">sign up</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>