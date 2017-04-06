<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="ent.controller.manager.managerController" %>
<%@ page import="ent.controller.user.userController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ent.model.dto.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Cyrus Studio</title>

<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700'
	rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />

<!-- animate.css -->
<link rel="stylesheet" href="assets/animate/animate.css" />
<link rel="stylesheet" href="assets/animate/set.css" />

<!-- gallery -->
<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">

<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="assets/style.css">

</head>

<body>
	<div class="topbar animated fadeInLeftBig"></div>
	<!-- Header Starts -->
	<div class="navbar-wrapper">
		<div class="container">

			<div class="navbar navbar-default navbar-fixed-top" role="navigation"
				id="top-nav">
				<div class="container">
					<div class="navbar-header">
						<!-- Logo Starts -->
						<a class="navbar-brand" href="#home"><img
							src="images/logo.png" alt="logo"></a>
						<!-- #Logo Ends -->
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<!-- Nav Starts -->
					<div class="navbar-collapse  collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#works">Time Line</a></li>
							<li><a href="#about">My Page</a></li>
							<li><a href="inputContentView.jsp">Write</a></li>
							<li><a href="userInfoTest.jsp">정보조회</a></li>
							<li><a href="userInfoTest.jsp">예약확인/취소</a></li>
							<li><form method="post" action="ucontroller?action=logout">
							<li><a href="loginView.jsp">logout</a></li>
<!-- 									<input type="submit" value="logout"
										onclick="location.href='logoutTest.jsp'"> -->
								</form></li>
							<!-- <li><form action="post"
									action="ucontroller?action=following">
									<input type="text" name="followingUserId"> <input
										type="submit" value="following">
								</form></li> -->

						</ul>

					</div>
					<!-- #Nav Ends -->
				</div>
			</div>

		</div>
	</div>
	

</body>
</html>