<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/28/2020
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/product" method="post">
    <input type="hidden" name="action" value="update">
    <div class="form-group">
        <input type="hidden" class="form-control" id="id" name="id" placeholder="ID" value="${id}">
    </div>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="name">
    </div>
    <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <input type="text" class="form-control" id="manufacturer" name="manufacturer" placeholder="manufacturer">
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <input type="text" class="form-control" id="price" name="price" placeholder="price">
    </div>
    <input type="submit" value="Submit">
</form>
</body>
</html>
