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
<%-- 	<div class="w3-display-container w3-animate-opacity">
		<img class="First-slide"
			style="width: 100%; min-height: 350px; max-height: 600px;"
			src="${mainPhoto[0]}" alt="First slide">
		<div class="w3-display-topleft w3-text-white w3-padding-large"
			style="padding: 100px 48px">
			<a href="/"><i class="fa fa-home fa-3x" aria-hidden="true"></i></a>
		</div>
		<div class="w3-display-topright w3-text-white w3-padding-large"
			style="padding: 100px 48px">

			<a href='#' class="w3-bar-item w3-button w3-padding-large"
				data-toggle="popover" id="Schedule" data-placement="right"
				data-content="">SCHEDULE</a> &nbsp;&nbsp;&nbsp;&nbsp;
			<div class="w3-dropdown-hover ">
				<button class="w3-button w3-black" title="Notifications"
					style="width: 110px; height: 31px;">
					LANGUAGE <i class="fa fa-caret-down"></i>
				</button>

				<div class="w3-dropdown-content w3-card-4 w3-bar-block">
					<c:forEach items="${language}" var="lang" varStatus="status"
						begin="0" end="3">
						<a href='/home?choice=<c:out value="${choice}"/>'
							class="w3-bar-item w3-button">${lang}</a>
					</c:forEach>
				</div>
			</div>
			<a href="#FEED" class="w3-bar-item w3-button w3-padding-large">CHAT</a>

		</div>
	</div>

	<div id="myPopoverContent" style="display: none">
		<table>
			<tbody>
				<c:forEach items='${calendarList}' var='item' varStatus='status'
					begin='0' end='9'>
					<tr>
						<td><font color="white">${item.content }</font></td>
					</tr>
					<tr>
						<td>${item.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="w3-row w3-large w3-white">
		<div class="row">
			<div class="col-sm-1">&nbsp;</div>
			<div class="col-sm-2">
				<a href='/home?menu=feed&amp;choice=<c:out value="${choice}"/>'
					class="w3-bar-item w3-button w3-padding-large">FEED</a>
			</div>
			<div class="col-sm-2">
				<a href="/home?menu=profile"
					class="w3-bar-item w3-button w3-padding-large">PROFILE</a>
			</div>
			<div class="col-sm-2">
				<a href='/home?menu=youtube&amp;choice=<c:out value="${choice}"/>'
					class="w3-bar-item w3-button w3-hide-small w3-padding-large"
					title="youtuberesult">YOUTUBE</a>
			</div>
			<div class="col-sm-2">
				<a href='/photoNoOption?choice=<c:out value="${choice}"/>'
					class="w3-bar-item w3-button w3-hide-small w3-padding-large"
					style="background: #2F6FF6;" title="photo"><font color="white">PHOTO</font></a>
			</div>
			<div class="col-sm-2">
				<a href='/home?menu=twitter&amp;choice=<c:out value="${choice}"/>'
					class="w3-bar-item w3-button w3-hide-small w3-padding-large"
					title="twitter">TWITTER</a>
			</div>
			<div class="col-sm-1">&nbsp;</div>

		</div>
	</div> --%>
	<main>
	<div class="w3-container w3-padding-64 " >
		<div id="choiceList" class = "w3-right">
			<ol>
				<li ><a id = "paparazzi"
					href='/photo?choice=<c:out value="${choice}"/>&amp;select=paparazzi'>직찍
				</a></li>
				<li  ><a id = "official"
					href='/photo?choice=<c:out value="${choice}"/>&amp;select=official'>
						공식 </a></li>
				<li ><a id = "pictorial"
					href='/photo?choice=<c:out value="${choice}"/>&amp;select=pictorial'>화보
				</a></li>

				<li ><a id = "uhd"
					href='/photo?choice=<c:out value="${choice}"/>&amp;select=uhd'>고화질
				</a></li>
				<li ><a id="airport"
					href='/photo?choice=<c:out value="${choice}"/>&amp;select=airport'>공항
				</a></li>

			</ol>
			<%-- <ol>
				<c:forEach items="${names }" var="name">
					<li><a
						href='/photo?choice=<c:out value="${choice}"/>&select=<c:out value="${name}"/>'>
							${name}</a></li>
				</c:forEach>
			</ol> --%>
		</div>
		<div class="w3-row">
			<div class="w3-quarter">
				<c:set var="count" value="${listNum div 4}" />
				<c:forEach items="${result}" var="item" varStatus="status" begin="0"
					end="${count}">
					<img src="${item.getUrl()}"
						style="width: 100%; min-height: 350px; max-height: 600px; padding: 3px;"
						onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}"
						onError="this.style.display='none'">
				</c:forEach>
			</div>

			<div class="w3-quarter">
				<c:set var="count2" value="${(listNum - count) div 3}" />
				<c:set var="total" value="${ count + count2}" />

				<c:forEach items="${result}" var="item" varStatus="status"
					begin="${count+1}" end="${total}">
					<img src="${item.getUrl()}"
						style="width: 100%; min-height: 350px; max-height: 600px; padding: 3px;"
						onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}"
						onError="this.style.display='none'">
				</c:forEach>
			</div>

			<div class="w3-quarter">
				<c:set var="count3" value="${(listNum - total) div 2}" />

				<c:set var="total2" value="${total + count3 }" />
				<c:forEach items="${result}" var="item" varStatus="status"
					begin="${total+1}" end="${total2}">
					<img src="${item.getUrl()}"
						style="width: 100%; min-height: 350px; max-height: 600px; padding: 3px;"
						onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}"
						onError="this.style.display='none'">
				</c:forEach>
			</div>

			<div class="w3-quarter">
				<c:set var="count4" value="${(listNum - total2)}" />

				<c:forEach items="${result}" var="item" varStatus="status"
					begin="${total2+1 }" end="${listNum}">
					<img src="${item.getUrl()}"
						style="width: 100%; min-height: 350px; max-height: 600px; padding: 3px;"
						onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}"
						onError="this.style.display='none'">
				</c:forEach>
			</div>
		</div>
	</div>

	<div id="myModal" class="modal">
		<span class="close" data-dismiss="modal">&times;</span> 
		<img class="modal-content" id="img01" src="" alt="">
		<div id="caption"></div>

	</div>
	</main>
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