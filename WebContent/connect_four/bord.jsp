<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConectFour</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/connect_four/css/style.css">

</head>
<body>
<!-- Connect_Fourから受け取った値を変数に入れる -->
	<%boolean NoStart = (boolean)request.getAttribute("NoStart");%>
	<%boolean end = (boolean)request.getAttribute("ColumnEnd"); %>
	<%int battle = (int)request.getAttribute("battle"); %>
	<% List<String> bord = (List<String>)request.getAttribute("bord");
	int a = 0;%>
	
	<!-- ボタンを選択せずに決定を押した場合に文字を表示 -->
		<% if(NoStart){%>
	<div class="error">ボタンが選択されませんでした</div>
	<% }%>
	
	<!-- 列に置けなくなった場合に文字を表示 -->
	<% if(end){%>
	<div class="error">この列にはもう置けません</div>
	<% }%>
	
	<!-- 配列を7つに区切って表示 -->
<div id="main">
	<% for(String str: bord) {
		if(a%7 ==0){%>
			<br>
		<% }%>
		<%=str %>
		<%a++; 
	} %>
</div>

<!-- 勝敗がついていなければ続き、勝敗がつけば勝ちを表示 -->
<%if(battle == 0){%>
	<form action="<%=request.getContextPath()%>/Connect_Four" method="post">
		<input class="select" type="radio" name="radiobutton" value="0">
		<input class="select" type="radio" name="radiobutton" value="1">
		<input class="select" type="radio" name="radiobutton" value="2">
		<input class="select" type="radio" name="radiobutton" value="3">
		<input class="select" type="radio" name="radiobutton" value="4">
		<input class="select" type="radio" name="radiobutton" value="5">
		<input class="select" type="radio" name="radiobutton" value="6">
		<br>
		<input class="button" type="submit" value=決定>
	</form>
<%}else if(battle == 1){%>
	<div class="finsh">◯の勝ち</div>
<%}else{%>
	<div class="finsh">×の勝ち</div>
<%} %>
	
	
</body>
</html>