<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2019-04-18
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page import="com.onlinetourguide.dao.UsersFetchDao" %>
<%@ page import="com.onlinetourguide.model.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Online Tour Guide</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="stylesheets/index.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/h.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <script src="scripts/manage.js"></script>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .header {
            overflow: hidden;
            background-color: #455A64;
            padding: 20px 10px;
        }

        .header1 {
            overflow: hidden;
            background-color: #455A64;
        }

        .header a {
            float: left;
            color: rgb(255, 255, 255);
            text-align: center;
            padding: 12px;
            text-decoration: none;
            font-size: 18px;
            line-height: 25px;
            border-radius: 4px;
        }

        .header a.logo {
            font-size: 25px;
            font-weight: bold;
        }

        .header a:hover {
            background-color: #ddd;
            color: black;
        }

        .header a.active {
            background-color: dodgerblue;
            color: white;
        }

        .header-right {
            float: right;
        }

        @media screen and (max-width: 500px) {
            .header a {
                float: none;
                display: block;
                text-align: left;
            }

            .header-right {
                float: none;
            }
        }
    </style>


</head>

<body>


<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

    String username = (String) session.getAttribute("username");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("loginerror.jsp");

    }
%>


<div class="header">
    <a href="#default" class="logo">Online Tour Guide </a>
    <div class="header-right">

        <button type="button" class="btn btn-primary" data-toggle="modal"
                data-target="#addUserModal">Add New User
        </button>
    </div>

</div>


<nav class="navbar navbar-inverse visible-xs">

    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Admin Panel</a>
            <ul class="nav nav-tabs">

                <li class="dropdown"><a class="dropdown-toggle"
                                        data-toggle="dropdown" href="#"> <b>Hi! <% out.print(username);%></b> <span
                        class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <form action="Logout" method="get">
                                <button type="submit" class="btn btn-link">Logout</button>
                            </form>
                        </li>

                    </ul>
                </li>

            </ul>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Dashboard</a></li>
                <li><a href="#">New Bookings</a></li>
                <li><a href="#">Current Bookings</a></li>
                <li><a href="#">Manage Tour Packages</a></li>
                <li class="active"><a href="#">Manage Users</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav hidden-xs">


            <ul class="nav nav-tabs">

                <li class="dropdown"><a class="dropdown-toggle"
                                        data-toggle="dropdown" href="#"> <b>Hi! <% out.print(username);%></b> <span
                        class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <form action="Logout" method="get">
                                <button type="submit" class="btn btn-link">Logout</button>
                            </form>
                        </li>

                    </ul>
                </li>

            </ul>

            <br>

            <ul class="nav nav-pills nav-stacked">
                <li><a href="index.jsp">Dashboard</a></li>
                <li><a href="#">New Bookings</a></li>
                <li><a href="#section2">Current Bookings</a></li>
                <li><a href="#section3">Manage Tour Packages</a></li>
                <li class="active"><a href="#section3">Manage Users</a></li>
            </ul>
            <br>
        </div>
        <br>


        <div class="text-left">
            <h4>Manage Users</h4>
        </div>


        <br>


        <%--            <div class="input-group">--%>
        <%--                <span class="input-group-addon">Search</span>--%>
        <%--                <input type="text" id="myInput" class="form-control" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">--%>
        <%--            </div>--%>

        <%--            <br>--%>

        <script>

            function myFunction() {
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("userTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

        </script>

        <br>

        <div class="col-sm-9">
            <div class="input-group">
                <span class="input-group-addon">Search</span>
                <input type="text" id="myInput" class="form-control" onkeyup="myFunction()"
                       placeholder="Search for names.." title="Type in a name">
            </div>
            <div class="panel-body">

                <table id="userTable" class="table table-bordered">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>E-mail</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <%
                        UsersFetchDao dao = new UsersFetchDao();
                        for (User u : dao.fetchUser()) {
                    %>

                    <tr>
                        <td>
                            <%
                                out.print(u.getId());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(u.getName());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(u.getPhone());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(u.getEmail());
                            %>
                        </td>

                        <td>
                            <div class="text-center">
                                <a id="deletebtn" class="btn btn-danger"
                                   onclick="deleteFunction(<%out.print(u.getId());%>)">Delete </a>

                                <button class="btn btn-info" first-name="<% out.print(u.getName());%>"
                                        phone="<% out.print(u.getPhone());%>"
                                        email="<% out.print(u.getEmail());%>"
                                        id="<% out.print(u.getId());%>"
                                        data-toggle="modal" data-target="#editUserModal">
                                    Edit
                                </button>


                                <%--                                    <button type="button" class="btn btn-info" data-toggle="modal"--%>
                                <%--                                            data-target="#editUserModal">Update</button>--%>

                            </div>
                        </td>
                    </tr>

                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit Details</h4>
            </div>
            <div class="modal-body">

                <form id="profileForm" name="editform" action="UpdateUser" method="post">
                    ID: <input class="form-control" name="id" value="" placeholder="id" readonly="readonly">
                    Firstname : <input class="form-control" type="text" name="firstname" value=""
                                       placeholder="firstname" required>
                    Phone : <input class="form-control" type="tel" name="phone" value="" placeholder="phone" required>
                    E-Mail : <input class="form-control" type="email" name="email" value="" placeholder="email"
                                    required>

            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Save changes</button>
                </form>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

            </div>
        </div>
    </div>
</div>


<script>

    function validateForm() {
        var edt_fname = document.forms["editform"]["firstname"].value;
        var edt_phone = document.forms["editform"]["phone"].value;
        var edt_email = document.forms["editform"]["email"].value;


        if (edt_fname == "") {
            alert("Name must be filled out");
            return false;
        } else if (edt_phone == "") {
            alert("Phone must be filled out");
            return false;
        } else if (edt_email == "") {
            alert("Email mustbe filled out");
            return false;
        }
    }


</script>


<div class="modal fade" id="addUserModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add User</h4>
            </div>
            <div class="modal-body">
                <p>Please fill details</p>

                <div class="Form Form--centered">
                    <form action="AddUser" method="post">
                        <div class="form-group ">
                            <label for="name">Name:</label> <input type="text"
                                                                   class="form-control" id="add_name"
                                                                   placeholder="Enter name"
                                                                   name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email :</label> <input type="email"
                                                                      class="form-control" id="add_email"
                                                                      placeholder="Enter Email"
                                                                      name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone :</label> <input type="tel"
                                                                      class="form-control" id="add_phone"
                                                                      placeholder="Enter Phone"
                                                                      name="phone" required>
                        </div>


                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary  btn-md">Done</button>
                    </form>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</div>


<script>

    $('#editUserModal').on('show.bs.modal', function (e) {
        // get information to update quickly to modal view as loading begins
        var opener = e.relatedTarget;//this holds the element who called the modal

        //we get details from attributes
        var firstname = $(opener).attr('first-name');
        var phone = $(opener).attr('phone');
        var email = $(opener).attr('email');
        var id = $(opener).attr('id');

        //set what we got to our form
        $('#profileForm').find('[name="firstname"]').val(firstname);
        $('#profileForm').find('[name="phone"]').val(phone);
        $('#profileForm').find('[name="email"]').val(email);
        $('#profileForm').find('[name="id"]').val(id);

        console.log(id);

    });

</script>


</body>

</html>