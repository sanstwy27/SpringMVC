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
  <a href="/hello">hello</a><br>
  <a href="/handle01?username=tomcat">handle01</a>
  <form action="book" method="post">
    書名:<input type="text" name="bookName"/><br/>
    作者:<input type="text" name="author"/><br/>
    價格:<input type="text" name="price"/><br/>
    庫存:<input type="text" name="stock"/><br/>
    銷量:<input type="text" name="sales"/><br/>
    <hr/>
    省:<input type="text" name="address.province"/><br/>
    市:<input type="text" name="address.city"/><br/>
    街道:<input type="text" name="address.street"/><br/>
    <input type="submit"/>
  </form>
  </body>
</html>
