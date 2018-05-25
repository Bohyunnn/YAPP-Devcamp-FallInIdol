<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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


#selectable_star   {
	float: left;
	list-style: none;
	margin: 0px;
	padding: 0px;
	max-width: 900px;
	width: 100%;
	text-transform: uppercase;
}
#selectable_lang  {
	float: left;
	list-style: none;
	margin: 0px;
	padding: 0px;
	max-width: 900px;
	width: 100%;
	text-transform: uppercase;
}

#selectable_star li  {
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
#selectable_lang li  {
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

#selectable_star .ui-selecting{ background: #0d6dff; }
#selectable_lang .ui-selecting { background: #0d6dff; }
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
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
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
          my_param[1] = $(this).html();
      });
      
    });
  } );
  
  $(document).ready(function() {
	  $("#btnOk").click(function() {
		  console.log(my_param);
		  if (my_param[0] == null) {
			  alert("ìíë ì¤íë¥¼ ì íí´ì£¼ì¸ì");
		  }
		  else if (my_param[1] == null) {
			  alert("ìíë ì¸ì´ë¥¼ ì íí´ì£¼ì¸ì");
		  }
		  else {
			  $("#choice").attr('value', my_param[0]);
			  $("#language").attr('value' , my_param[1]);
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
  });
  </script>
</head>
<body id="myPage">
	<!-- Image Header -->
	<div style='position: absolute; left: 58%; top: 22%;'>
		<div style='position: absolute; width: 800px; left: -360px;'>
			<img src="/resources/../img/logo-b.png" alt="boat"
				style="width: 360px;">
		</div>
	</div>
	<div style='position: absolute; left: 63%; top: 40%;'>
		<div style='position: absolute; width: 800px; left: -400px;'>
			<img src="/resources/../img/info.png" style="width: 300px;"/>
		</div>
	</div>
	
	<!-- Team Container -->
	<form name="f" action="/create-user" method="POST">
			<div style='position: absolute; left: 63%; top: 44%;'>
				<input type="hidden" name="choice" id="choice" />
				<input type="hidden" name="language" id="language"/>
	
				<div style='position: absolute; width:150px; left: -400px;'>
					
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
			<div style='position: absolute; width: 150px; left: -200px;'>
				
				<button class="dropbtn">
								<font color="#707070">LANGUAGE</font>
							</button>
				<ol id="selectable_lang">
						
						<li class="ui-widget-content" id="ko" value="ko">한국어</li>
						<li class="ui-widget-content" id="en" value="en">ENGLISH</li>
						<li class="ui-widget-content" id="ja" value="ja">日本語</li>
						<li class="ui-widget-content" id="zh" value="zh">简体中文</li>		
						<li class="ui-widget-content" id="zh-TW" value="zh-TW">繁體中文</li>
						<li class="ui-widget-content" id="th" value="th">ภาษาไทย</li>
						<li class="ui-widget-content" id="ru" value="ru">русский</li>
						
						
				</ol>
			</div>
		</div>
		<div style='position: absolute; left: 58%; top: 88%;'>
			<div style='position: absolute; width: 800px; left: -320px;'>
				<img src="/resources/../img/letgo.png" 
					id = "btnOk"
					style="width: 245px; height: 31px" >
			</div>
		</div>
	</form>


</body>
</html>

