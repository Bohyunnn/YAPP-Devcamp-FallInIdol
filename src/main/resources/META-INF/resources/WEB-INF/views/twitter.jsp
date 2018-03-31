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


</style>
</head>
<body>
<body>
	<div class="w3-dropdown-hover">  
		<button class="w3-button w3-black" title="Notifications" style="  width: 110px;height: 31px;" >${choice} <i class="fa fa-caret-down"></i></button>     
			<div class="w3-container w3-dropdown-content w3-card-4 w3-bar-block">
				<c:forEach items="${choicelist}" var="userChoice" varStatus="status" begin="0" end="2">
				     <a href="/home?choice=<c:out value="${userChoice}"/>" class="w3-bar-item w3-button">${userChoice }</a>
				</c:forEach>
			</div>
	</div>
	<a href="#feed" class="w3-bar-item w3-button w3-padding-large">Schedule</a>
	<div class="w3-dropdown-hover ">  
		<button class="w3-button w3-black" title="Notifications" style="  width: 110px;height: 31px;">ENGLISH <i class="fa fa-caret-down"></i></button>     
			<div class="w3-container w3-dropdown-content w3-card-4 w3-bar-block">
				<c:forEach items="${choicelist}" var="userChoice" varStatus="status" begin="0" end="2">
				     <a href="/home?choice=<c:out value="${userChoice}"/>" class="w3-bar-item w3-button">${userChoice }</a>
				</c:forEach>
			</div>
	</div>
	<a href="#feed" class="w3-bar-item w3-button w3-padding-large">CHAT</a>
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
	
</body>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
	
<script src="../../bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->

</html>