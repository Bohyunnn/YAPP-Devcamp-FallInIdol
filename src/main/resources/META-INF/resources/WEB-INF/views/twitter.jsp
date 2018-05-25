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
	
	<jsp:include page="./head.jsp" flush="false" />
	
	<!-- !PAGE CONTENT! -->
		<!-- twitter -->
		<div class="w3-row w3-container" style="margin-left:83px; margin-right:80px"> 
	 	 <div class="w3-col " style="width:20%; padding:8px">
			  	<c:forEach items="${twit_result}" var="item" varStatus="status" begin="0" end="2">
			  	
			  	 <img src="../../img/twitter-gray-box.png" style="width: 100%; height:18px" alt="Avatar" /><p>
			  	 	<div class ="col-sm-1">&nbsp;</div>
			  	 	 ${item.date}<p>
					 <span style="color:#6E6E6E">${item.content}</span> <p>
					 <img src="${item.image}" style="max-width: 100%;width: 100;" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" >
					<div class ="col-sm-1">&nbsp;</div>
				</c:forEach>
	  	 </div>
	  	 <div class="w3-col " style="width:20% ; padding:8px ">
			  	<c:forEach items="${twit_result}" var="item" varStatus="status" begin="3" end="5">
			  	  <img src="../../img/twitter-gray-box.png" style="width: 100%; height:18px" alt="Avatar" /><p>
			  	 	<div class ="col-sm-1">&nbsp;</div>
			  	 	 ${item.date}<p>
					 <span style="color:#6E6E6E">${item.content}</span> <p>
					 <img src="${item.image}" style="max-width: 100%;width: 100;" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" >
					<div class ="col-sm-1">&nbsp;</div>
				</c:forEach>
	  	 </div>
	  	  <div class="w3-col " style="width:20%; padding:8px">
			  	<c:forEach items="${twit_result}" var="item" varStatus="status" begin="5" end="7">
			  	  <img src="../../img/twitter-gray-box.png" style="width: 100%; height:18px" alt="Avatar" /><p>
			  	 	<div class ="col-sm-1">&nbsp;</div>
			  	 	 ${item.date}<p>
					 <span style="color:#6E6E6E">${item.content}</span> <p>
					 <img src="${item.image}" style="max-width: 100%;width: 100;" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" >
					<div class ="col-sm-1">&nbsp;</div>
				</c:forEach>
	  	 </div>
	  	 <div class="w3-col " style="width:20%; padding:8px">
			  	<c:forEach items="${twit_result}" var="item" varStatus="status" begin="8" end="10">
			  	  <img src="../../img/twitter-gray-box.png" style="width: 100%; height:18px" alt="Avatar" /><p>
			  	 	<div class ="col-sm-1">&nbsp;</div>
			  	 	 ${item.date}<p>
					 <span style="color:#6E6E6E">${item.content}</span> <p>
					 <img src="${item.image}" style="max-width: 100%;width: 100;" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" >
					<div class ="col-sm-1">&nbsp;</div>
				</c:forEach>
	  	 </div>
	  	 <div class="w3-col " style="width:20%; padding:8px">
			  	<c:forEach items="${twit_result}" var="item" varStatus="status" begin="11" end="13">
			  	 <img src="../../img/twitter-gray-box.png" style="width: 100%; height:18px" alt="Avatar" /><p>
			  	 	<div class ="col-sm-1">&nbsp;</div>
			  	 	 ${item.date}<p>
					<span style="color:#6E6E6E">${item.content}</span> <p>
					 <img src="${item.image}" style="max-width: 100%;width: 100;" onclick="clickImage(this)" class="w3-hover-opacity" alt="${item}" >
					<div class ="col-sm-1">&nbsp;</div>
				</c:forEach>
	  	 </div>
	  	
	  </div>
	
</body>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
	
<script src="../../bootstrap/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->

</html>
