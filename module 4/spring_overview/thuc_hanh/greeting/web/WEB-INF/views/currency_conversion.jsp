<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/13/2020
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<form action="/Convert">
<h2>Currency Conversion</h2>
    <p>USD: <input type="text" name="usd" value="${usdNew}"></p>
    <p>VND: <input type="text" name="vnd" value="${vndNew}"></p>
    <input type="submit" value="Convert">
    <input type="reset" value="Clear">
    <a href="greeting.jsp">Greeting</a>
</form>
</body>
</html>
