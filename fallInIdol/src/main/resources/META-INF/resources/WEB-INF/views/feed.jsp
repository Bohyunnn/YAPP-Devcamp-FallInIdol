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

<style type="text/css">

#choiceList ol {
	float: left;
	list-style: none;
	margin: 0px;
	padding: 0px;
	max-width: 900px;
	width: 100%;
	text-transform: uppercase;
}

#choiceList li {
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
	background: #2F6FF6;
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

</style>
</head>
<body>
	<jsp:include page="./head.jsp" flush="false" />

	<!-- !PAGE CONTENT! -->
	<!-- feed -->
    <div class="w3-row w3-container" style="margin-left:83px; margin-right:80px"> 
	   <div class="w3-col " style="width:20%">
				<c:set var="count" value="${listNum div 4}" />
				<c:forEach items="${result}" var="item" varStatus="status" begin="0"
					end="${5}">
					<img src="${item.getUrl()}"
						style="width: 100%; min-height: 350px; max-height: 600px; padding: 6px 6px 6px 6px; "
						onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}"
						onError="this.style.display='none'">
				</c:forEach>
			</div>

			  
	  
	  <div class="w3-col " style="width:20%">
	  	<c:forEach items="${youtube}" var="item" varStatus="status" begin="0"
				end="9">
				<iframe width="100%" height="200" style="padding:3px 3px 3px 3px" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" ></iframe>
		</c:forEach>
	  </div>
	  
	   <div class="w3-col " style="width:20%">
				<c:set var="count2" value="${(listNum - count) div 3}" />
				<c:set var="total" value="${ count + count2}" />

				<c:forEach items="${result}" var="item" varStatus="status"
					begin="${count+1}" end="${count+6}">
					<img src="${item.getUrl()}"
						style="width: 100%; min-height: 350px; max-height: 600px; padding: 6px 6px 6px 6px;"
						onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}"
						onError="this.style.display='none'">
				</c:forEach>
		</div>
			
	  <div class="w3-col" style="width:20%">
	  	<c:forEach items="${youtube}" var="item" varStatus="status" begin="10"
				end="19">
				<iframe width="100%" height="200"style="padding:3px 3px 3px 3px" src="${item.url}?showinfo=0"
					frameborder="0" allow="autoplay; encrypted-media" ></iframe>
		</c:forEach>
	  </div>
	  
	  	
	  <div class="w3-col" style="width:20%;padding:8px">
	  	<c:forEach items="${twit_result}" var="item" varStatus="status" begin="0" end="2">
			  	
			  	 <img src="../../img/twitter-gray-box.png" style="width: 100%; height:18px" alt="Avatar" /><p>
			  	 	<div class ="col-sm-1">&nbsp;</div>
			  	  ${item.date}<p>
					 <span style="color:#6E6E6E">${item.content}</span> <p>
					 <img src="${item.image}" style="max-width: 100%;width: 100;" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" >
					<div class ="col-sm-1">&nbsp;</div>
				</c:forEach>
	  </div>
	  
	  


	</div>

	
		

	<div id="myModal" class="modal">
		<span class="close" data-dismiss="modal">&times;</span> 
		<img class="modal-content" id="img01" src="" alt="">
		<div id="caption"></div>

	</div>
	</main>
	<footer class="container">
			<p class="float-right">
				<a href="#">Back to top</a>
			</p>
		</footer>
	
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous" type="text/javascript"></script>

<script type="text/javascript">
	function clickImage(image) {
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
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}

	}
</script>

<script type="text/javascript">
			$(document).ready(function() {
				var selectValue = '<c:out value="${select}"/>';
				console.log(selectValue);
				if (selectValue == 'paparazzi'){
					paparazzi.style.background="#2F6FF6";
					paparazzi.style.color="#FFFFFF";
				} else if (selectValue == 'official'){
					official.style.background="#2F6FF6";
					official.style.color="#FFFFFF";
				} else if (selectValue == 'pictorial'){
					pictorial.style.background="#2F6FF6";
					pictorial.style.color="#FFFFFF";
				} else if (selectValue == 'uhd'){
					uhd.style.background="#2F6FF6";
					uhd.style.color="#FFFFFF";
				} else if (selectValue == 'airport'){
					airport.style.background="#2F6FF6";
					airport.style.color="#FFFFFF";
				}
				
			});
</script>


<script type="text/javascript">
	/* $(document).ready(function() */
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


<script src="../../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript"></script>
</html>