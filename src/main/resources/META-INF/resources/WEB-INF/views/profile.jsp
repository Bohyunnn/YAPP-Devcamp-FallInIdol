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
	
<!-- profile -->
      <div class="container-fluid" id="profile">
         <div class="row">
            <div style="margin-left: 83px" class="col-sm-7">
               <div class="col-sm-2 text-center">
                  <!--  class="img-circle" -->
                  <img src="../../img/bts/profile-contents-bts-gray-bar.png"
                     height="18px" alt="Avatar" />
               </div>
               <div class="col-sm-2 text-center">
                  <!--  class="img-circle" -->
   
                  <table border="0">
                     <tr>
                        <td><img src="../../img/bts/bts-profile-contents-photo.png"
                           height="226px" width="437px" alt="Avatar" /></td>
                        <td><img src="../../img/bts/bts-profile-contents-infomation.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                  </table>
               </div>
               <div style="margin-top: 14px" class="col-sm-2 text-center">
                  <!--  class="img-circle" -->
                  <img src="../../img/bts/bts-profile-contents-member-gray-bar.png"
                     height="18px" alt="Avatar" />
               </div>
               <div>
                  <table border="0">
                     <tr>
                        <td><img src="../../img/bts/bts-profile-contents-member-v.png"
                           height="139px" alt="Avatar" /></td>
                        <td style="margin-left: 54px"><img
                           src="../../img/bts/bts-profile-contents-member-jungkook.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                     <tr>
                        <td><img
                           src="../../img/bts/bts-profile-contents-member-suga.png"
                           height="139px" alt="Avatar" /></td>
                        <td><img src="../../img/bts/bts-profile-contents-member-rm.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                     <tr>
                        <td><img src="../../img/bts/bts-profile-contents-member-jin.png"
                           height="139px" alt="Avatar" /></td>
                        <td><img
                           src="../../img/bts/bts-profile-contents-member-jhope.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                     <tr>
                        <td><img
                           src="../../img/bts/bts-profile-contents-member-jimin.png"
                           height="139px" alt="Avatar" /></td>
                        <td></td>
                     </tr>
                  </table>
   
               </div>
   
   
            </div>
   
            <div class="row-sm-5" >
               <!--  앨범 들어갈 자리 -->
               <img src="../../img/bts/bts-profile-contents-album-gray-bar.png"
                  height=18px " alt="Avatar" />
               <c:forEach items="${album_result}" var="item" varStatus="status"
                  begin="0" end="33">
                  
            <table border="0" width="500" height="100">
               <tr>
                  <td rowspan="2">
                     <!--  앨범 들어갈 장소 -->
                     
                  <img src="${item.image}"  onclick="onClick(this)"
                     alt="A boy surrounded by beautiful nature">
               
                  </td>
                  
                  <td> <!-- 타이틀 들어갈 장소 -->
                     TITLE : ${item.content}" <p>
                     
               <!--  앨범 날짜 -->
               DATE : ${item.date}
                  </td>

               </tr>
               
         
                     </table>
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://googledrive.com/host/0B-QKv6rUoIcGREtrRTljTlQ3OTg"></script><!-- ie10-viewport-bug-workaround.js -->
<script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script><!-- holder.js -->
			
</html>