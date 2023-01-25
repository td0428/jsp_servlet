<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConectFour</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/jsp/connect_four/css/style.css">

</head>
<body>
<!-- Connect_Fourから受け取った値を変数に入れる -->
	<% List<String> bord = (List<String>)request.getAttribute("bord");%>
	<%boolean NoStart = (boolean)request.getAttribute("NoStart");%>
	<%boolean end = (boolean)request.getAttribute("ColumnEnd"); %>
	<%int battle = (int)request.getAttribute("battle"); %>
	<%int finish1 = (int)request.getAttribute("finish1"); %>
	<%int finish2 = (int)request.getAttribute("finish2"); %>
	<%int finish3 = (int)request.getAttribute("finish3"); %>
	<%int finish4 = (int)request.getAttribute("finish4"); %> 
	<%int finish_count = 0; %>
	
	<!-- 配列を7つに区切って表示 -->
<div id="main">
<% for(int i = 0;i<6;i++){%>
	<div class="line">
	<%for(int j = 0;j<7;j++){%>
		<%if(finish_count == finish1 || finish_count == finish2 || finish_count == finish3 || finish_count == finish4){%>
			<div class="finish"><%=bord.get(0) %></div>
		<%}else{%>
			<div><%=bord.get(0) %></div>
		<%} %>
		<%finish_count++; %>
		<%bord.remove(0); %>
		
	<% }%>
	</div>
<% }%>
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

	<!-- ボタンを選択せずに決定を押した場合に文字を表示 -->
		<% if(NoStart){%>
	<div class="error">ボタンが選択されませんでした</div>
	<% }%>
	
	<!-- 列に置けなくなった場合に文字を表示 -->
	<% if(end){%>
	<div class="error">この列にはもう置けません</div>
	<% }%>
	
	
</body>
</html>