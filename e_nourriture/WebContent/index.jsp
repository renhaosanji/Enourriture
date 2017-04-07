<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="ent.controller.manager.managerController"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="ent.model.dto.Contents"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Cyrus Studio</title>



<jsp:include page="userTop.jsp"/>


	<!-- works -->
	<jsp:include page="gridView.jsp" />
	<!-- works -->









	<!-- Footer Starts -->
	<div class="footer text-center spacer">
		<p class="wowload flipInX">
			<a href="#"><i class="fa fa-facebook fa-2x"></i></a> <a href="#"><i
				class="fa fa-instagram fa-2x"></i></a> <a href="#"><i
				class="fa fa-twitter fa-2x"></i></a> <a href="#"><i
				class="fa fa-flickr fa-2x"></i></a>
		</p>
		Copyright 2017 All rights reserved.
	</div>
	<!-- # Footer Ends -->
	<a href="#works" class="gototop "><i class="fa fa-angle-up  fa-3x"></i></a>





	<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
	<div id="blueimp-gallery"
		class="blueimp-gallery blueimp-gallery-controls">
		<!-- The container for the modal slides -->
		<div class="slides"></div>
		<!-- Controls for the borderless lightbox -->
		<h3 class="title">Title</h3>
		<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a>
		<!-- The modal dialog, which will be used to wrap the lightbox content -->
	</div>







	<!-- jquery -->
	<script src="assets/jquery.js"></script>

	<!-- wow script -->
	<script src="assets/wow/wow.min.js"></script>


	<!-- boostrap -->
	<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript"></script>

	<!-- jquery mobile -->
	<script src="assets/mobile/touchSwipe.min.js"></script>
	<script src="assets/respond/respond.js"></script>

	<!-- gallery -->
	<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>

	<!-- custom script -->
	<script src="assets/script.js"></script>


	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>








