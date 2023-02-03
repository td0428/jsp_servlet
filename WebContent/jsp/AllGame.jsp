<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>コネクトフォー</h2>
	<form action="<%=request.getContextPath()%>/Connect_Four" method="post">
		<input class="button" type="submit" value="ゲームスタート">
	</form>
	<br>
	<h2>おみくじ</h2>
	<form action="<%=request.getContextPath()%>/SampleServlet"
		method="post">
		<h2>名前を入力</h2>
		<input type="text" name="name" /> <input type="submit" value="送信">
	</form>
	<br>
	<h2>迷路</h2>
	<form action="<%=request.getContextPath()%>/Meiro" method="post"
		name="meiro">
		<h3>5以上の数値を入力してください（奇数のみ選択可能です。２１以上がおすすめ)</h3>
		<input type="text" name="math" id="meiro"> <input
			class="button" type="submit" value="ゲームスタート" onclick="return check()">
	</form>

	<!-- 続き -->
	<script>
		function check() {
			var num = document.getElementById('meiro').value;
			if (isNaN(num)) {
				alert("数値(奇数)を入力してください");
				return false;
			} else if (num < 5) {
				alert("5以上の奇数を入力してください");
				return false;
			} else if (num % 2 === 0) {
				alert("奇数を入力してください");
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>