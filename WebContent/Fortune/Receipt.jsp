<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// Servletのデータ受け取り
request.setCharacterEncoding("UTF8");
String strName = (String) request.getAttribute("name");
String strFortune = (String) request.getAttribute("fortune");
int strCount = (int) request.getAttribute("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>運勢結果</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/Fortune/css/test.css">
</head>
<body>
	<h2>
		お名前は<%=strName%>さんですね
	</h2>
	<h3>
		あなたの運勢は<%=strFortune%>です。
	</h3>
	<h4><%=strCount%></h4>

	<form action="<%=request.getContextPath()%>/SampleServlet"
		method="post">
		<h2>名前を入力</h2>
		<input type="text" name="name" /> <input type="submit" value="送信">
	</form>
</body>
</html>