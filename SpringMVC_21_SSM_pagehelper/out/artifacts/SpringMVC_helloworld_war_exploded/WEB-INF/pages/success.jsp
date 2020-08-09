<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XXXX
  Date: 2020/2/17
  Time: 下午 05:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>success</h1>
<table cellpadding="5" cellspacing="0" border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>course</th>
        <th>address</th>
    </tr>
    <c:forEach items="${info.list}" var="tea">
        <tr>
            <td>${tea.id}</td>
            <td>${tea.name}</td>
            <td>${tea.course}</td>
            <td>${tea.address}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            <a href="/getall?pn=1">首頁</a>
            <a href="/getall?pn=${info.prePage}">上一頁</a>
            <c:forEach items="${info.navigatepageNums}" var="num">
                <c:choose>
                    <c:when test="${num == info.pageNum}">
                        ${num}
                    </c:when>
                    <c:otherwise>
                        <a href="/getall?pn=${num}">${num}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <a href="/getall?pn=${info.nextPage}">下一頁</a>
            <a href="/getall?pn=${info.pages}">最末頁</a>
        </td>
    </tr>
</table>
</body>
</html>
