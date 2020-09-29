<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/25/2020
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<p>Product name: <%=request.getAttribute("product")%></p>
<p>Price: <%=request.getAttribute("price")%></p>
<p>Discount <%=request.getAttribute("discount")%></p>
<p>Discount Amount <%=request.getAttribute("discountAmount")%></p>
<p>Discount Price <%=request.getAttribute("discountPrice")%></p>
</body>
</html>
