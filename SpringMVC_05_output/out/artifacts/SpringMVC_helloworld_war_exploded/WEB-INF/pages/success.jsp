<%--
  Created by IntelliJ IDEA.
  User: XXXX
  Date: 2020/2/14
  Time: 下午 04:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>success</h1>
pageContext: ${pageScope.msg}<br/>
request: ${requestScope.msg}<br/>
session: ${sessionScope.msg}-${sessionScope.haha}<br/>
application: ${applicationScope.msg}<br/>
</body>
</html>
