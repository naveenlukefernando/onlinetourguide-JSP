<%@ page import="com.onlinetourguide.dao.TourPkgFetchDao" %>
<%@ page import="com.onlinetourguide.model.TourPackage" %>
<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2019-04-18
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="stylesheets/index.css">
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
    <a href="index.jsp" class="logo">Online Tour Guide </a>

    <div class="header-right">

        <button type="button" class="btn btn-primary" data-toggle="modal"
                data-target="#addPKGModal">Add New Package
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
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Dashboard</a></li>
                <li><a href="#">New Bookings <span class="label label-danger"> 24  </span></a></li>
                <li><a href="#">Current Bookings</a></li>
                <li class="active"><a href="manageTourPackages.jsp">Manage Tour Packages</a></li>
                <li><a href="manageUsers.jsp">Manage Users</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav hidden-xs">
            <h2>Admin Panel</h2>

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
                <li><a href="#">New Bookings <span class="label label-danger"> 24  </span></a></li>
                <li><a href="#section2">Current Bookings</a></li>
                <li class="active"><a href="manageTourPackages.jsp">Manage Tour Packages</a></li>
                <li><a href="manageUsers.jsp">Manage Users</a></li>
            </ul>
            <br>
        </div>
        <br>


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


        <div class="col-sm-9">
            <div class="well">
                <h4>Manage Tour Packages</h4>

            </div>

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
                        <th>From</th>
                        <th>To</th>
                        <th>Date</th>
                        <th>Price</th>
                        <th>Description_1</th>
                        <th>Description_2</th>
                        <th>Image_1</th>
                        <th>Image_2</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                    <%
                        TourPkgFetchDao pkgFetchDao = new TourPkgFetchDao();
                        for (TourPackage t : pkgFetchDao.fetchPackages()) {
                    %>

                    <tr>
                        <td>
                            <%
                                out.print(t.getId());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(t.getTour_name());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(t.getLocation_from());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(t.getLocation_to());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(t.getDate());
                            %>
                        </td>

                        <td>
                            <%
                                out.print(t.getPrice());
                            %>
                        </td>

                        <td>
                            <%
                                out.print(t.getDesp1());
                            %>
                        </td>

                        <td>
                            <%
                                out.print(t.getDesp2());
                            %>
                        </td>

                        <td>

                            <img src="data:image/jpg;base64,<%out.print(t.getImageURL_1()); %>" width="50" height="50"/>


                        </td>

                        <td>

                            <img src="data:image/jpg;base64,<%out.print(t.getImageURL_2()); %>" width="50" height="50"/>

                        </td>

                        <td>

                            <div class="text-center">
                                <a id="deletebtn" class="btn btn-danger"
                                   onclick="deletePackageFunction(<%out.print(t.getId());%>)">Delete </a>


                                <button class="btn btn-info" tour_name="<% out.print(t.getTour_name());%>"
                                        id="<%out.print(t.getId());%>"
                                        from="<% out.print(t.getLocation_from());%>"
                                        to="<% out.print(t.getLocation_to());%>"
                                        date="<% out.print(t.getDate());%>"
                                        price="<% out.print(t.getPrice());%>"
                                        desp1="<% out.print(t.getDesp1());%>"
                                        desp2="<%out.print(t.getDesp2());%>"
                                <%--                                    file = "<%out.print(t.getImageURL_1());%>"--%>
                                <%--                                    file1="<%out.print(t.getImageURL_2());%>"--%>
                                        data-toggle="modal" data-target="#editPackageModal">
                                    Edit
                                </button>

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


<!-- Modal New Package -->
<div class="modal fade" id="editPackageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit Details</h4>
            </div>
            <div class="modal-body">

                <form id="profileForm" name="editform" action="UpdateTourPackage" method="post"
                      enctype="multipart/form-data">
                    ID: <input class="form-control" name="id" value="" placeholder="id" readonly="readonly">
                    Name: : <input class="form-control" type="text" name="tour_name" value=""
                                   placeholder="Tour Package Name" required>
                    From : <input class="form-control" type="text" name="from" value="" placeholder="From" required>
                    To : <input class="form-control" type="text" name="to" value="" placeholder="to"
                                required>
                    Price : <input class="form-control" type="number" name="price" value="" placeholder="price"
                                   required>
                    Date : <input class="form-control" type="date" name="date" value="" placeholder="date"
                                  required>

                    Upload Image 1 (4 MB): <input class="form-control" type="file" name="file" value=""
                                                  placeholder="file">

                    Upload Image 2: (4 MB)<input class="form-control" type="file" name="file1" value=""
                                                 placeholder="file1">

                    Description 1: <input class="form-control" type="text" name="desp1" value=""
                                          placeholder="desp1"
                                          required>
                    Description 2: <input class="form-control" type="text" name="desp2" value=""
                                          placeholder="desp2"
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


<!-- Modal New Package -->
<div class="modal fade" id="addPKGModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add Tour Package</h4>
            </div>
            <div class="modal-body">
                <p>Please fill details</p>

                <div class="Form Form--centered">
                    <form action="AddNewTourPackage" method="post" id="addpkg_form" enctype="multipart/form-data">
                        <div class="form-group ">
                            <label for="name">Name:</label> <input type="text"
                                                                   class="form-control" id="add_name"
                                                                   placeholder="Enter Package Name"
                                                                   name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">From :</label> <input type="text"
                                                                     class="form-control" id="add_from"
                                                                     placeholder="Enter Start Location"
                                                                     name="from" required>
                        </div>
                        <div class="form-group">
                            <label for="phone">To :</label> <input type="text"
                                                                   class="form-control" id="add_to"
                                                                   placeholder="Enter End Location"
                                                                   name="to" required>
                        </div>

                        <div class="form-group">
                            <label for="date">Date :</label> <input type="date"
                                                                    class="form-control" id="add_date"
                                                                    placeholder="Select Date"
                                                                    name="date" required>
                        </div>


                        <div class="form-group">
                            <label for="phone">Price :</label> <input type="number"
                                                                      class="form-control" id="price"
                                                                      name="price" required>
                        </div>


                        <div class="form-group">
                            <label for="image1">Upload Image 1 (4 MB):</label> <input type="file"
                                                                                      class="form-control"
                                                                                      id="add_photo"
                                                                                      name="file" required>
                        </div>

                        <div class="form-group">
                            <label for="image2">Upload Image 2: (4 MB)</label> <input type="file"
                                                                                      class="form-control"
                                                                                      id="add_photo1"
                                                                                      name="file1" required>
                        </div>

                        <div class="form-group">
                            <label for="textarea1">Description 1:</label> <textarea class="form-control" rows="2"
                                                                                    id="add_desp1" name="desp1"
                                                                                    form="addpkg_form" required>
                                                                        </textarea>
                        </div>

                        <div class="form-group">
                            <label for="textarea2">Description 2:</label> <textarea class="form-control" rows="2"
                                                                                    id="add_desp2" name="desp2"
                                                                                    form="addpkg_form" required>
                                                                        </textarea>
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

    $('#editPackageModal').on('show.bs.modal', function (e) {
        // get information to update quickly to modal view as loading begins
        var opener = e.relatedTarget;//this holds the element who called the modal

        //we get details from attributes
        var id = $(opener).attr('id');
        var tour_name = $(opener).attr('tour_name');
        var location_from = $(opener).attr('from');
        var location_to = $(opener).attr('to');
        var date = $(opener).attr('date');
        var price = $(opener).attr('price');
        var desp1 = $(opener).attr('desp1');
        var desp2 = $(opener).attr('desp2');
        //var imageURL_1= $(opener).attr('file');
        //var imageURL_2= $(opener).attr('file1');

        //set what we got to our form
        $('#profileForm').find('[name="tour_name"]').val(tour_name);
        $('#profileForm').find('[name="from"]').val(location_from);
        $('#profileForm').find('[name="to"]').val(location_to);
        $('#profileForm').find('[name="date"]').val(date);
        $('#profileForm').find('[name="price"]').val(price);
        $('#profileForm').find('[name="desp1"]').val(desp1);
        $('#profileForm').find('[name="desp2"]').val(desp2);
        $('#profileForm').find('[name="id"]').val(id);
        // $('#profileForm').find('[name="file"]').val(imageURL_1);
        // $('#profileForm').find('[name="file1"]').val(imageURL_2);

        console.log(id);


    });

</script>


</body>

</html>
