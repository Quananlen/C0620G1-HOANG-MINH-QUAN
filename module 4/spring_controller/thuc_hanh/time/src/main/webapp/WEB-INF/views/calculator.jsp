<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/14/2020
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form>
    <p>Num 1 <input type="text" name="num1"></p>
    <p>Num 2 <input type="text" name="num2"></p>
    <input type="submit" formaction="/calculator/addition" value="Addition(+)">
    <input type="submit" formaction="/calculator/subtraction" value="Subtraction(-)">
    <input type="submit" formaction="/calculator/multiplication" value="Multiplication(*)">
    <input type="submit" formaction="/calculator/division" value="Division(/)">
    <div>${result}</div>
</form>
</body>
</html>
