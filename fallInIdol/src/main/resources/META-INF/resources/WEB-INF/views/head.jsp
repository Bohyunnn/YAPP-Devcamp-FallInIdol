<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>


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
#container {
	width: 100%;
	height: auto;
}

#container2 {
	position: absolute;
	height: auto;
	max-width: 200px;
	transform: translateX(-50%) translateY(-50%);
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
	background-color: #f8f8f8;
	overflow: hidden;
	transform: translateX(-50%) translateY(-50%);
}

.inner-container {
	min-height: 400px;
	display: inline-block;
	overflow-y: auto;
	border: 1px solid black;
}

#chats-container {
	height: 70%;
	width: 80%;
}

#users-container {
	height: 70%;
	width: 15%;
}

body {
	background-color: #edeff2;
	font-family: "Calibri", "Roboto", sans-serif;
}

.chat_window {
	position: absolute;
	width: calc(100% - 20px);
	max-width: 300px;
	height: 500px;
	border-radius: 10px;
	background-color: #fff;
	left: 50%;
	top: 50%;
	transform: translateX(-50%) translateY(-50%);
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
	background-color: #f8f8f8;
	overflow: hidden;
}

.top_menu {
	background-color: #fff;
	width: 100%;
	padding: 20px 0 15px;
	box-shadow: 0 1px 30px rgba(0, 0, 0, 0.1);
}

.top_menu .buttons {
	margin: 3px 0 0 20px;
	position: absolute;
}

.top_menu .buttons .button {
	width: 16px;
	height: 16px;
	border-radius: 50%;
	display: inline-block;
	margin-right: 10px;
	position: relative;
}

.top_menu .buttons .button.close {
	background-color: #f5886e;
}

.top_menu .buttons .button.minimize {
	background-color: #fdbf68;
}

.top_menu .buttons .button.maximize {
	background-color: #a3d063;
}

.top_menu .title {
	text-align: center;
	color: #bcbdc0;
	font-size: 20px;
}

.messages {
	position: relative;
	list-style: none;
	padding: 20px 10px 0 10px;
	margin: 0;
	height: 340px;
	overflow-x: hidden;
	overflow-y: auto;
}

.messages .message {
	clear: both;
	overflow: hidden;
	margin-bottom: 20px;
	transition: all 0.5s linear;
	opacity: 0;
}

.messages .message.left .avatar {
	background-color: #f5886e;
	float: left;
}

.messages .message.left .text_wrapper {
	background-color: #1278ff;
	margin-left: 20px;
}

.messages .message.left .text_wrapper::after, .messages .message.left .text_wrapper::before
	{
	right: 100%;
	border-right-color: #1278ff;
}

.messages .message.left .text {
	color: #c48843;
}

.messages .message.right .avatar {
	background-color: #fdbf68;
	float: right;
}

.messages .message.right .text_wrapper {
	background-color: #c7eafc;
	margin-right: 20px;
	float: right;
}

.messages .message.right .text_wrapper::after, .messages .message.right .text_wrapper::before
	{
	left: 100%;
	border-left-color: #c7eafc;
}

.messages .message.right .text {
	color: #45829b;
}

.messages .message.appeared {
	opacity: 1;
}

.messages .message .avatar {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	display: inline-block;
}

.messages .message .text_wrapper {
	display: inline-block;
	padding: 20px;
	border-radius: 6px;
	width: calc(100% - 85px);
	min-width: 100px;
	position: relative;
}

.messages .message .text_wrapper::after, .messages .message .text_wrapper:before
	{
	top: 18px;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
}

.messages .message .text_wrapper::after {
	border-width: 13px;
	margin-top: 0px;
}

.messages .message .text_wrapper::before {
	border-width: 15px;
	margin-top: -2px;
}

.messages .message .text_wrapper .text {
	font-size: 18px;
	font-weight: 300;
}

.bottom_wrapper {
	position: relative;
	width: 100%;
	background-color: #1278ff;
	padding: 20px 20px;
	position: absolute;
	bottom: 0;
}

.bottom_wrapper .message_input_wrapper {
	display: inline-block;
	height: 50px;
	border-radius: 25px;
	border: 1px solid #bcbdc0;
	width: calc(100% - 160px);
	position: relative;
	padding: 0 20px;
}

.bottom_wrapper .message_input_wrapper .message_input {
	border: none;
	height: 100%;
	box-sizing: border-box;
	width: calc(100% - 40px);
	position: absolute;
	outline-width: 0;
	color: gray;
}

.bottom_wrapper .send_message {
	width: 140px;
	height: 50px;
	display: inline-block;
	border-radius: 50px;
	background-color: #1278ff;
	border: 2px solid #a3d063;
	color: #fff;
	cursor: pointer;
	transition: all 0.2s linear;
	text-align: center;
	float: right;
}

.bottom_wrapper .send_message:hover {
	color: #1278ff;
	background-color: #1278ff;
}

.bottom_wrapper .send_message .text {
	font-size: 18px;
	font-weight: 300;
	display: inline-block;
	line-height: 48px;
}

.message_template {
	display: none;
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
			
			<a href="#CHAT"  data-toggle="modal"
				data-target="#myModal">CHAT</a>
			
		</div>
	</div>
	
	<!-- start Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="container2">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<div class="modal-body">
						<ul class="messages">
							<div class="row">
								<div class="col-lg-12">
									<div class="container">
										<!-- 채팅 내용 -->
										<div id="chats-container" class="media"></div>
										<!-- 유저 목록 -->
										<!-- 										<div id="users-container" class="media"></div> -->
									</div>
								</div>
							</div>
						</ul>
					</div>
					<div class="modal-footer">
						<div id="new-chat-container">
							<div class="form-group col-xs-9">
								<input id="new-chat-input" style="height: 40px;" type="text"
									class="form-control" placeholder="Type your message here..." />
							</div>
							<div class="form-group col-xs-3">
								<input type="button" value="Send" id="new-chat-button">
							</div>
						</div>
					</div>
				</div>
			</div>
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
							<td bgcolor="#2F6FF6"><font color="white">${item.content }</font></td>
						</tr>
						<tr>
							<td bgcolor="#FFFFFF">${item.date}</td>
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