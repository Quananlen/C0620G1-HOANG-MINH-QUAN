<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/14/2020
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action="/sandwich/condiments">
<h2>Sandwich Condiments</h2>
    <input type="checkbox" id="lettuce" value="lettuce" name="condiments">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" id="tomato" value="tomato" name="condiments">
    <label for="tomato">Tomato</label>
    <input type="checkbox" id="mustard" value="mustard" name="condiments">
    <label for="mustard">Mustard</label>
    <input type="checkbox" id="sprouts" value="sprouts" name="condiments">
    <label for="sprouts">Sprouts</label>
    <input type="submit" value="Save">
</form>
<div>${result}</div>
</body>
</html>
