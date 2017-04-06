<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="ent.controller.manager.managerController"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="ent.model.dto.Contents"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="css/timeline_css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/timeline_css/templatemo-style.css">
<!--
Puzzle Template
http://www.templatemo.com/tm-477-puzzle
-->
<title>Puzzle by templatemo</title>

<title>Insert title here</title>
</head>
<body>
	<div class="fixed-header">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Puzzle</a>
			</div>
			<nav class="main-menu">
			<ul>
				<li><a href="home">Home</a></li>
				<li><a class="external" href="login.html">login</a></li>
				<li><a class="external" href="main.html">main</a></li>
				<li><a class="external"
					href="https://www.facebook.com/templatemo" target="_blank">External</a></li>
				<li><a class="external" href="write.html">write</a></li>
			</ul>
			</nav>
		</div>
	</div>

	<div class="container">
		<jsp:include page="timelineGridView.jsp" />
		<%-- <section class="col-md-12 content" id="home">
		<div class="col-lg-6 col-md-6 content-item">
			<img src="images/food/1.jpg" alt="Image" class="tm-image">
			<!-- works -->
			<jsp:include page="timelineGridView.jsp" />
			<!-- works -->

		</div>
		<div class="col-lg-6 col-md-6 content-item content-item-1 background">
			<p>내용보여줄곳</p>
		</div>
		</section>

		<section class="col-md-12 content padding" id="services">
		<div class="col-lg-6 col-md-6 col-md-push-6 content-item">
			<img src="images/food/2.jpg" alt="Image" class="tm-image">
		</div>
		<div
			class="col-lg-6 col-md-6 col-md-pull-6 content-item background flexbox">
			<p>내용 보여줄곳</p>
		</div>

		</section>
 --%>



	</div>

	<div class="text-center footer">
		<div class="container">
			Copyright @ 2084 Company Name | Design: <a
				href="http://www.templatemo.com/tm-477-puzzle" target="_parent"
				title="Puzzle Template">Puzzle</a>
		</div>
	</div>

	<script src="js/timeline_js/jquery.min.js"></script>
	<script src="js/timeline_js/bootstrap.min.js"></script>
	<script src="js/timeline_js/jquery.singlePageNav.min.js"></script>

	<script>

// Check scroll position and add/remove background to navbar
function checkScrollPosition() {
    if($(window).scrollTop() > 50) {
      $(".fixed-header").addClass("scroll");
  } else {        
      $(".fixed-header").removeClass("scroll");
  }
}

$(document).ready(function () {   
    // Single page nav
    $('.fixed-header').singlePageNav({
        offset: 59,
        filter: ':not(.external)',
        updateHash: true        
    });

    checkScrollPosition();

    // nav bar
    $('.navbar-toggle').click(function(){
        $('.main-menu').toggleClass('show');
    });

    $('.main-menu a').click(function(){
        $('.main-menu').removeClass('show');
    }); 
});

$(window).on("scroll", function() {
    checkScrollPosition();    
});
</script>
</body>
</html>