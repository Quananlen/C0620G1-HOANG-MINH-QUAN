<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 10/6/2020
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
<%--    bootstrap--%>
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
<%--    data tables--%>

</head>
<body>
<div class="container-fluid">
<%--    Logo - name--%>
    <div class="row">
        <div class="col-12 d-flex"><img src="images/Logo.JPG" alt="logo img">
            <div class="ml-auto align-middle">Hoàng Minh Quân</div>
        </div>
    </div>
<%--        Nav bar--%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Furama Resort</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/MainServlet">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown nav-link">
                        <span class="dropdown-toggle" id="dropdownMenuButtonEmployee"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Employee
                        </span>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonEmployee">
                        <a class="dropdown-item" href="">List Employee</a>
                        <a class="dropdown-item" href="/MainServlet?action=create">Create Employee</a>
                    </div>
                </li>
                <li class="nav-item dropdown nav-link">
                        <span class="dropdown-toggle" id="dropdownMenuButton"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Customer
                        </span>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="">List</a>
                        <a class="dropdown-item" href="/MainServlet?action=create">Create</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Contract</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
<%--    aside & body--%>
    <div class="row">
        <div class="col-3">Aside</div>
        <div class="col-9">

        </div>
    </div>
    <div class="row">
        <div class="col-12"></div>
    </div>
</div>
</body>
</html>
