<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Display</title>
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
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js"></script>

    <style>
        body {
            background-image: url('images/resort-bg.jpg');
            background-size: 100% 100%;
        }

        #table-container {
            padding: 50px;
            margin: 50px;
            opacity: 0.9;
        }
    </style>

</head>
<body>
<div class="container-fluid">
    <%--    Logo - name--%>

    <div class="row">
        <div class="col-12 d-flex"><img src="images/Logo.JPG" alt="logo img" class="rounded-circle">
            <div class="ml-auto align-middle">Hoàng Minh Quân</div>
        </div>
    </div>

    <%--        Nav bar--%>

    <nav class="navbar navbar-expand-lg navbar-light bg-light row">
        <a class="navbar-brand" href="#">Product Management</a>
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
                        <span class="dropdown-toggle" id="dropdownMenuButton"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Product
                        </span>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="">List</a>
                        <a class="dropdown-item" href="/MainServlet?action=create">Create</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <%--        Nav bar Search--%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light row">
        <form action="/MainServlet">
            <input type="hidden" name="action" value="findName">
            <label for="findName"></label> Find by Name
            <input type="text" id="findName" name="findName"><input type="submit" value="Search">
        </form>
        <form action="/MainServlet">
            <input type="hidden" name="action" value="findPrice">
            <label for="findPrice"></label> Find by Price
            <input type="text" id="findPrice" name="findPrice"><input type="submit" value="Search">
        </form>
    </nav>
    <%--    aside & body--%>
    <div class="row">
        <div class="col-12">
            <div id="table-container" class="bg-white">
                <table class="table table-striped" id="customers">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Color</th>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${productList}">
                        <tr>
                            <th scope="row" id="id-${product.name}">${product.name}</th>
                            <td>${product.price}</td>
                            <td>${product.quantity}</td>
                            <td>${product.color}</td>
                            <td>${product.description}</td>
                            <td>${product.category}</td>
                            <td><a href="/MainServlet?action=edit&id=">
                                <i class="material-icons">&#xE254;</i></a></td>
                            <td><a href="" data-toggle="modal"
                                   data-target="#deleteModal"
                                   onclick="setValue('id-${product.name}', 'hiddenName')">
                                <i class="material-icons">&#xE872;</i></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <%--                Edit modal--%>

            <!-- Modal -->
            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
                 aria-labelledby="deleteModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Delete product</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <%--                        Form modal--%>
                        <form action="/MainServlet">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" id="hiddenName" name="hiddenName">
                            <div class="modal-body">
                                <p>Are you sure</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    function setInnerText(idStart, idDest) {
        document.getElementById(idDest).innerText = document.getElementById(idStart).innerText;
    }

    function setValue(idStart, idDest) {
        document.getElementById(idDest).value = document.getElementById(idStart).innerText;
    }

    $(document).ready(function () {
        $('#customers').dataTable({
            // "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
