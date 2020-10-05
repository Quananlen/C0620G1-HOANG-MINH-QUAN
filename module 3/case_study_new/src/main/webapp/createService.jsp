<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/5/2020
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="/ServiceServlet" method="post">
        <input type="hidden" name="action" value="create">
        <div class="form-group">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="ID">
            <div style="color: red">${messageId}</div>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="name">
        </div>
        <div class="form-group">
            <label for="area">Area</label>
            <input type="text" class="form-control" id="area" name="area" placeholder="area">
        </div>
        <div class="form-group">
            <label for="floor">Floor</label>
            <input type="text" class="form-control" id="floor" name="floor" placeholder="floor">
        </div>
        <div class="form-group">
            <label for="maxAmount">Max Amount</label>
            <input type="text" class="form-control" id="maxAmount" name="maxAmount" placeholder="max amount">
        </div>
        <div class="form-group">
            <label for="rentCost">rent cost</label>
            <input type="text" class="form-control" id="rentCost" name="rentCost" placeholder="rent cost">
        </div>
        <div class="form-group">
            <label for="serviceTypeId">Service Type</label>
            <select name="serviceTypeId" id="serviceTypeId">
                <option value="1">Villa</option>
                <option value="2">House</option>
                <option value="3">Room</option>
            </select>
        </div>
        <div class="form-group">
            <label for="rentTypeId">Rent Type</label>
            <select name="rentTypeId" id="rentTypeId">
                <option value="1">Year</option>
                <option value="2">Month</option>
                <option value="3">Day</option>
                <option value="4">Hour</option>
            </select>
        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <input type="text" class="form-control" id="status" name="status" placeholder="status">
        </div>
        <input type="submit" value="Create">
    </form>
</div>
</body>
</html>
