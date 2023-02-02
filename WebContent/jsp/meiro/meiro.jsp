<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>迷路</title>
</head>
<body>
	<%
	String[][] bord = (String[][])request.getAttribute("bord");
	int math = (int)request.getAttribute("math");
	%>

	<%
	int count = 0;
	for (String[] a : bord) {
		for(String b : a){
			if (count % math == 0) {%>
				<br> 
			<%} %>
		<%=b %>
		<%count++;
		}
	}
	 %>
</body>
</html>