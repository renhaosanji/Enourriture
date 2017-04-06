<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="ent.controller.manager.managerController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ent.model.dto.Contents" %>

 <div id="works" class=" clearfix grid">

	<!-- 디비에서 이미지 정보 빼와서 하나씩 박기  -->
	
<%
		managerController mc = new managerController();
		ArrayList<Contents> list = mc.getMyList(request);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
%>
			<figure class="effect-oscar wowload"> 
				<img src="<%=list.get(i).getImgURL() %>"  /> 
				<figcaption>
				
				<p>
					<%=list.get(i).getContents() %><br>
					<form method="post" action="ucontroller?action=pageView">
						
						<input type="hidden" name="contentsid" value='<%=list.get(i).getContentId() %>' >
						<input type="submit" value="상세보기">
					</form>
					
				</p>
				</figcaption> 
			</figure>
<%
		}
		
%>
		
</div>