<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ page import="ent.controller.manager.managerController" %>
<%@ page import="ent.controller.user.userController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ent.model.dto.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sky Forms</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

<link rel="stylesheet" href="css/reg_css/demo.css">
<link rel="stylesheet" href="css/reg_css/sky-forms.css">
<!--[if lt IE 9]>
			<link rel="stylesheet" href="css/sky-forms-ie8.css">
		<![endif]-->

<!--[if lt IE 10]>
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
			<script src="js/jquery.placeholder.min.js"></script>
		<![endif]-->
<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/sky-forms-ie8.js"></script>
		<![endif]-->

<style type="text/css">
#pass-info {
	width: 100%;
	height: 25px;
	margin-bottom: 10px;
	border: 1px solid #DDD;
	border-radius: 4px;
	color: #829CBD;
	text-align: center;
	font: 12px/25px Arial, Helvetica, sans-serif;
}

#pass-info.weakpass {
	border: 1px solid #FF9191;
	background: #FFC7C7;
	color: #94546E;
	text-shadow: 1px 1px 1px #FFF;
}

#pass-info.stillweakpass {
	border: 1px solid #FBB;
	background: #FDD;
	color: #945870;
	text-shadow: 1px 1px 1px #FFF;
}

#pass-info.goodpass {
	border: 1px solid #C4EEC8;
	background: #E4FFE4;
	color: #51926E;
	text-shadow: 1px 1px 1px #FFF;
}

#pass-info.strongpass {
	border: 1px solid #6ED66E;
	background: #79F079;
	color: #348F34;
	text-shadow: 1px 1px 1px #FFF;
}

#pass-info.vrystrongpass {
	border: 1px solid #379137;
	background: #48B448;
	color: #CDFFCD;
	text-shadow: 1px 1px 1px #296429;
}
</style>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var password1 = $('#password1'); //id of first password field
		var password2 = $('#password2'); //id of second password field
		var passwordsInfo = $('#pass-info'); //id of indicator element

		passwordStrengthCheck(password1, password2, passwordsInfo); //call password check function

	});

	function passwordStrengthCheck(password1, password2, passwordsInfo) {
		//Must contain 5 characters or more
		var WeakPass = /(?=.{5,}).*/;
		//Must contain lower case letters and at least one digit.
		var MediumPass = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{5,}$/;
		//Must contain at least one upper case letter, one lower case letter and one digit.
		var StrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])\S{5,}$/;
		//Must contain at least one upper case letter, one lower case letter and one digit.
		var VryStrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{5,}$/;

		$(password1)
				.on(
						'keyup',
						function(e) {
							if (VryStrongPass.test(password1.val())) {
								passwordsInfo
										.removeClass()
										.addClass('vrystrongpass')
										.html(
												"Very Strong! (Awesome, please don't forget your pass now!)");
							} else if (StrongPass.test(password1.val())) {
								passwordsInfo
										.removeClass()
										.addClass('strongpass')
										.html(
												"Strong! (Enter special chars to make even stronger");
							} else if (MediumPass.test(password1.val())) {
								passwordsInfo
										.removeClass()
										.addClass('goodpass')
										.html(
												"Good! (Enter uppercase letter to make strong)");
							} else if (WeakPass.test(password1.val())) {
								passwordsInfo
										.removeClass()
										.addClass('stillweakpass')
										.html(
												"Still Weak! (Enter digits to make good password)");
							} else {
								passwordsInfo
										.removeClass()
										.addClass('weakpass')
										.html(
												"Very Weak! (Must be 5 or more chars)");
							}
						});

		$(password2).on(
				'keyup',
				function(e) {

					if (password1.val() !== password2.val()) {
						passwordsInfo.removeClass().addClass('weakpass').html(
								"Passwords do not match!");
					} else {
						passwordsInfo.removeClass().addClass('goodpass').html(
								"Passwords match!");
					}

				});
	}
</script>


</head>
<%=session.getAttribute("ID") %>
<%	
		
		userController us = new userController();
		ArrayList<User> list2=us.userContents(request, response);
		ArrayList<User> list = us.getList();
		for(int i=0;i<list2.size();i++){
%>

				<body class="bg-cyan">
	<div class="body body-s">
		<form method="post" class="sky-form">

			<header>Registration form</header>

			<fieldset>
				<section> <label class="input"> <i
					class="icon-append icon-user"></i> UserName :<%=list2.get(i).getUserId() %>
					<b class="tooltip tooltip-bottom-right"></b> 
				</label>
				</section>

				<section> <label class="input"> <i
					class="icon-append icon-envelope-alt"></i>ID :<%=list2.get(i).getUserPw() %>
					<b class="tooltip tooltip-bottom-right"></b>
				</label> </section>


				<section> <label class="input"> <i
					class="icon-append icon-lock"></i> PassWord :<%=list2.get(i).getNickname() %>
					<b class="tooltip tooltip-bottom-right"></b>
				</label> </section>

				<section> <label class="input"> <i
					class="icon-append icon-envelope-alt"></i>Email Address :<%=list2.get(i).getEmail() %><b
					class="tooltip tooltip-bottom-right"></b>
				</label> </section>
				<section> <label class="input"> <i
					class="icon-append icon-envelope-alt"></i>PhoneNumber : <%=list2.get(i).getPhoneNumber() %><b
					class="tooltip tooltip-bottom-right"></b>
				</label> </section>
				
			</fieldset>
		</form>
	</div>
</body>
<%
		}
%>
</html>