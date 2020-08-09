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
  <!--
    REST風格URL
    /book/1 GET     查詢
    /book/1 DELETE  刪除
    /book/1 PUT     更新
    /book   POST    增加

    支持PUT, DELETE請求?
    1. 配置SpringMVC的web.xml的filter
    2. 表單增加_method的參數
  -->
  <a href="book/1">查詢1號圖書</a><br>
  <form action="book/1" method="post">
    <input name="_method" value="delete"/>
    <input type="submit" value="刪除1號圖書"/>
  </form><br>
  <form action="book/1" method="post">
    <input name="_method" value="put"/>
    <input type="submit" value="更新1號圖書"/>
  </form><br>
  <form action="book" method="post">
    <input type="submit" value="增加1號圖書"/>
  </form><br>
  </body>
</html>
