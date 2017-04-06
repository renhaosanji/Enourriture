<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="ent.controller.manager.managerController"%>
<%@ page import="ent.controller.user.userController"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="ent.model.dto.Contents"%>
<div id="works" class=" clearfix grid">

	<!-- 디비에서 이미지 정보 빼와서 하나씩 박기  -->

	<%
	
	managerController uc = new managerController();
	ArrayList<Contents> list1 = uc.getFollowContents(request);
	System.out.println("list1 size : "  +list1.size());
	
		for(int i=0;i<list1.size();i++){
%>
	<section class="col-md-12 content" id="home">
		<div class="col-lg-6 col-md-6 content-item">

			<img src="<%=list1.get(i).getImgURL() %>" alt="img01" />


		</div>
		<div class="col-lg-6 col-md-6 content-item content-item-1 background">
			<p>내용 :	<%= list1.get(i).getContents() %> </p>
			<p>좋아요 : <%= list1.get(i).getContentsLikeCount() %> </p>
			<p>작성일 : <%= list1.get(i).getWriteDate() %> </p>
			<p>음식명 : <%= list1.get(i).getProductInfo().getProductName() %> </p>
			<p>가격 : <%= list1.get(i).getProductInfo().getProductPrice() %> </p>
			<p>업소명 : <%= list1.get(i).getProductInfo().getProductStore() %> </p>
			<p>위치 : <%= list1.get(i).getProductInfo().getProductStoreAddr() %> </p> 
			<p>평점 : <%= list1.get(i).getProductInfo().getEvaluation() %> </p>


		</div>
	</section>

	<%
		}
%>


</div>