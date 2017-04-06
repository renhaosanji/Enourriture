<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="ent.controller.manager.managerController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ent.model.dto.Contents" %>
    <div id="works" class=" clearfix grid">

	<!-- 디비에서 이미지 정보 빼와서 하나씩 박기  -->
	
<%
		managerController mc = new managerController();
		ArrayList<Contents> list = mc.getList();
		for(int i=0;i<list.size();i++){
%>
			<figure class="effect-oscar  wowload fadeIn"> 
				<img src="<%=list.get(i).getImgURL() %>" alt="img01" /> 
				<figcaption>
				<h2><%=list.get(i).getContentId() %></h2>
				<p>
					<%=list.get(i).getContents() %><br> <a href="<%=list.get(i).getImgURL() %>" title="1" data-gallery>View more</a>
				</p>
				</figcaption> 
			</figure>
<%
		}
%>
		<!-- <figure class="effect-oscar  wowload fadeInUp"> 
		<img src="images/food/2.jpg" alt="img01" /> <figcaption>
		<h2>Events</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/food/2.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> 
		<img src="images/food/3.jpg" alt="img01" /> <figcaption>
		<h2>music</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/food/3.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/food/4.png" alt="img01" /> <figcaption>
		<h2>Vintage</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/food/4.png" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/food/5.jpg" alt="img01" /> <figcaption>
		<h2>Typers</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/food/5.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>

		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/portfolio/6.jpg" alt="img01" /> <figcaption>
		<h2>hotel</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/portfolio/6.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/portfolio/7.jpg" alt="img01" /> <figcaption>
		<h2>Chinese</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/portfolio/7.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/portfolio/8.jpg" alt="img01" /> <figcaption>
		<h2>Dicrap</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/portfolio/8.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/portfolio/9.jpg" alt="img01" /> <figcaption>
		<h2>Coffee</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/portfolio/9.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/portfolio/10.jpg" alt="img01" /> <figcaption>
		<h2>cameras</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/portfolio/10.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/portfolio/11.jpg" alt="img01" /> <figcaption>
		<h2>design</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/portfolio/11.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure>
		<figure class="effect-oscar  wowload fadeInUp"> <img
			src="images/portfolio/12.jpg" alt="img01" /> <figcaption>
		<h2>studio</h2>
		<p>
			Lily likes to play with crayons and pencils<br> <a
				href="images/portfolio/12.jpg" title="1" data-gallery>View more</a>
		</p>
		</figcaption> </figure> -->



	</div>