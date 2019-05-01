<%@ page import="com.onlinetourguide.dao.NewCustomerBookingDao" %><%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2019-04-18
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

		NewCustomerBookingDao dao = new NewCustomerBookingDao();

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
					<li class="active"><a href="index.jsp">Dashboard</a></li>
					<li><a href="manageNewBooking.jsp">New Bookings <span class="label label-danger"> <% out.print(dao.bookingRequestCount());%>   </span></a>  </li>
					<li><a href="manageCurrentBooking.jsp">Current Bookings</a></li>
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
						data-toggle="dropdown" href="#"> <b>Hi! <% out.print(username);%> </b> <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<form action="Logout" method="get">
									<button type="submit" class="btn btn-link">Logout</button>
								</form>
							</li>

						</ul></li>

				</ul>

				<br>

				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">Dashboard</a></li>
					<li><a href="manageNewBooking.jsp">New Bookings <span class="label label-danger"><% out.print(dao.bookingRequestCount());%>  </span></a>  </li>
					<li><a href="manageCurrentBooking.jsp">Current Bookings</a></li>
					<li><a href="manageTourPackages.jsp">Manage Tour Packages</a></li>
					<li><a href="manageUsers.jsp">Manage Users</a></li>
				</ul>
				<br>
			</div>
			<br>

			<div class="col-sm-9">
				<div class="well">
					<h4>Dashboard</h4>
					<p>Some text..</p>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<div class="well">
							<h4>Users</h4>
							<p>1 Million</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="well">
							<h4>Pages</h4>
							<p>100 Million</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="well">
							<h4>Sessions</h4>
							<p>10 Million</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="well">
							<h4>Bounce</h4>
							<p>30%</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
							<p>Text</p>
							<p>Text</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
							<p>Text</p>
							<p>Text</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
							<p>Text</p>
							<p>Text</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<div class="well">
							<p>Text</p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="well">
							<p>Text</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>

</html>