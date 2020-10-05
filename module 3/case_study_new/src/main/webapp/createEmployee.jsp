<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/5/2020
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Employee</title>
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
    <form action="/EmployeeServlet" method="post">
        <input type="hidden" name="action" value="create">
        <div class="form-group">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="ID">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="name">
        </div>
        <div class="form-group">
            <label for="positionId">Position</label>
            <select name="positionId" id="positionId">
                <option value="1">Director</option>
                <option value="2">Manager</option>
                <option value="3">Staff</option>
            </select>
        </div>
        <div class="form-group">
            <label for="educationId">Education</label>
            <select name="educationId" id="educationId">
                <option value="1">High school</option>
                <option value="2">College</option>
                <option value="3">University</option>
            </select>
        </div>
        <div class="form-group">
            <label for="departmentId">Department</label>
            <select name="departmentId" id="departmentId">
                <option value="1">Administration</option>
                <option value="2">Accounting</option>
                <option value="3">Sale</option>
            </select>
        </div>
        <div class="form-group">
            <label for="birthday">Birthday</label>
            <input type="text" class="form-control" id="birthday" name="birthday" placeholder="birthday">
        </div>
        <div class="form-group">
            <label for="idCard">ID Card</label>
            <input type="text" class="form-control" id="idCard" name="idCard" placeholder="idCard">
        </div>
        <div class="form-group">
            <label for="salary">Salary</label>
            <input type="text" class="form-control" id="salary" name="salary" placeholder="salary">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="phone">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="email">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="address">
        </div>
        <input type="submit" value="Create">
    </form>
</div>
</body>
</html>
