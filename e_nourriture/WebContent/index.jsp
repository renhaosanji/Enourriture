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

<form action="ucontroller?action=following" method="get">
    <input type="text" name="followingId">
    <input type="submit" value="following">
</form>
</body>
</html>