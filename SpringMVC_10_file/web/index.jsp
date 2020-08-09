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
  ${msg}
    <form action="/upload" method="post" enctype="multipart/form-data">
      用戶頭像:<input type="file" name="headerimg"/><br/>
      用戶頭像:<input type="file" name="headerimg"/><br/>
      用戶頭像:<input type="file" name="headerimg"/><br/>
      用戶頭像:<input type="file" name="headerimg"/><br/>
      用戶頭像:<input type="file" name="headerimg"/><br/>
      用戶名:<input type="text" name="username"/><br/>
      <input type="submit"/>
    </form>
    <br/>
    <br/>
    <a href="/download">download test</a>
  </body>
</html>
