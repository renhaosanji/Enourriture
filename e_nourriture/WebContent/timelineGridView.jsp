<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="ent.controller.manager.managerController"%>
<%@ page import="ent.controller.user.userController"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="ent.model.dto.Contents"%>
<div id="works" class=" clearfix grid">

	<!-- ��񿡼� �̹��� ���� ���ͼ� �ϳ��� �ڱ�  -->

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
			<p>���� :	<%= list1.get(i).getContents() %> </p>
			<p>���ƿ� : <%= list1.get(i).getContentsLikeCount() %> </p>
			<p>�ۼ��� : <%= list1.get(i).getWriteDate() %> </p>
			<p>���ĸ� : <%= list1.get(i).getProductInfo().getProductName() %> </p>
			<p>���� : <%= list1.get(i).getProductInfo().getProductPrice() %> </p>
			<p>���Ҹ� : <%= list1.get(i).getProductInfo().getProductStore() %> </p>
			<p>��ġ : <%= list1.get(i).getProductInfo().getProductStoreAddr() %> </p> 
			<p>���� : <%= list1.get(i).getProductInfo().getEvaluation() %> </p>


		</div>
	</section>

	<%
		}
%>


</div>