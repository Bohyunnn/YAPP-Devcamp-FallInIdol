<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
	<link href="../Styles/Site.css" rel="stylesheet" type="text/css" />    

    <title>LookingForStar</title>

    <!-- Bootstrap core CSS -->
    <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../bootstrap/css/carousel.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
	html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
	#myCarousel {
    		width: 70%;
	}
	.carousel-control {
	    margin-top: 20px;
	}
	.carousel-inner .item {
	    width: 100%;
	    height: 400px;
	    /* -webkit-background-size: cover;
	    -moz-background-size: cover;
	    -o-background-size: cover;
	    background-size: cover; */
	}
	#choiceList ol {
		float: left;
	    list-style: none;
	    margin: 0px;
	    padding: 0px;
	  
	    max-width: 900px;
	    width: 100%;
	}
  
	#choiceList li{
	   /*  margin: 0 0 0 0;
	    padding: 0 0 0 0;
	    border : 0;
	    float: left; */
	    float:left; list-style:none; margin:2px;
		display:block; width:150px; height:40px; background:#ffffff; color:#000000; border1px solid blue; font-size:12px;
 text-align:center; padding-top:10px; text-decoration:none;
	}
    #choiceList li a:hover
 	{background:#099; text-decoration:none;}  */

	/* #selectable .ui-selecting { background: #FECA40; }
  	#selectable .ui-selected { background: #F39814; color: white; }
	 */
	.w3-third {
		position:relative;
		float:left
	}
	.w3-third.text {
		position:absolute;
		
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
	</style>
  </head>
  <body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-row w3-large w3-light-grey">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="/" class="w3-bar-item w3-button w3-padding-large">Logo</a>
  <a href="#youtube" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="youtube">YOUTUBE</a>
  <a href="#photo" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="photo">PHOTO</a>
  <a href="#twitter" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="twitter">TWITTER</a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="chatting">
  <i class="fa fa-comments"></i>
  </a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="setting">
    <i class="fa fa-user"></i>
  </a>
 </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-hide w3-hide-large w3-hide-medium w3-right">
    <a href="#team" class="w3-bar-item w3-button">Team</a>
    <a href="#work" class="w3-bar-item w3-button">Work</a>
    <a href="#pricing" class="w3-bar-item w3-button">Price</a>
    <a href="#contact" class="w3-bar-item w3-button">Contact</a>
    <a href="#" class="w3-bar-item w3-button">Search</a>
  </div>
</div>

  <main role="main">	
  <div class="w3-main w3-padding" style="max-width:1200px;margin-top:20px">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
        <c:forEach var="photo" items="${result}" begin="0" end="0">
          <div class="carousel-item active">
            <img class="first-slide" src="${photo}" alt="First slide" >
            <div class="container">
              <div class="carousel-caption text-left">
                <h1>Example headline.</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
              </div>
            </div>
          </div>
          </c:forEach>
          <c:forEach var="photo" items="${result}" begin="1" end="2" >
          <div class="carousel-item">
            <img class="second-slide" src="${photo}" alt="Second slide" style="background-color:rgba( 0, 0, 0, 0.5 );">
            <div class="container">
              <div class="carousel-caption">
                <h1>Another example headline.</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
              </div>
            </div>
          </div>
          </c:forEach>
         <!--  <div class="carousel-item">
            <img class="third-slide" src="http://media.infospesial.net/image/p/2015/12/a5d9a-red-velvet.jpg" alt="Third slide">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>One more for good measure.</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
              </div>
            </div>
          </div> -->
         
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
      </div>
  <!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">
   
    <div class="w3-container w3-padding-64 w3-center" id="youtube">
      <img src="/w3images/natureboy.jpg" style="width:100%" onclick="onClick(this)" alt="A boy surrounded by beautiful nature">
      <img src="/w3images/girl_mountain.jpg" style="width:100%" onclick="onClick(this)" alt="What a beautiful scenery this sunset">
      <img src="/w3images/girl.jpg" style="width:100%" onclick="onClick(this)" alt="The Beach. Me. Alone. Beautiful">
    </div>
    
      <!-- Photo grid -->
     <div class="w3-container w3-padding-64 w3-center" id = "photo">
      <div id="choiceList">
	  <ol>
	    <li id = "paparazzi"><a href="/home?choice=<c:out value="${choice}"/>&select=paparazzi#photo">직찍</a></li>
	    <li id = "pictorial"><a href="/home?choice=<c:out value="${choice}"/>&select=pictorial#photo">화보</a></li>
	    <li id = "broad"><a href="/home?choice=<c:out value="${choice}"/>&select=broad#photo">방송 사진</a></li>
	    <li id = "temp"><a href="/home?choice=<c:out value="${choice}"/>&select=temp#photo">temp</a></li>
	  </ol>
	</div>
	    <div class="w3-row">
		    <div class="w3-quarter">
			    	<c:forEach items="${result}" var="item" varStatus="status" begin="0" end="25" >
				    <img src="${item}" style="width:100%" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="36" end="50" >
				    <img src="${item}" style="width:100%" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="51" end="75" >
				    <img src="${item}" style="width:100%" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
				</c:forEach>
			</div>
			<div class="w3-quarter">
				<c:forEach items="${result}" var="item" varStatus="status" begin="76" end="100" >
				    <img src="${item}" style="width:100%" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
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
      <img src="/w3images/girl.jpg" style="width:100%" onclick="onClick(this)" alt="Canoeing again">
      <img src="/w3images/girl_train.jpg" style="width:100%" onclick="onClick(this)" alt="A girl, and a train passing">
      <img src="/w3images/closegirl.jpg" style="width:100%" onclick="onClick(this)" alt="What a beautiful day!">
    </div>
	</div>
      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
      </footer>
    </main>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-slim.min.js"><\/script>')
    function openNav() {
	    var x = document.getElementById("navDemo");
	    if (x.className.indexOf("w3-show") == -1) {
	        x.className += " w3-show";
	    } else { 
	        x.className = x.className.replace(" w3-show", "");
	    }
	}
    
    
    </script>
    <script language="javascript">
    		$(document).ready(function() {
    			$(".paparazzi, .pictorial, .broad, .temp").click(function() {
    				alert("버튼클릭 ");
    			});
    		});
    		
    </script>
    <script>
   	function clickImage(image) {
   		
	    var modal = document.getElementById('myModal');
	
		 // Get the image and insert it inside the modal - use its "alt" text as a caption
		 var modalImg = document.getElementById("img01");
		 var captionText = document.getElementById("caption");
		 
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
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
  </body>
</html>
