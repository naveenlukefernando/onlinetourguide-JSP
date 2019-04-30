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
                <li class="active"><a href="#">Dashboard</a></li>
                <li class="active"><a href="#">New Bookings <span class="label label-danger"> 24  </span></a></li>
                <li><a href="#">Current Bookings</a></li>
                <li><a href="manageTourPackages.jsp">Manage Tour Packages</a></li>
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
                <li><a href="#section1">Dashboard</a></li>
                <li class="active"><a href="#">New Bookings <span class="label label-danger"> 24  </span></a></
                >
                <li><a href="#section2">Current Bookings</a></li>
                <li><a href="manageTourPackages.jsp">Manage Tour Packages</a></li>
                <li><a href="manageUsers.jsp">Manage Users</a></li>
            </ul>
            <br>
        </div>
        <br>

        <div class="col-sm-9">

            <div class="well">
                <h4>New Bookings</h4>
            </div>

            <div class="panel-body">

                <table id="userTable" class="table table-bordered">
                    <thead>
                    <tr>
                        <th>id</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <td>
                            d
                        </td>
                    </tr>

                    </tbody>

                </table>

            </div>


        </div>
    </div>
</div>

</body>

</html>
