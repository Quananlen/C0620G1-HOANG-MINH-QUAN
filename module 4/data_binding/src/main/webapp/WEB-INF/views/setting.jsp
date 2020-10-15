<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<form:form action="/setting/update" modelAttribute="setting">
    <h1>Settings</h1>
    <div>
        <form:label path="language">Languages</form:label>
        <form:select id="language" path="language">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
        </form:select>
    </div>
    <div>
    <form:label path="pageSize">Page Size</form:label>
    <form:select path="pageSize" id="pageSize">
        <form:option value="10">10</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
    </form:select>
    </div>
    <div>
    <form:label path="spamFilter">Spam Filter</form:label>
    <form:checkbox id="spamFilter" path="spamFilter" value="Enable spams filter"/>
    </div>
    <div>
    <label for="signature">Signature</label>
    <form:textarea id="signature" path="signature"/>
    </div>
    <input type="submit" value="Update">
</form:form>

</body>
</html>
