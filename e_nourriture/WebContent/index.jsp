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

<form method="post" action="mcontroller?action=myContent" >
	<input type="button" value="button" onclick="location.href='inputContentView.jsp'">
	<input type="submit" value="submit"  >

</form>
</body>
</html>