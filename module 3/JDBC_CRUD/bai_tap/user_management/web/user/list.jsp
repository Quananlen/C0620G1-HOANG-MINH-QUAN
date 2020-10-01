<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/29/2020
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<table class="table">
    <thead>
    <tr class="bg-dark text-white">
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Gender</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <th scope="row">${user.id}</th>
            <td>${user.name}</td>
            <td>${user.birthday}</td>
            <td><c:choose>
                <c:when test="${user.gender == 1}">Male</c:when>
                <c:when test="${user.gender == 0}">Female</c:when>
                <c:otherwise>Apache Helicopter</c:otherwise>
            </c:choose></td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td><a href="/UserServlet?action=edit&id=${user.id}"><i class="material-icons">&#xE254;</i></a></td>
            <td><a href="/UserServlet?action=delete&id=${user.id}"><i class="material-icons">&#xE872;</i></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="">
    <input type="hidden" name="action" value="create">
    <button type="submit" value="create"><span class="material-icons">add</span></button>
</form>
<form action="">
    <input type="hidden" name="action" value="searchByAddress">
    <label>Search by name
        <input type="text" name="address">
    </label>
    <button type="submit" value="searchByAddress"><span class="material-icons">search</span></button>
</form>
<form action="">
    <input type="hidden" name="action" value="searchByID">
    <label>Search by ID
        <input type="text" name="id">
    </label>
    <button type="submit" value="searchByID"><span class="material-icons">search</span></button>
</form>
<form action="">
    <input type="hidden" name="action" value="sort">
    <button type="submit" value="sort"><span class="material-icons">sort_by_alpha</span></button>
</form>
</body>
</html>
