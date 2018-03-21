<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1>youtube 검색 결과</h1>

	<c:forEach items="${result}" var="item">
		<iframe width="640" height="360" src="${item.url}" frameborder="0"
			allow="autoplay; encrypted-media" allowfullscreen></iframe>
		<br />
	</c:forEach>

</body>
</html>