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
<style>
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif;
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
/* #selectable .ui-selecting { background: #FECA40; }
  	#selectable .ui-selected { background: #F39814; color: white; }
	 */
</style>
</head>
<body>

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-row w3-large w3-light-grey">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a> <a href="/"
				class="w3-bar-item w3-button w3-padding-large">Logo</a> <a
				href="#youtube"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="youtuberesult">YOUTUBE</a> <a href="#photo"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="photo">PHOTO</a> <a
				href="${pageContext.request.contextPath}/twit"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="twitter">TWITTER</a> <a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white"
				title="chatting"> <i class="fa fa-comments"></i>
			</a> <a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white"
				title="setting"> <i class="fa fa-user"></i>
			</a>
		</div>

		<!-- Navbar on small screens -->
		<div id="navDemo"
			class="w3-bar-block w3-hide w3-hide-large w3-hide-medium w3-right">
			<a href="#team" class="w3-bar-item w3-button">Team</a> <a
				href="#work" class="w3-bar-item w3-button">Work</a> <a
				href="#pricing" class="w3-bar-item w3-button">Price</a> <a
				href="#contact" class="w3-bar-item w3-button">Contact</a> <a
				href="#" class="w3-bar-item w3-button">Search</a>
		</div>
	</div>
	<div>
		<main role="main">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<c:forEach items="${mainPhoto}" var="item" varStatus="status"
						begin="0" end="0">
						<img class="first-slide" src="${item}" alt="First slide">
						<div class="container">
							<div class="carousel-caption text-left">
								<h1>Example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Sign
										up today</a>
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="carousel-item">
					<c:forEach items="${mainPhoto}" var="item" varStatus="status"
						begin="1" end="1">
						<img class="second-slide" src="${item}" alt="Second slide">
						<div class="container">
							<div class="carousel-caption">
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Learn
										more</a>
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="carousel-item">
					<c:forEach items="${mainPhoto}" var="item" varStatus="status"
						begin="2" end="2">
						<img class="third-slide" src="${item}" alt="Third slide">
						<div class="container">
							<div class="carousel-caption text-right">
								<h1>One more for good measure.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
								<p>
									<a class="btn btn-lg btn-primary" href="#" role="button">Browse
										gallery</a>
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<a class="carousel-control-prev" href="#myCarousel" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#myCarousel" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	</main>
	<!-- !PAGE CONTENT! -->
	<!-- Photo grid -->
	<div class="w3-container w3-padding-64 w3-center" id="youtube">
		<div class="w3-col m12">
			<div id="choiceList">
				<ol>
					<li><a
						href="/home?choice=<c:out value="${choice}"/>&select=musicvideo#youtube">뮤직비디오</a></li>
					<li><a
						href="/home?choice=<c:out value="${choice}"/>&select=broadcast#youtube">방송</a></li>
					<li><a
						href="/home?choice=<c:out value="${choice}"/>&select=mnet#youtube">엠넷</a></li>
					<li><a
						href="/home?choice=<c:out value="${choice}"/>&select=musicbank#youtube">뮤직뱅크</a></li>
					<li><a
						href="/home?choice=<c:out value="${choice}"/>&select=popularmusic#youtube">인기가요</a></li>
				</ol>
			</div>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="0"
				end="1">
				<iframe width="640" height="360" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="2"
				end="5">
				<iframe width="320" height="180" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="6"
				end="9">
				<iframe width="320" height="180" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="10" end="13">
				<iframe width="320" height="180" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="14" end="17">
				<iframe width="320" height="180" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="18" end="21">
				<iframe width="320" height="180" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="22" end="25">
				<iframe width="320" height="180" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
			</c:forEach>
		</div>
	</div>
	<div class="w3-container w3-padding-64 w3-center" id="photo">
		<div id="choiceList">
			<ol>
				<li><a
					href="/home?choice=<c:out value="${choice}"/>&select=paparazzi#photo">직찍</a></li>
				<li><a
					href="/home?choice=<c:out value="${choice}"/>&select=pictorial#photo">화보</a></li>
				<li><a
					href="/home?choice=<c:out value="${choice}"/>&select=broad#photo">방송
						사진</a></li>
				<li><a
					href="/home?choice=<c:out value="${choice}"/>&select=temp#photo">temp</a></li>
			</ol>
		</div>
		<div class="w3-row">
			<div class="w3-third">
				<c:forEach items="${result}" var="item" varStatus="status" begin="0"
					end="33">
					<img src="${item}" style="width: 100%" onclick="onClick(this)"
						alt="A boy surrounded by beautiful nature">
				</c:forEach>
			</div>
			<div class="w3-third">
				<c:forEach items="${result}" var="item" varStatus="status"
					begin="34" end="66">
					<img src="${item}" style="width: 100%" onclick="onClick(this)"
						alt="A boy surrounded by beautiful nature">
				</c:forEach>
			</div>
			<div class="w3-third">
				<c:forEach items="${result}" var="item" varStatus="status"
					begin="67" end="100">
					<img src="${item}" style="width: 100%" onclick="onClick(this)"
						alt="A boy surrounded by beautiful nature">
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="w3-container w3-padding-64 w3-center" id="twitter">
		<img src="/w3images/girl.jpg" style="width: 100%"
			onclick="onClick(this)" alt="Canoeing again"> <img
			src="/w3images/girl_train.jpg" style="width: 100%"
			onclick="onClick(this)" alt="A girl, and a train passing"> <img
			src="/w3images/closegirl.jpg" style="width: 100%"
			onclick="onClick(this)" alt="What a beautiful day!">
	</div>

	<!-- FOOTER -->
	<footer class="container">
		<p class="float-right">
			<a href="#">Back to top</a>
		</p>
	</footer>
	</main>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script>
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
	<script src="../../bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
</body>
</html>
