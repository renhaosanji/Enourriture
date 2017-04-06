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

<body class="bg-cyan">
	<div class="body body-s">
		<form method="post" class="sky-form" action="" >

			<header>User Information</header>

			<fieldset>
				<section> <label class="input">  userId 
					<b class="tooltip tooltip-bottom-right"></b> 
				</label>
				</section>

				<section> <label class="input"> orderNumber 
					<b class="tooltip tooltip-bottom-right"></b>
				</label> </section>
				<section> <label class="input"> orderCount
					<b class="tooltip tooltip-bottom-right"></b>
				</label> </section>
				<section> <label class="input"> orderTime 
					<b class="tooltip tooltip-bottom-right"></b>
				</label> </section>
				
				<button type="button" class="button" onclick="location.href='idDelete.jsp'">회원탈퇴</button>
				<button type="button" class="button" onclick="location.href='infoChangeTest.jsp'">정보변경</button>
				<br>
				</fieldset>
		</form>
	</div>
</body>
</html>