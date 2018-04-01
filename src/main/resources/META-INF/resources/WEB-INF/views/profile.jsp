<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- profile -->
      <div class="container-fluid" id="profile">
         <div class="row">
            <div style="margin-left: 83px" class="col-sm-7">
               <div class="col-sm-2 text-center">
                  <!--  class="img-circle" -->
                  <img src="../../img/profile-contents-bts-gray-bar.png"
                     height="18px" alt="Avatar" />
               </div>
               <div class="col-sm-2 text-center">
                  <!--  class="img-circle" -->
   
                  <table border="0">
                     <tr>
                        <td><img src="../../img/bts-profile-contents-photo.png"
                           height="226px" width="437px" alt="Avatar" /></td>
                        <td><img src="../../img/bts-profile-contents-infomation.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                  </table>
               </div>
               <div style="margin-top: 14px" class="col-sm-2 text-center">
                  <!--  class="img-circle" -->
                  <img src="../../img/bts-profile-contents-member-gray-bar.png"
                     height="18px" alt="Avatar" />
               </div>
               <div>
                  <table border="0">
                     <tr>
                        <td><img src="../../img/bts-profile-contents-member-v.png"
                           height="139px" alt="Avatar" /></td>
                        <td style="margin-left: 54px"><img
                           src="../../img/bts-profile-contents-member-jungkook.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                     <tr>
                        <td><img
                           src="../../img/bts-profile-contents-member-suga.png"
                           height="139px" alt="Avatar" /></td>
                        <td><img src="../../img/bts-profile-contents-member-rm.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                     <tr>
                        <td><img src="../../img/bts-profile-contents-member-jin.png"
                           height="139px" alt="Avatar" /></td>
                        <td><img
                           src="../../img/bts-profile-contents-member-jhope.png"
                           height="139px" alt="Avatar" /></td>
                     </tr>
                     <tr>
                        <td><img
                           src="../../img/bts-profile-contents-member-jimin.png"
                           height="139px" alt="Avatar" /></td>
                        <td></td>
                     </tr>
                  </table>
   
               </div>
   
   
            </div>
   
            <div class="row-sm-5" >
               <!--  앨범 들어갈 자리 -->
               <img src="../../img/bts-profile-contents-album-gray-bar.png"
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
</html>