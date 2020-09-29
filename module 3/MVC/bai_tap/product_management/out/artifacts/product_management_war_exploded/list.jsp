<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/28/2020
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

</head>
<body>
<table class="table">
    <thead>
    <tr class="bg-dark text-white">
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Manufacturer</th>
        <th scope="col">Price</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="product">
    <tr>
        <th scope="row">${product.id}</></th>
        <td>${product.name}</td>
        <td>${product.manufacturer}</td>
        <td>${product.price}</td>
        <td><a href="/product?action=update&id=${product.id}"><i class="material-icons">&#xE254;</i></a></td>
        <td><a href="/product?action=delete&id=${product.id}"><i class="material-icons">&#xE872;</i></a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<form action="">
    <input type="hidden" name="action" value="create">
    <button type="submit" value="create"><span class="material-icons">add</span></button>
</form>
<form action="">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name"><button type="submit" value="search"><span class="material-icons">search</span></button>
</form>
<div>
    <c:if test="${result != null}">
        <div>ID: ${result.id}</></div>
        <div>Name: ${result.name}</div>
        <div>Manufacturer: ${result.manufacturer}</div>
        <div>Price: ${result.price}</div>
    </c:if>
    <c:if test="${result == null}">
        <p>No result</p>
    </c:if>
</div>
</body>
</html>
