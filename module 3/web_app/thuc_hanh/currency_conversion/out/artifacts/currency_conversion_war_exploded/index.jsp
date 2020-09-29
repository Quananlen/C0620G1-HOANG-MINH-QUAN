<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/25/2020
  Time: 8:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Conversion</title>
  </head>
  <body>
  <h2>Currency Converter</h2>
  <form action="/CurrencyConversionServlet" method="post">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/>
    <p><%=request.getAttribute("vnd")%></p>
    <br/>
    <input type = "submit" id = "submit" value = "Converter"/>
  </form>
  </body>
</html>
