<%--
  Created by IntelliJ IDEA.
  User: GIGA
  Date: 9/30/2020
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js"></script>

    <script>
        // $(document).ready(function () {
        //     $('#customers').DataTable();
        // });

        $(document).ready(function () {
            $('#employees').DataTable();
        });
        // Phân trang

        $(document).ready(function () {
            $('#customers').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-12 d-flex"><img src="images/Logo.JPG" alt="logo img">
            <div class="ml-auto align-middle">Hoàng Minh Quân</div>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Furama Resort</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/CustomerServlet">Home <span class="sr-only">(current)</span></a>
                </li>
                <%--  <li class="nav-item">
                      <a class="nav-link" href="/EmployeeServlet?action=create">Employee</a>
                  </li>--%>

                <li class="nav-item dropdown nav-link">
                        <span class="dropdown-toggle" id="dropdownMenuButtonEmployee"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Employee
                        </span>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonEmployee">
                        <a class="dropdown-item" onclick="showAndHide('employees')">List Employee</a>
                        <a class="dropdown-item" href="/EmployeeServlet?action=create">Create Employee</a>
                    </div>
                </li>

                <li class="nav-item dropdown nav-link">
                        <span class="dropdown-toggle" id="dropdownMenuButton"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Customer
                        </span>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" onclick="showAndHide('customers')">List Customer</a>
                        <a class="dropdown-item" href="/CustomerServlet?action=create">Create Customer</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ServiceServlet?action=create">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ContractServlet?action=create">Contract</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="row">
        <div class="col-md-2 bg-dark">Aside</div>
        <div class="col-md-10">
            <table class="table table-striped table-sm" id="customers" style="display: none">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">ID Card</th>
                    <th scope="col">Type</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <th scope="row" id="id-${customer.getId()}">${customer.getId()}</th>
                        <td id="name-${customer.getId()}">${customer.getName()}</td>
                        <td id="birthday-${customer.getId()}">${customer.getBirthday()}</td>
                        <td id="idCard-${customer.getId()}">${customer.getIdCard()}</td>
                        <td id="type-${customer.getId()}">${customer.getCustomerType()}</td>
                        <td id="phone-${customer.getId()}">${customer.getPhone()}</td>
                        <td id="email-${customer.getId()}">${customer.getEmail()}</td>
                        <td id="address-${customer.getId()}">${customer.getAddress()}</td>
                        <td><a href="/CustomerServlet?action=edit&id=${customer.id}"><i
                                class="material-icons">&#xE254;</i></a></td>
                            <%--                        <td><a href="/CustomerServlet?action=delete&id=${customer.id}" data-toggle="modal"--%>
                        <td><a href="" data-toggle="modal" data-target="#deleteModal"
                               onclick="
                                       setInnerText('id-${customer.getId()}', 'des-id');
                                       setInnerText('name-${customer.getId()}','des-name');
                                       setInnerText('birthday-${customer.getId()}','des-birthday');
                                       setInnerText('idCard-${customer.getId()}','des-idCard');
                                       setInnerText('type-${customer.getId()}','des-type');
                                       setInnerText('phone-${customer.getId()}','des-phone');
                                       setInnerText('email-${customer.getId()}','des-email');
                                       setInnerText('address-${customer.getId()}','des-address');
                                       setValue('id-${customer.getId()}','id');
                                       ">
                            <i class="material-icons">&#xE872;</i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
<%--            modal customer--%>
            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="deleteModalLabel">Customer information</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="/CustomerServlet">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" id="id">
                            <div class="modal-body">
                                <p>ID: <span id="des-id"></span></p>
                                <p>Name: <span id="des-name"></span></p>
                                <p>Birthday: <span id="des-birthday"></span></p>
                                <p>ID Card: <span id="des-idCard"></span></p>
                                <p>Type: <span id="des-type"></span></p>
                                <p>Phone: <span id="des-phone"></span></p>
                                <p>Email: <span id="des-email"></span></p>
                                <p>Address: <span id="des-address"></span></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Delete</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%-- <form action="">
                 <input type="hidden" name="action" value="create">
                 <button type="submit" value="create"><span class="material-icons">add</span></button>
             </form>--%>
            <table class="table table-striped table-sm" id="employees" style="display: none">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Position</th>
                    <th scope="col">Education</th>
                    <th scope="col">Department</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">ID Card</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <th scope="row">${employee.getId()}</th>
                        <td>${employee.getName()}</td>
                        <td>${employee.getPositionId()}</td>
                        <td>${employee.getEducationId()}</td>
                        <td>${employee.getDepartmentId()}</td>
                        <td>${employee.getBirthday()}</td>
                        <td>${employee.getIdCard()}</td>
                        <td>${employee.getSalary()}</td>
                        <td>${employee.getPhone()}</td>
                        <td>${employee.getEmail()}</td>
                        <td>${employee.getAddress()}</td>
                        <td><a href="/EmployeeServlet?action=edit&id=${employee.id}">
                            <i class="material-icons">&#xE254;</i></a></td>
                        <td><a href="/EmployeeServlet?action=delete&id=${employee.id}">
                            <i class="material-icons">&#xE872;</i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


            <%-- <form action="">
                 <input type="hidden" name="action" value="create">
                 <button type="submit" value="create"><span class="material-icons">add</span></button>
             </form>--%>

    </div>
<%--    <div class="=row">--%>
<%--        <div class="col-md-12 bg-primary">Footer</div>--%>
<%--    </div>--%>
</div>
<script>
    function setInnerText(idStart, idDest) {
        document.getElementById(idDest).innerText = document.getElementById(idStart).innerText;
    }

    function setValue(idStart, idDest) {
        document.getElementById(idDest).value = document.getElementById(idStart).innerText;
    }

    function showAndHide(divID) {
        let x = document.getElementById(divID);
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>
</body>
</html>
