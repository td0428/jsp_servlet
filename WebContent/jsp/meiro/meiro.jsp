<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>迷路</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/jsp/meiro/css/style.css">
</head>
<body>
	<%
	String[][] bord = (String[][])request.getAttribute("bord");
	int math = (int)request.getAttribute("math");
	%>


<% for(int i = 0;i<math;i++){%>
	<div class="line">
	<%for(int j = 0;j<math;j++){%>
			<div><%=bord[i][j] %></div>
	<% }%>
	</div>
<% }%>

</body>
</html>