<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/14/2020
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email validation</title>
</head>
<body>
<form action="/email/validate">
    <input type="text" name="email" value="${email}">
    <input type="submit">
    <div>${result}</div>
</form>
</body>
</html>
