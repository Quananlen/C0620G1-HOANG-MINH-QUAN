<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/13/2020
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/Dictionary">
    <input type="text" name="word">
    <input type="submit" value="look up">
    <div>${result}</div>
</form>
</body>
</html>
