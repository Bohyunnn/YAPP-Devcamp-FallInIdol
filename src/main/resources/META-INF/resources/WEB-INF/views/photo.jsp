<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
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
	
	@-webkit-keyframes zoom {
	    from {-webkit-transform:scale(0)} 
	    to {-webkit-transform:scale(1)}
	}
	
	@keyframes zoom {
	    from {transform:scale(0)} 
	    to {transform:scale(1)}
	}
	
	/* The Close Button */
	.close {
	    position: absolute;
	   	top: 100px;
	    right: 110px;
	    color: #f1f1f1;
	    z-index:100;
	    font-size: 30px;
	    font-weight: bold;
	    transition: 0.3s;
	}
	
	.close:hover,
	.close:focus {
	    color: #bbb;
	    text-decoration: none;
	    cursor: pointer;
	}
	
	/* 100% Image Width on Smaller Screens */
	@media only screen and (max-width: 700px){
	    .modal-content {
	        width: 100%;
	    }
	    .videowrapper {
		position:absolute;
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
		.col-sm-2 {
		}

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
	<a href="#feed" 
				class="w3-bar-item w3-button w3-padding-large">Schedule</a>
	<div class="w3-dropdown-hover ">  
		<button class="w3-button w3-black" title="Notifications" style="  width: 110px;height: 31px;">ENGLISH <i class="fa fa-caret-down"></i></button>     
			<div class="w3-container w3-dropdown-content w3-card-4 w3-bar-block">
				<c:forEach items="${choicelist}" var="userChoice" varStatus="status" begin="0" end="2">
				     <a href="/home?choice=<c:out value="${userChoice}"/>" class="w3-bar-item w3-button">${userChoice }</a>
				</c:forEach>
			</div>
	</div>
		<a href="#feed"
				class="w3-bar-item w3-button w3-padding-large">CHAT</a>
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
				<a href="/home?menu=profile"
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
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="twitter">TWITTER</a></div>
				<div class ="col-sm-1">&nbsp;</div>
				 </div>
		</div>
	<main>
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
				    <img src="${item.getUrl()}" style="max-width: 100%;width: 600px; padding:3px" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="26" end="50" >
				    <img src="${item.getUrl()}" style="max-width: 100%;width: 600px; padding:3px " onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="51" end="75" >
				    <img src="${item.getUrl()}" style="max-width: 100%;width: 600px; padding:3px" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="75" end="100" >
				    <img src="${item.getUrl()}" style="max-width: 100%;width: 600px; padding:3px" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
		</div>
	</div>
	
	<div id="myModal" class="modal">
	  <span class="close" data-dismiss="modal">&times;</span>  
	  <img class="modal-content" id="img01">
	  <div id="caption"></div>
	</div>
	</main>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
	
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
  
	<script src="../../bootstrap/js/bootstrap.min.js"></script>
</script>
</html>