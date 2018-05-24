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
* {
    box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
    float: left;
    width: 50%;
    padding: 10px;
    height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}
</style>

</head>
<body>
	<jsp:include page="./head.jsp" flush="false" />

	 <!-- !PAGE CONTENT! -->
	  <!-- profile -->
      <div class="row" style="margin-left:84px; margin-right:83px" >
	  		<div class="column"  >
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
		  	<div class="column" >
		     	<!--  앨범 들어갈 자리 -->
               <img src="../../img/bts/bts-profile-contents-album-gray-bar.png; height=18px" alt="Avatar" />
               <div style="width:100%; height:900px; overflow:auto">
	               <c:forEach items="${album_result}" var="item" varStatus="status" begin="0" end="33">                  
	           		 <table border="0" width="500" height="100">
	            	   <tr>
	               		   <td rowspan="2">
	                    	 <!--  앨범 들어갈 장소 -->
	                    	 
	                          <img src="${item.image}"  style="height: 230px;width: 230px;" onclick="onClick(this)" alt="A boy surrounded by beautiful nature">               
	               		   </td>
	                  
	                	  <td> <!-- 타이틀 들어갈 장소 -->
	                  		   <strong>TITLE</strong>&nbsp;&nbsp;  ${item.content} <p>                     
	              			   <!--  앨범 날짜 -->
	               			   <strong>DATE</strong>&nbsp;&nbsp;   ${item.date}
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