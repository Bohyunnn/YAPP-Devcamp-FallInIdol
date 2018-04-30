<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>btsPhoto</title>
</head>
<body>
<!-- <table border = "1"> -->
<c:forEach items="${list}" var="item" varStatus="status" begin="0" end="25" >
	${item.getUrl()}<img src="${item.getUrl()}" style="max-width: 100%;width: 600px; padding:3px" class="w3-hover-opacity" alt="${item}" onError="this.style.display='none'">
</c:forEach>
<%-- <c:forEach var="data" items="${list}">

				<tr>

					<td>${data.url}</td>

				</tr>

			</c:forEach>			
</table> --%>
</body>
</html>