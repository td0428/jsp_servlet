<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>運勢占い</title>
</head>
<body>
  <form action="<%= request.getContextPath() %>/SampleServlet" method="post">
  <h2>名前を入力</h2>
  <input type="text" name="name" />
  <input type="submit" value="送信">
  </form>
</body>
</html>