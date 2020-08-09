<%--
  Created by IntelliJ IDEA.
  User: XXXX
  Date: 2020/2/15
  Time: 上午 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>員工添加</h1>

<%--    <!-- 1. Default -->--%>
<%--    <!-- Employee -->--%>
<%--    <form action="">--%>
<%--        lastName:<input name="lastName" type="text"/><br/>--%>
<%--        email:<input name="email" type="text"/><br/>--%>
<%--        gender:<br/>--%>
<%--        男：<input type="radio" name="gender" value="1"/><br/>--%>
<%--        女：<input type="radio" name="gender" value="0"/><br/>--%>
<%--        dept:--%>
<%--        <select name="department.id">--%>
<%--            <c:forEach items="${depts }" var="deptItem">--%>
<%--                <!-- 標籤體中是在頁面提示選項的信息，value才是提交的值 -->--%>
<%--                <option value="${deptItem.id }">${deptItem.departmentName }</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--        <input type="submit" value="提交"/>--%>
<%--    </form>--%>


    <!-- 2. MVC Form -->
    <!-- 表單標籤 -->
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
    <form:form action="${ctp}/emp"  modelAttribute="employee"  method="POST">
        <!-- path:就是html-input的name
        （1）  當做原生的name項
        （2）自動回顯隱含模型中某個對象對應的屬性值-->
        lastName:<form:input path="lastName"/><br/>
        email:<form:input path="email"/><br/>
        gender:<br/>
        男:<form:radiobutton path="gender" value="1"/><br/>
        女:<form:radiobutton path="gender" value="0"/><br/>
        <!-- items：指定要遍歷的集合 ，自動遍歷,遍歷出的每一個元素是一個department對像
        itemLable="屬性名" :指定遍歷出的這個對象的哪個屬性時作為option標籤體的值
        itemValue="屬性名":指定遍歷出的這個對象的哪個屬性作為提交的值

        -->

        dept:<form:select path="department.id" items="${depts }" itemLabel="departmentName" itemValue="id">
        <br/>
    </form:select><br/>
        <input type="submit" value="保存"/>
    </form:form>


</body>
</html>
