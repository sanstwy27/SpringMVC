<%--
  Created by IntelliJ IDEA.
  User: XXXX
  Date: 2020/2/14
  Time: 上午 01:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/hello">hello</a><br/>
  <a href="/handle01">handle01</a><br/>
  <a href="/handle02">handle02</a><br/>
  <a href="/handle03">handle03</a><br/>
  <a href="/handle04">handle04</a><br/>
  <h1>修改圖書-不能修改書名:</h1>
  <form action="/updateBook" method="post">
    <input type="hidden" name="id" value="100"/>
    書名: 西遊記<br/>
    作者:<input type="text" name="author"/><br/>
    價格:<input type="text" name="price"/><br/>
    庫存:<input type="text" name="stock"/><br/>
    銷量:<input type="text" name="sales"/><br/>
    <input type="submit" value="修改圖書"/><br/>
  </form>
  </body>
</html>
