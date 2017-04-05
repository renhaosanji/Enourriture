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
			내용 : <%=list.get(i).getContents() %><br>
			좋아요 : <%=list.get(i).getContentsLikeCount() %><br>
			시간 : <%=list.get(i).getWriteDate() %><br>
			상품정보 : <br>
<%
			if(list.get(i).getProductInfo()!=null){
%>
				&nbsp;&nbsp;&nbsp;상품명 : <%=list.get(i).getProductInfo().getProductName() %>
				&nbsp;&nbsp;&nbsp;가격 : <%=list.get(i).getProductInfo().getProductPrice() %>
				&nbsp;&nbsp;&nbsp;판매처 : <%=list.get(i).getProductInfo().getProductStore() %>
				&nbsp;&nbsp;&nbsp;판매처주소 : <%=list.get(i).getProductInfo().getProductStoreAddr() %>
				&nbsp;&nbsp;&nbsp;평점 : <%=list.get(i).getProductInfo().getEvaluation() %> 
<%
			}
			
%>
		
<%
		}
%>


</body>
</html>