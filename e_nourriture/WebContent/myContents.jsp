<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="ent.model.dto.Contents" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
		ArrayList<Contents> list = (ArrayList<Contents>)request.getAttribute("list");
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			String imgURL = list.get(i).getImgURL();
			if(imgURL!=null){			
%>
			<img src = '<%=list.get(i).getImgURL() %>'/>
<%
			}
%>
			���� : <%=list.get(i).getContents() %><br>
			���ƿ� : <%=list.get(i).getContentsLikeCount() %><br>
			�ð� : <%=list.get(i).getWriteDate() %><br>
			��ǰ���� : <br>
<%
			if(list.get(i).getProductInfo()!=null){
%>
				&nbsp;&nbsp;&nbsp;��ǰ�� : <%=list.get(i).getProductInfo().getProductName() %>
				&nbsp;&nbsp;&nbsp;���� : <%=list.get(i).getProductInfo().getProductPrice() %>
				&nbsp;&nbsp;&nbsp;�Ǹ�ó : <%=list.get(i).getProductInfo().getProductStore() %>
				&nbsp;&nbsp;&nbsp;�Ǹ�ó�ּ� : <%=list.get(i).getProductInfo().getProductStoreAddr() %>
				&nbsp;&nbsp;&nbsp;���� : <%=list.get(i).getProductInfo().getEvaluation() %> 
<%
			}
			
%>
		
<%
		}
%>


</body>
</html>