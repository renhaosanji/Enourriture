<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	session.getAttribute("ID");
%>

<form method="post">
	<input type="button" value="button" onclick="location.href='inputContentView.jsp'">
</form>
<form method="post" action="ucontroller?action=logout" >
	<input type="submit" value="로그아웃" onclick="location.href='logoutTest.jsp'">
</form>
<form method="post">
	<input type="button" value="정보변경" onclick="location.href='infoChangeTest.jsp'">
</form>
<form method="post">
	<input type="button" value="정보조회" onclick="location.href='userInfoTest.jsp'">
</form>

<form method="post">
	<input type="button" value="회원탈퇴" onclick="location.href='exitTest.jsp'">
=======
<form action="post" action="ucontroller?action=following">
 <input type="text" name="followingUserId">
 <input type="submit" value="following">

</form>
</body>
</html>