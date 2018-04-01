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

</style>
</head>
<body>
	<div class="w3-dropdown-hover">  
		<button class="w3-button w3-black" title="Notifications" style="  width: 110px;height: 31px;" >${choice} <i class="fa fa-caret-down"></i></button>     
			<div class="w3-container w3-dropdown-content w3-card-4 w3-bar-block">
				<c:forEach items="${choicelist}" var="userChoice" varStatus="status" begin="0" end="2">
				     <a href="/home?choice=<c:out value="${userChoice}"/>" class="w3-bar-item w3-button">${userChoice }</a>
				</c:forEach>
			</div>
	</div>
	<a href="#calendarModal" 
				class="w3-bar-item w3-button w3-padding-large">Schedule</a>
	<div class="w3-dropdown-hover ">  
		<button class="w3-button w3-black" title="Notifications" style="  width: 110px;height: 31px;">ENGLISH <i class="fa fa-caret-down"></i></button>     
			<div class="w3-container w3-dropdown-content w3-card-4 w3-bar-block">
				<c:forEach items="${choicelist}" var="userChoice" varStatus="status" begin="0" end="2">
				     <a href="/home?choice=<c:out value="${userChoice}"/>" class="w3-bar-item w3-button">${userChoice }</a>
				</c:forEach>
			</div>
	</div>
	<a href="#FEED"
				class="w3-bar-item w3-button w3-padding-large">CHAT</a>
				
	<div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div>
	      <div class="modal-body">
			<c:forEach items="${calendar_result}" var="item" varStatus="status" begin="0" end="9">
			${item.date}
			<p>
			${item.content }
		</c:forEach>	
	      </div>
	      <div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		<button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Navbar -->
	<div class="w3-display-container w3-animate-opacity">
		<c:forEach items="${mainPhoto}" var="item" varStatus="status" begin="0" end="0">
			<img class="First-slide" style="width:100%;min-height:350px;max-height:600px;" src="${item}" alt="First slide">
		</c:forEach>
	</div>

		<div class="w3-row w3-large w3-white">
			<a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a> 
				<div class = "row">
				<div class ="col-sm-1">&nbsp;</div>
				<div class ="col-sm-2">
				<a href="/home?menu=feed&choice=<c:out value="${choice}"/>"
				class="w3-bar-item w3-button w3-padding-large">FEED</a></div> 
				<div class ="col-sm-2">
				<a href="/home?menu=profile&choice=<c:out value="${choice}"/>"
				class="w3-bar-item w3-button w3-padding-large">PROFILE</a></div> 
				<div class ="col-sm-2">
				<a href="/home?menu=youtube&choice=<c:out value="${choice}"/>"			class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="youtuberesult">YOUTUBE</a></div>
				<div class ="col-sm-2">
				 <a href="/home?menu=photo&choice=<c:out value="${choice}"/>"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"				
				title="photo">PHOTO</a></div>
				<div class ="col-sm-2">
				 <a href="/home?menu=twitter&choice=<c:out value="${choice}"/>"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">TWITTER</a>
				</div>
		</div>

		<!-- Navbar on small screens -->
		<!-- <div id="navDemo"
			class="w3-bar-block w3-hide w3-hide-large w3-hide-medium w3-right">
			<a href="#team" class="w3-bar-item w3-button">Team</a> <a
				href="#work" class="w3-bar-item w3-button">Work</a> <a
				href="#pricing" class="w3-bar-item w3-button">Price</a> <a
				href="#contact" class="w3-bar-item w3-button">Contact</a> <a
				href="#" class="w3-bar-item w3-button">Search</a>
		</div> -->



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
				<iframe width="593" height="333" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="2"
				end="4">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status" begin="5"
				end="7">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="8" end="10">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="11" end="13">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="14" end="16">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="17" end="19">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="20" end="22">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
			</c:forEach>
		</div>
		<div class="w3-col m12">
			<c:forEach items="${youtube}" var="item" varStatus="status"
				begin="23" end="25">
				<iframe width="393" height="221" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" allowfullscreen style="padding:3px 3px 3px 3px"></iframe>
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
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="0" end="25" >
				    <img src="${item}" style="max-width: 100%;width: 600px; padding:3px" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="26" end="50" >
				    <img src="${item}" style="max-width: 100%;width: 600px; padding:3px " onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="51" end="75" >
				    <img src="${item}" style="max-width: 100%;width: 600px; padding:3px" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="75" end="100" >
				    <img src="${item}" style="max-width: 100%;width: 600px; padding:3px" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
		</div>
	</div>

		<div id="myModal" class="modal">
			<span class="close" data-dismiss="modal">&times;</span> 
			<img class="modal-content" id="img01">
			<div id="caption"></div>
		</div>

		<div class="w3-container w3-padding-64 w3-center" id="twitter">
			<div class="w3-row">
				<div class="w3-third">
					<c:forEach items="${twit_result}" var="item" varStatus="status"
						begin="0" end="33">
						<img src="${item}" style="width: 100%" onclick="onClick(this)"
							>
					</c:forEach>
				</div>
				<div class="w3-third">
					<c:forEach items="${twit_result}" var="item" varStatus="status"
						begin="34" end="66">
						<img src="${item}" style="width: 100%" onclick="onClick(this)"
							>
					</c:forEach>
				</div>
				<div class="w3-third">
					<c:forEach items="${twit_result}" var="
				item"
						varStatus="status" begin="67" end="100">
						<img src="${item}" style="width: 100%" onclick="onClick(this)"
							>
					</c:forEach>
				</div>
			</div>
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
	<script>
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
		 var captionText = document.getElementById("caption");
		 
		 modal.style.display = "block";
		 modalImg.src = image.src;
		 captionText.innerHTML = image.alt;
		 
		
		 // Get the <span> element that closes the modal	 var span = document.getElementsByClassName("close")[0];
		
		 // When the user clicks on <span> (x), close the modal
		 span.onclick = function() { 
		     modal.style.display = "none";
		 } 
		
   	}
   
   	
    </script>
    
    <script>
    function clickCalendar() {
	    	<c:forEach items="${calendar_result}" var="item" varStatus="status" begin="0" end="9">
			${item.date}
			<p>
			${item.content }
		</c:forEach>		
    		${#content}.html
    	
    }
    </script>
  
	<script src="../../bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg"></script><!-- ie10-viewport-bug-workaround.js -->
<script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script><!-- holder.js -->

</body>
</html>