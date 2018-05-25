<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>LookingForStar</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<style type="text/css">
.dropbtn {
	background-color: #FFFFFF;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

#selectable_star {
	float: left;
	list-style: none;
	margin: 0px;
	padding: 0px;
	max-width: 900px;
	width: 100%;
	text-transform: uppercase;
}

#selectable_lang {
	float: left;
	list-style: none;
	margin: 0px;
	padding: 0px;
	max-width: 900px;
	width: 100%;
	text-transform: uppercase;
}

#selectable_star li {
	list-style: none;
	margin: 2px;
	display: block;
	width: 150px;
	height: 40px;
	background: #ffffff;
	color: #000000;
	border: none;
	font-size: 12px;
	font-weight: bold;
	/*text-align: center;*/
	padding-top: 10px;
	text-decoration: none;
}

#selectable_lang li {
	list-style: none;
	margin: 2px;
	display: block;
	width: 150px;
	height: 40px;
	background: #ffffff;
	color: #000000;
	border: none;
	font-size: 12px;
	font-weight: bold;
	/*text-align: center;*/
	padding-top: 10px;
	text-decoration: none;
}

/* #selectable li  a:hover {
	background: #e7e7e7;
	text-decoration: none;
} */
#selectable_star .ui-selecting {
	background: #0d6dff;
}

#selectable_lang .ui-selecting {
	background: #0d6dff;
}

#selectable_star .ui-selected {
	background: #0d6dff;
	color: white;
}

#selectable_lang .ui-selected {
	background: #0d6dff;
	color: white;
}
/*#bts:hover {
    background-color: #e7e7e7;
}
#redvelvet:hover {
    background-color: #e7e7e7;
}*/
#item:hover {
	background-color: #e7e7e7;
}
/* Change the background color of the dropdown button when the dropdown content is shown */
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"
	type="text/javascript"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var my_param = [];
  $( function() {
    $( "#selectable_star" ).selectable()
    .on("selectablestop", function() {
      $('#selectable_star .ui-selected').each(function() {
        my_param[0] = $(this).html().toLowerCase();
      });
    });
  } );
  $( function() {
    $( "#selectable_lang" ).selectable()
    .on("selectablestop", function() {
      $('#selectable_lang .ui-selected').each(function() {
        my_param[1] = $(this).html().toLowerCase();
      });
      
    });
  } );
  
  $(function() {
	  console.log(my_param);
	  if (my_param[0] != null && my_param[1] != null ) {
		  $("#btnOk").removeAttr("disabled");
		  $("#btnOk").css("background-color", "#0d6dff");
	  }
  });

  $("#btnOk").click(function() {
		  console.log(my_param);
		  if (my_param[0] == null) {
			  alert("원하는 스타를 선택해주세요");
			  
		  }
		  else if (my_param[1] == null) {
			  alert("원하는 언어를 선택해주세요");
			  
		  }
		  else {
			  
			  $("#choice").attr('value', my_param[0]);
			  $("#lang").attr('value' , my_param[1]);
			  
			  $("form").submit();
		  }
		  
	  	/* $.ajaxSettings.traditional = true;
	  	$.ajax({
	  		url : "/home",
	  		type: "POST",
	  		data:  { choice:my_param[0], lang:my_param[1] },
	  		dataType: "json",
	  		contentType: "application/json; charset=utf-8",
	  		success:function() {
	  			
	  			window.location.href="http://localhost:8080/home"
	  		},
	  		fail:function() {
	  			window.location.href="http://localhost:8080/home"
	  		}
	  	}); */
	  });
  </script>
</head>
<body id="myPage">
	<!-- Image Header -->
	<div style='position: absolute; left: 60%; top: 30%;'>
		<div style='position: absolute; width: 800px; left: -360px;'>
			<img src="/resources/../img/logo-b.png" alt="boat"
				style="width: 360px;">
		</div>
	</div>
	<div style='position: absolute; left: 65%; top: 50%;'>
		<div style='position: absolute; width: 800px; left: -400px;'>
			<img src="/resources/../img/info.png" style="width: 300px;" alt="" />
		</div>
	</div>
	<!-- Team Container -->
	<form name="f" action="/home" method="POST">
		<div style='position: absolute; left: 65%; top: 55%;'>
			<input type="hidden" name="choice" id="choice" /> <input
				type="hidden" name="lang" id="lang" />

			<div style='position: absolute; width: 400px; left: -400px;'>

				<button class="dropbtn">
					<font color="#707070">STAR</font>
				</button>
				<ol id="selectable_star">
					<li class="ui-widget-content" id="item" value="bts">BTS</li>
					<li class="ui-widget-content" id="item" value="redvelvet">REDVELVET</li>
					<li class="ui-widget-content" id="item" value="exo">EXO</li>
					<li class="ui-widget-content" id="item" value="twice">TWICE</li>
				</ol>
			</div>
			<div style='position: absolute; width: 400px; left: -200px;'>

				<button class="dropbtn">
					<font color="#707070">LANGUAGE</font>
				</button>
				<ol id="selectable_lang">
					<li class="ui-widget-content" id="item" value="eng">English</li>
					<li class="ui-widget-content" id="item" value="china1">繁體中文</li>
					<li class="ui-widget-content" id="item" value="china2">简体中文</li>
					<li class="ui-widget-content" id="item" value="japan">日本語</li>
				</ol>
			</div>
		</div>
		<div style='position: absolute; left: 60%; top: 85%;'>
			<div style='position: absolute; width: 800px; left: -320px;'>
				<!-- <img src="/resources/../img/letgo.png" 
					id = "btnOk"
					style="width: 245px; height: 31px" > -->
				<Button id="btnOk"
					style="background-color: #e7e7e7; width: 245px; height: 31px;">
					<font color="white">Let's Go</font>
				</Button>
			</div>
		</div>
	</form>


</body>
</html>

