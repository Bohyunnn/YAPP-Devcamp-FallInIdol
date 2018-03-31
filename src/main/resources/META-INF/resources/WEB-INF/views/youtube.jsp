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
				<a href="/home?menu=youtube&choice=<c:out value="${choice}"/>"		class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
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
	
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
		<script src="../../bootstrap/js/bootstrap.min.js"></script>
</html>