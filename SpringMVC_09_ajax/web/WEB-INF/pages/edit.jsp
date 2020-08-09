<%--
  Created by IntelliJ IDEA.
  User: XXXX
  Date: 2020/2/15
  Time: 下午 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
    <h1>員工修改頁面</h1>
    <!-- modelAttribute:這個表單的所有內容顯示綁定的是請求域中的employee -->
    <form:form action="${ctp }/emp/${employee.id }"  modelAttribute="employee" method="post">
        <input type="hidden" name="_method" value="put"/>
        <input type="hidden" name="id" value="${employee.id}"/>
        email:<form:input path="email"/><br/>
        gender:&nbsp;&nbsp;&nbsp;
            男:<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
            女:<form:radiobutton path="gender" value="0"/><br/>
        birth:<form:input path="birth"/><br/>
        dept:
            <form:select path="department.id" items="${depts }" itemLabel="departmentName" itemValue="id">
        <br/>
    </form:select><br/>
        <input type="submit" value="修改"/>
    </form:form>
</body>
</html>
