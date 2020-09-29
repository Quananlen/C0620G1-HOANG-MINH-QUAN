<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/24/2020
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Server Time</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/ServerTimeServlet">
    <button type="submit">Get Time</button>
  </form>
  <h1><%=request.getAttribute("today")%></h1>
  </body>
</html>
