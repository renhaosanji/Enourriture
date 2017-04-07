<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="css/write_css/style.css">
<link rel="stylesheet" href="css/reg_css/demo.css">
<link rel="stylesheet" href="css/reg_css/sky-forms.css">
<link rel="stylesheet" href="css/write_css/rating.css">
<link rel="stylesheet" href="css/write_css/file_upload.css">

<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<style>
@import
	url(http://fonts.googleapis.com/css?family=Roboto:500,100,300,700,400);

* {
	margin: 0;
	padding: 0;
	font-family: roboto;
}

body {
	background: #000;
}

.cont {
	width: 93%;
	max-width: 350px;
	text-align: center;
	margin: 4% auto;
	padding: 30px 0;
	background: #111;
	color: #EEE;
	border-radius: 5px;
	border: thin solid #444;
	overflow: hidden;
}

hr {
	margin: 20px;
	border: none;
	border-bottom: thin solid rgba(255, 255, 255, .1);
}

div.title {
	font-size: 2em;
}

h1 span {
	font-weight: 300;
	color: #Fd4;
}

div.stars {
	width: 270px;
	display: inline-block;
}

input.star {
	display: none;
}

label.star {
	float: right;
	padding: 10px;
	font-size: 36px;
	color: #444;
	transition: all .2s;
}

input.star:checked ~ label.star:before {
	content: '\f005';
	color: #FD4;
	transition: all .25s;
}

input.star-5:checked ~ label.star:before {
	color: #FE7;
	text-shadow: 0 0 20px #952;
}

input.star-1:checked ~ label.star:before {
	color: #F62;
}

label.star:hover {
	transform: rotate(-15deg) scale(1.3);
}

label.star:before {
	content: '\f006';
	font-family: FontAwesome;
}
</style>
<link href="http://www.cssscript.com/wp-includes/css/sticky.css"
	rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>


<<<<<<< HEAD
<body class="bg-cyan1">
	<div class="body body-s">
<form  class="sky-form" method="post" action="mcontroller?action=inputContent" enctype="multipart/form-data">
			<header>Today's Special</header>

			<fieldset>
				<section>
					<div>
						<input type="file" name="imgfile" id="input_file">
					</div>
				</section>
			</fieldset>

			<fieldset>
				<section>
					<label class="input"> <i class="icon-append icon-user"></i>
						<input type="text" name="productStore" placeholder="업소명"> <b
						class="tooltip tooltip-bottom-right">Only latin characters and
							numbers</b>
					</label>
				</section>

				<section>
					<label class="input"> <i
						class="icon-append icon-envelope-alt"></i><input type="text" name="productStoreAddr"
						placeholder="소재지"><b class="tooltip tooltip-bottom-right">Needed
							to verify your account</b>
					</label>
				</section>


				<section>
					<label class="input"> <i class="icon-append icon-lock"></i>
						<input type="text" name="product" placeholder="음식명"> <b
						class="tooltip tooltip-bottom-right">Only latin characters and
							numbers</b>
					</label>
				</section>

				<section>
					<label class="input"> <i class="icon-append icon-lock"></i>
						<input type="text" name="price" placeholder="가격"> <b
						class="tooltip tooltip-bottom-right">Only latin characters and
							numbers</b>
					</label>
				</section>

				<section>
					<label class="checkbox"><input type="checkbox"
						name="checkbox"><i></i>I agree to the Terms of Service</label> <label
						class="checkbox"><input type="checkbox" name="checkbox"><i></i>예약가능여부</label>
				</section>


			</fieldset>

			<fieldset>
				<p>음식을 평가해주세요!</p>
				<div class="stars">
					 <input class="star star-5" id="star-5-2" type="radio" name="like1" />
					 <label class="star star-5" for="star-5-2"></label>
					 <input class="star star-4" id="star-4-2" type="radio" name="like2" /> 
					 <label	class="star star-4" for="star-4-2"></label> 
					 <input class="star star-3" id="star-3-2" type="radio" name="like3" /> 
					 <label class="star star-3" for="star-3-2"></label> 
					 <input class="star star-2" id="star-2-2" type="radio" name="like4" /> 
					 <label class="star star-2" for="star-2-2"></label> 
					 <input class="star star-1" id="star-1-2" type="radio" name="like5" /> 
					 <label class="star star-1" for="star-1-2"></label>

				</div>
			</fieldset>


			<fieldset>
				<label class="input"> <i
					class="icon-append icon-envelope-alt"></i> <textarea name="contents"
						class="field-style" placeholder="Message"></textarea> <b
					class="tooltip tooltip-bottom-right">Needed to verify your
						account</b>
				</label>




			</fieldset>


			<footer>
			
				<button type="submit" class="button" onclick="location.href='index.jsp'">Upload!</button>
				<button type="submit" class="button" onclick="history.back()">Cancel</button>
			</footer>
		</form>

	</div>


	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-46156385-1', 'cssscript.com');
		ga('send', 'pageview');
	</script>

	<script>
		$(document)
				.ready(
						function() {
							var fileTarget = $('.filebox .upload-hidden');

							fileTarget.on('change', function() {
								if (window.FileReader) {
									// 파일명 추출
									var filename = $(this)[0].files[0].name;
								}

								else {
									// Old IE 파일명 추출
									var filename = $(this).val().split('/')
											.pop().split('\\').pop();
								}
								;

								$(this).siblings('.upload-name').val(filename);
							});

							//preview image 
							var imgTarget = $('.preview-image .upload-hidden');

							imgTarget
									.on(
											'change',
											function() {
												var parent = $(this).parent();
												parent.children(
														'.upload-display')
														.remove();

												if (window.FileReader) {
													//image 파일만
													if (!$(this)[0].files[0].type
															.match(/image\//))
														return;

													var reader = new FileReader();
													reader.onload = function(e) {
														var src = e.target.result;
														parent
																.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
													}
													reader
															.readAsDataURL($(this)[0].files[0]);
												}

												else {
													$(this)[0].select();
													$(this)[0].blur();
													var imgSrc = document.selection
															.createRange().text;
													parent
															.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

													var img = $(this).siblings(
															'.upload-display')
															.find('img');
													img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""
															+ imgSrc + "\")";
												}
											});
						});
	</script>



</form>

</body>


</html>