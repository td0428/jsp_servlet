<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connect_Four</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/connect_four/css/style.css">
</head>

<body>
	<form action="<%=request.getContextPath()%>/Connect_Four" method="post">
		<input class="button" type="submit" value="開始">
	</form>
</body>
</html>