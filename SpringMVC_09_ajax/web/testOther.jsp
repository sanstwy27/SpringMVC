<%--
  Created by IntelliJ IDEA.
  User: XXXX
  Date: 2020/2/15
  Time: 下午 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
    <script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
<form action="${ctp}/test02" method="post" enctype="multipart/form-data">
    <input name="username" value="XXXXX"/>
    <input name="password" value="XXXXX"/>
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
<a href="${ctp}/testRequestBody">ajax發送json數據</a>
</body>
<script type="text/javascript">
    $("a:first").click(function(){
        var emp = {lastName:"張三", email:"123@123.com", gender: 0};
        var empStr = JSON.stringify(emp);
        $.ajax({
            url: '${ctp}/testRequestBody',
            type: "POST",
            data: empStr,
            contentType: 'application/json',
            success: function (data) {
                console.log(data);
            }
        });

        return false;
    });
</script>
</html>
