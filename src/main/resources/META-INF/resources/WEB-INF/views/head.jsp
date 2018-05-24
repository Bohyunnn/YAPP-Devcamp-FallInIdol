<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>LookingForStar</title>

<!-- Bootstrap core CSS -->
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
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif;
}

td {
	padding: 10px;
}

tbody tr:nth-child(2n) {
	background-color: #FFFFFF;
}

</style>
</head>
<body>
	<div class="w3-display-container w3-animate-opacity">
		<img class="First-slide"
			style="width: 100%; min-height: 350px; max-height: 600px;"
			src="${mainPhoto[0]}" alt="First slide">
		<div class="w3-display-topleft w3-text-white w3-padding-large"
			style="padding: 100px 48px">
			
			<a href="/home" name="logo" id="logo" ><img src="/resources/../img/logo-wh.png"></a>
			
		</div>
		<div class="w3-display-topright w3-text-white w3-padding-large"
			style="padding: 100px 48px">

			<a href='#' data-toggle="popover" id="Schedule"
				data-placement="right" data-content="">SCHEDULE</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="w3-dropdown-hover ">
				<button class="w3-button w3-black" title="Notifications"
					style="width: 110px; height: 31px;">
					LANGUAGE <i class="fa fa-caret-down"></i>
				</button>

				<div class="w3-dropdown-content w3-card-4 w3-bar-block">
					<c:forEach items="${languagelist}" var="lang" varStatus="status"
						begin="0" end="6">
						<a href='/feed?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>'
							class="w3-bar-item w3-button">${lang}</a>
					</c:forEach>
				</div>
			</div>
			<a href="#FEED" class="w3-bar-item w3-button w3-padding-large">CHAT</a>
		</div>
	</div>

	<div class="w3-row w3-large w3-white">
		<a
			class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large"
			href="javascript:void(0);" onclick="openNav()"><i
			class="fa fa-bars"></i></a>
		<div class="row">
			<div class="col-sm-1">&nbsp;</div>
			<div class="col-sm-2">
				<a href='/feed?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>' 
				class="w3-bar-item w3-button w3-padding-large">FEED</a>
			</div>
			<div class="col-sm-2">
				<a href='/profile?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>'
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">PROFILE</a>
			</div>
			<div class="col-sm-2">
				<a href='/youtube?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>'
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
					title="youtuberesult">YOUTUBE</a>
			</div>
			<div class="col-sm-2">
				<a href='/photoNoOption?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>'
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				style="background: #2F6FF6;" title="photo"><font color="white">PHOTO</font></a>
			</div>
			<div class="col-sm-2">
				<a href='/twitter?choice=<c:out value="${choice}"/>&language=<c:out value="${lang}"/>'
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">TWITTER</a>
			</div>
		</div>

		<div id="myPopoverContent" style="display: none">
			<!-- style="display: none" -->
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

	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"

	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous" type="text/javascript"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script> 
<script type="text/javascript" src="jquery.cookie.js"></script>

			<script type="text/javascript">
			window.jQuery
					|| document
							.write('<script src="js/vendor/jquery-slim.min.js"><\/script>')
			function openNav() {
				var x = document.getElementById("navDemo");
				if (x.className.indexOf("w3-show") == -1) {
					x.className += " w3-show";
				} else {
					x.className = x.className.replace(" w3-show", "");
				}

			}
		</script>
		<script type="text/javascript">
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

		<script src="../../bootstrap/js/bootstrap.min.js"
			type="text/javascript"></script>
		<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
		
</html>