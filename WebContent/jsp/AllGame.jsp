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
		<h3>＊奇数のみ選択可能です(２１以上がおすすめ)</h3>
		<input type="text" name="math"> <input class="button"
			type="submit" value="ゲームスタート" onclick="return check()">
	</form>
	<script>
		function check() {
			if (meiro.math.value % 2 === 0) {
				alert("偶数が選択されています");
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>