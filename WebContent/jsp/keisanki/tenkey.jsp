<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/jsp/keisanki/css/style.css">
  </head>

  <body>
    <form action="<%= request.getContextPath() %>/Keisanki" method="post">
    <h2>数字を選択</h2>
      <div class="tenkey">
       <input id="seven" type="radio" value="7" name="ten"><label for="seven"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
       <input id="eight" type="radio" value="8" name="ten"><label for="eight"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
       <input id="nine" type="radio" value="9" name="ten"><label for="nine"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
      </div>
      <div class="tenkey">
       <input id="four" type="radio" value="4" name="ten"><label for="four"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
       <input id="five" type="radio" value="5" name="ten"><label for="five"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
       <input id="six" type="radio" value="6" name="ten"><label for="six"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>

      </div>
      <div class="tenkey">
       <input id="one" type="radio" value="1" name="ten"><label for="one"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
       <input id="two" type="radio" value="2" name="ten"><label for="two"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
       <input id="three" type="radio" value="3" name="ten"><label for="three"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>

      </div>
       <input id="zero" type="radio" value="0" name="ten"><label for="zero"><img src="<%=request.getContextPath() %>/image/test.jpg" with="40" height="40"></label>
      <input type="submit" value="送信">
    </form>
  </body>

  </html>