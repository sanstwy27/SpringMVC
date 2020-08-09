<%--
  Created by IntelliJ IDEA.
  User: XXXX
  Date: 2020/2/15
  Time: 上午 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
    <h1>員工列表</h1>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>lastName</th>
            <th>email</th>
            <th>gender</th>
            <th>departmentName</th>
            <th>EDIT</th>
            <th>DELETE</th>
        </tr>
        <c:forEach items="${emps }" var="emp">
            <tr>
                <td>${emp.id }</td>
                <td>${emp.lastName }</td>
                <td>${emp.email }</td>
                <td>${emp.gender==0?"女":"男"}</td>
                <td>${emp.department.departmentName }</td>
                <td><a href="${ctp }/emp/${emp.id}">edit</a></td>
                <td><a href="${ctp }/emp/${emp.id}" class="delBtn">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="toaddpage">添加員工</a>

    <form id="deleteForm" action="${ctp }/emp/${emp.id }" method="post">
        <input type="hidden" name="_method" value="delete" />
    </form>
    <script type="text/javascript">
        $(function(){
            $(".delBtn").click(function(){
                //1.改變表單的action指向
                $("#deleteForm").attr("action",this.href);
                //2.提交表單
                $("#deleteForm").submit();
                return false;
            });
        });
    </script>
</body>
</html>
