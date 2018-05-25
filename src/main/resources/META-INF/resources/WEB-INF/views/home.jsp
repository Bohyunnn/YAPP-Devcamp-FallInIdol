<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>LookingForStar</title>

<!-- Bootstrap core CSS -->
<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../../bootstrap/css/carousel.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif;
}

td {
	padding: 10px;
}

tbody tr:nth-child(2n) {
	background-color: #FFFFFF;
}

tbody tr:nth-child(2n+1) {
	background-color: #2F6FF6;
}

#choiceList ol {
	float: left;
	list-style: none;
	margin: 0px;
	padding: 0px;
	max-width: 900px;
	width: 100%;
}

#choiceList li {
	/*  margin: 0 0 0 0;
	    padding: 0 0 0 0;
	    border : 0;
	    float: left; */
	float: left;
	list-style: none;
	margin: 2px;
}

#choiceList li a {
	display: block;
	width: 150px;
	height: 40px;
	background: #ffffff;
	color: #000000; border1px solid blue;
	font-size: 12px;
	text-align: center;
	padding-top: 10px;
	text-decoration: none;
}

#choiceList li a:hover {
	background: #099;
	text-decoration: none;
}

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
}

/* Caption of Modal Image */
#caption {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
	text-align: center;
	color: #ccc;
	padding: 10px 0;
	height: 150px;
}

/* Add Animation */
.modal-content, #caption {
	-webkit-animation-name: zoom;
	-webkit-animation-duration: 0.6s;
	animation-name: zoom;
	animation-duration: 0.6s;
}

@
-webkit-keyframes zoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes zoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* The Close Button */
.close {
	position: absolute;
	top: 100px;
	right: 110px;
	color: #f1f1f1;
	z-index: 100;
	font-size: 30px;
	font-weight: bold;
	transition: 0.3s;
}

.close:hover, .close:focus {
	color: #bbb;
	text-decoration: none;
	cursor: pointer;
}

.closeModal {
	position: absolute;
	top: 100px;
	right: 110px;
	color: #f1f1f1;
	z-index: 100;
	font-size: 30px;
	font-weight: bold;
	transition: 0.3s;
}

.closeModal:hover, .closeModal:focus {
	color: #bbb;
	text-decoration: none;
	cursor: pointer;
}
/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px) {
	.modal-content {
		width: 100%;
	}
	.videowrapper {
		position: absolute;
		padding-bottom: 56.25%; /* 16:9 비율인 경우 */
		/* padding-bottom값은 4:3 비율인 경우 75%로 설정합니다 */
		padding-top: 25px;
		height: 0;
	}
	.videowrapper iframe {
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
	}
}
</style>
</head>
<body>
	

	<jsp:include page="./head.jsp" flush="false" />
		<!-- FOOTER -->
		
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous" type="text/javascript"></script>
		<script type="text/javascript">
			window.jQuery
					|| document
							.write('<script src="js/vendor/jquery-slim.min.js"><\/script>')
			function openNav() {
				var x = document.getElementById("navDemo");
				if (x.className.indexOf("w3-show") == -1) {
					x.className += " w3-show";
				} else {
					x.className = x.className.replace(" w3-show", "");
				}

			}
		</script>
		<script type="text/javascript">
			function clickImage(image) {
				/* var width, height;
				
				if(image.naturalWidth){
				 width = image.naturalWidth;
				 height = image.naturalHeight;
				} else {
				 var tImg = new Image();
				 tImg.src = image.src;
				 width = tImg.width;
				 height = tImg.height;
				}
				console.log("Image width:" + width + ", height:" + height); */
				var modal = document.getElementById('myModal');

				// Get the image and insert it inside the modal - use its "alt" text as a caption
				var modalImg = document.getElementById("img01");
				var captionText = "";

				modal.style.display = "block";
				modalImg.src = image.src;
				captionText.innerHTML = image.alt;

				// Get the <span> element that closes the modal
				var span = document.getElementsByClassName("close")[0];

				// When the user clicks on <span> (x), close the modal
				span.onclick = function() {
					modal.style.display = "none";
				}

			}
		</script>
		<script type="text/javascript">
		$('#Schedule').on('click', function() {
				$('[data-toggle="popover"]').popover({
					content : $('#myPopoverContent').html(),
					html : true
				});
			});
		</script>

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
			type="text/javascript"></script>

		<script src="../../bootstrap/js/bootstrap.min.js"
			type="text/javascript"></script>
		<!-- Just to make our placeholder images work. Don't actually copy the next line! -->

	</div>
</body>
</html>