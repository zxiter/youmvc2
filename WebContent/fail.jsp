<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2015/7/20
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
失败
<%
  out.print(request.getAttribute("message"));
%>
</body>
</html>
