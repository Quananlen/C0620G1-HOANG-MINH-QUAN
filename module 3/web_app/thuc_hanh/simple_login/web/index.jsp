<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/24/2020
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    .login {
        height:180px; width:230px;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
    }
    .login input {
        padding:5px; margin:5px
    }
</style>
<body>
<form action="/LoginServlet" method="post">
    <div class="login">
        <h2>Login</h2>
        <input type="text" name="username" size="30"  placeholder="username" />
        <input type="password" name="password" size="30" placeholder="password" />
        <input type="submit" value="Sign in"/>
    </div>
</form>
<h1><%=request.getAttribute("result")%></h1>
</body>
</html>