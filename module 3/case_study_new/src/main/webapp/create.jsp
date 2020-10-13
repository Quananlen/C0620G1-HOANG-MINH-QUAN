<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/28/2020
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="col-4">
    <form action="/CustomerServlet" method="post">
        <input type="hidden" name="action" value="create">
       <%-- <c:forEach var="i" begin="0" end="${length-1}">
            <div class="form-group">
                <label for="${propertyList[i]}">${labelList[i]}</label>
                <input type="text" class="form-control" id="${propertyList[i]}" name="${propertyList[i]}"
                       placeholder="${labelList[i]}">

            </div>
        </c:forEach>--%>

          <div class="form-group">
              <label for="id">ID</label>
              <input type="text" class="form-control" id="id" name="id" placeholder="ID" value="${id}">
              <small style="color: red">${messageId}</small>
          </div>
          <div class="form-group">
              <label for="name">Name</label>
              <input type="text" class="form-control" id="name" name="name" placeholder="name" value="${name}">
          </div>
          <div class="form-group">
              <label for="birthday">Birthday</label>
              <input type="date" class="form-control" id="birthday" name="birthday" placeholder="birthday" value="${birthday}">
          </div>

        <div class="form-group">
            <label for="type">Type</label><br>
            <c:forEach var="customerType" items="${customerTypeList}">
                <div class="form-check form-check-inline" id="type">
                    <input class="form-check-input" type="radio" name="type" id="${customerType.getName()}"
                           value="${customerType.getId()}" ${customerType.getId()==type ? "checked" : ""}>
                    <label class="form-check-label" for="${customerType.getName()}">${customerType.getName()}</label>
                </div>
            </c:forEach>
        </div>

        <div class="form-group">
            <label for="idCard">ID Card</label>
            <input type="text" class="form-control" id="idCard" name="idCard" placeholder="Id Card" value="${idCard}">
            <small class="text-danger">${messageIdCard}</small>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="phone" value="${phone}">
            <small style="color: red">${messagePhone}</small>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="email" value="${email}">
            <small style="color: red">${messageEmail}</small>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="address" value="${address}">
            <small style="color: red">${messageAddress}</small>
        </div>

        <input type="submit" value="Create">
    </form>
</div>
</body>
</html>
