<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Daily Food - Day 1 Sign In</title>

<!-- Google Fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="css/login_css/animate.css">
<!-- Custom Stylesheet -->
<link rel="stylesheet" href="css/login_css/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<form method="post" action="ucontroller?action=login">
		<div class="container">
			<div class="top">
				<h1 id="title" class="hidden">
					<span id="logo">Daily <span>Food</span></span>
				</h1>
			</div>
			<div class="login-box animated fadeInUp">
				<div class="box-header">
					<h2>Log In</h2>
				</div>
				<label for="username">Username</label> <br /> <input type="text"
					id="ID" name="ID"> <br /> <label for="password">Password</label> <br />
				<input type="password" name="password" id="password"> <br />
				<!--  <button type="submit">Sign In</button>-->

				<!--  <button type="button" onclick="location.href='main.html'">Sign
					In</button>-->

				<input type="submit" value="submit">

				<!--  <button type="submit">Sign Up</button>-->
				<button type="button" onclick="location.href='joinView.jsp'">Sign
					Up</button>

				<br /> <a href="#"><p class="small">Forgot your password?</p></a>
			</div>
		</div>

	</form>

</body>

<script>
	$(document).ready(function() {
		$('#logo').addClass('animated fadeInDown');
		$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>



</html>
