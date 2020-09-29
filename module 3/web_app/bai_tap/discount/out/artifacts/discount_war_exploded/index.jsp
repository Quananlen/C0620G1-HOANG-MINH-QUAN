<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/25/2020
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Discount</title>
  </head>
  <body>
  <form action="/discount">
    <p>Product Description</p>
    <input type="text" name="description" value="">
    <p>List Price</p>
    <input type="text" name="price" value="">
    <p>Discount Percent</p>
    <input type="text" name="discount">
    <input type="submit" value="calculate">
  </form>
  </body>
</html>
