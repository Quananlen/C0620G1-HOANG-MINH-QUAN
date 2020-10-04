<%@ page import="model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/28/2020
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
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
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${customer.getId()}">
        <div class="form-group">
            <label for="newId">ID</label>
            <input type="text" class="form-control" id="newId" name="newId" placeholder="ID" value="${customer.getId()}">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="name"
                   value="${customer.getName()}">
        </div>
        <div class="form-group">
            <label for="birthday">Birthday</label>
            <input type="text" class="form-control" id="birthday" name="birthday" placeholder="birthday"
                   value="${customer.getBirthday()}">
        </div>
        <div class="form-group">
            <label for="type">Type</label><br>
            <div class="form-check form-check-inline" id="type">
                <input class="form-check-input" type="radio" name="type" id="diamond"
                       value="1" ${customer.getCustomerType()=="1" ? "checked" : ""}>
                <label class="form-check-label" for="diamond">Diamond</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="type" id="platinum" value="2"
                       value="1" ${customer.getCustomerType()=="2" ? "checked" : ""}>
                <label class="form-check-label" for="platinum">Platinum</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="type" id="gold" value="3"
                       value="1" ${customer.getCustomerType()=="3" ? "checked" : ""}>
                <label class="form-check-label" for="gold">Gold</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="type" id="silver" value="4"
                       value="1" ${customer.getCustomerType()=="4" ? "checked" : ""}>
                <label class="form-check-label" for="silver">Silver</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="type" id="normal" value="5"
                       value="1" ${customer.getCustomerType()=="5" ? "checked" : ""}>
                <label class="form-check-label" for="normal">Normal</label>
            </div>
        </div>
        <div class="form-group">
            <label for="idCard">ID Card</label>
            <input type="text" class="form-control" id="idCard" name="idCard" placeholder="idCard"
                   value="${customer.getIdCard()}">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="phone"
                   value="${customer.getPhone()}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="email"
                   value="${customer.getEmail()}">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="address"
                   value="${customer.getAddress()}">
        </div>
        <input type="submit" value="Edit">
    </form>
</div>
</body>
</html>
