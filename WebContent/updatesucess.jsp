<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2015/7/21
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
成功
<%
  out.print(request.getAttribute("message"));
%>
</body>
</html>
