<%@ page import="java.util.Date" %>
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
    <%
      pageContext.setAttribute("ctp", request.getContextPath());
    %>
    <script src="/webjars/jquery/jquery.min.js"></script>
  </head>
  <body>
    <%= new Date() %>
    <a href="${ctp}/getallajax">ajax查詢所有員工列表</a><br/>
    <div>

    </div>
    <script type="text/javascript">
      $("a:first").click(function () {
        $.ajax({
          url: "${ctp}/getallajax",
          type: "GET",
          success: function(data) {
            //console.log(data);
            $.each(data, function(){
              var empInfo = this.lastName + "-->" + this.birth + "-->" + this.gender;
              $("div").append(empInfo + "<br/>");
            })
          }
        });

        return false;
      });
    </script>
  </body>
</html>
