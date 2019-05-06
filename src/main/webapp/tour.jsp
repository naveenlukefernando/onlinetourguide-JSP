<%@ page import="com.onlinetourguide.model.TourPackage" %>
<%@ page import="com.onlinetourguide.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2019-05-05
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>About | LUKE TRAVELS | Online Tour Guide </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">


    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">


    <style>

        /*img {*/
        /*    position: absolute;*/
        /*    clip: rect(0px,600px,945px,0px);*/
        /*}*/
    </style>


</head>
<body>


<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");


%>


<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.html"><span>LUKE TRAVELS</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="indexc.jsp" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="tourPackages.jsp" class="nav-link">Tour Packages</a></li>
                <li class="nav-item active"><a href="about.jsp" class="nav-link">About</a></li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>


                <%
                    if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                        out.print("<li class=\"nav-item\"><a href=\"login.jsp\" class=\"nav-link\">Sign In</a></li>");
                        out.print("<li class=\"nav-item\"><a href=\"#\" class=\"nav-link\">Register</a></li>");
                    } else {


                        out.print("<li class=\"nav-item dropdown\"><a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Hi ! " + ((User) session.getAttribute("cid")).getName() + "</a><div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\"> <a class=\"dropdown-item\" href=\"CustomerPendingBooking.jsp\">Pending Bookings</a>  <a class=\"dropdown-item\" href=\"#\">Current Bookings</a> <form action=\"Logout\" method=\"get\"> <button type=\"submit\" class=\"btn btn-link\">Logout</button></form> </div></li>");
                    }
                %>


                <li class="nav-item cta">
                    <a class="btn btn-primary py-3 px-5" data-toggle="modal"

                            <%
                                if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                                    out.print("data-target=\"#SignUpModal\"");
                                } else {
                                    out.print("data-target=\"#CustomerBookNowModal\"");
                                }
                            %>
                    >


                        Book Now

                    </a>

                </li>


            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<br>
<br>
<br>
<br>


<section class="ftco-counter img" id="section-counter">
    <div class="container">
        <div class="row d-flex">
            <div class="col-md-6 d-flex ftco-animate" data-stellar-background-ratio="0.5">
                <div class="img d-flex align-self-stretch "><img
                        src="data:image/jpg;base64,<%out.print(((TourPackage) session.getAttribute("tour_pkg")).getImageURL_1());%>"
                        width="1200" height="768"></div>
            </div>
            <div class="overlay"></div>
            <div class="col-md-6 pl-md-5 py-5 bg-light">
                <div class="row justify-content-start pb-3">
                    <div class="col-md-12 heading-section ftco-animate">
                        <h1 class="mb-4"
                            data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><%out.print(((TourPackage) session.getAttribute("tour_pkg")).getTour_name());%></h1>
                        <p class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">

                            <%out.print(((TourPackage) session.getAttribute("tour_pkg")).getDesp1());%>

                        </p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>


<br>
<br>

<section class="ftco-counter img " id="section-counter">
    <div class="container">
        <div class="row d-flex">
            <div class="col-md-6 order-md-last d-flex">
                <div class="img d-flex align-self-stretch"><img
                        src="data:image/jpg;base64,<%out.print(((TourPackage) session.getAttribute("tour_pkg")).getImageURL_2());%>"
                        width="1200" height="768"></div>
            </div>
            <div class="col-md-6 pr-md-5 py-5">
                <div class="row justify-content-start pb-3">
                    <div class="col-md-12 heading-section ftco-animate">
                        <h2 class="mb-4">NEVER. STOP. EXPLORING. </h2>
                        <p> Customer Satisfaction is our priority.</p>
                        <h4 class="mb-5"> More Details. </h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <p class="ftco-animate tips"><span>•</span>

                            <%out.print(((TourPackage) session.getAttribute("tour_pkg")).getDesp2());%>

                        </p>
                         <p class="ftco-animate mt-4">
                            <a class="btn btn-primary py-3 px-5" data-toggle="modal"

                                    <%
                                        if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                                            out.print("data-target=\"#SignUpModal\"");
                                        } else {
                                            out.print("data-target=\"#CustomerBookNowModal\"");
                                        }
                                    %>
                            >


                                Book Now

                            </a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<div class="modal fade" id="SignUpModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">

                <button type="button" class="close" data-dismiss="modal">&times;</button>

            </div>
            <div class="modal-body">
                <p class="text-center"> Please Sign In or Register</p>

                <p class="text-center">
                    <a class="btn btn-info" href="login.jsp"> Sign In </a>
                    <a class="btn btn-success" href="register.jsp">Register</a>

                </p>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>


<div class="modal fade" id="CustomerBookNowModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel"> Enter Details</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>

            </div>
            <div class="modal-body">

                <form id="profileForm" name="profileForm" action="CustomerBookPkg" method="post">

                    <input class="form-control" type="hidden" name="tourId"
                           value="<%out.print(((TourPackage) session.getAttribute("tour_pkg")).getId());%>">
                    <input class="form-control" type="hidden" name="cusId" value="<%

                    if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                                            out.print("");
                    }
                    else{
                        out.print(((User) session.getAttribute("cid")).getId());

                    }

                    %>">

                    First Name: : <input class="form-control" type="text" name="fname" value=""
                                         placeholder="<%
                                         if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                                            out.print("");
                                         }
                                         else{
                                             out.print(((User) session.getAttribute("cid")).getName());

                                         }
                                         %>"
                                         required readonly="readonly">

                    Last Name : <input class="form-control" type="text" name="lname" value=""
                                       placeholder="<%

                                       if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                                           out.print("");
                                        }
                                       else {
                                           out.print(((User) session.getAttribute("cid")).getLastname() );

                                       }
                                       %>"
                                       required readonly="readonly">

                    Phone Number : <input class="form-control" type="text" name="phone" value=""
                                          placeholder="<%
                                          if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                                              out.print("");
                                           }
                                          else{
                                              out.print(((User) session.getAttribute("cid")).getPhone());


                                          }

                                          %>"
                                          required readonly="readonly">

                    Prefered Date : <input class="form-control" type="date" name="pdate" value="" placeholder="date"
                                           required>

                    Adults : <input class="form-control" type="number" name="adult" value=""
                                    placeholder="Number of Adults "
                                    required>

                    Children : <input class="form-control" type="number" name="child" value=""
                                      placeholder="Number of Children"
                                      required>


            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Book Now</button>
                </form>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>

            </div>
        </div>
    </div>
</div>


<section class="ftco-section services-section bg-light">
    <div class="container">
        <div class="row d-flex">
            <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-yatch"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Transport Type</h3>
                        <h2 class="mb-4">  <%out.print(((TourPackage) session.getAttribute("tour_pkg")).getTransport_type());%> </h2>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-around"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Number of Days </h3>
                        <h3 class="mb-4"> <%out.print(((TourPackage) session.getAttribute("tour_pkg")).getDuration());%> </h3>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-compass"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Private Guide</h3>
                        <p>A small river named Duden flows by their place and supplies.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-map-of-roads"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Location Manager</h3>
                        <p>A small river named Duden flows by their place and supplies.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="ftco-subscribe" style="background-image: url(images/bg_1.jpg);">
    <div class="overlay">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-md-10 text-wrap text-center heading-section ftco-animate">
                    <h2>Subcribe to our Newsletter</h2>
                    <div class="row d-flex justify-content-center mt-4 mb-4">
                        <div class="col-md-10">
                            <form action="#" class="subscribe-form">
                                <div class="form-group d-flex">
                                    <input type="text" class="form-control" placeholder="Enter email address">
                                    <input type="submit" value="Subscribe" class="submit px-3">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<footer class="ftco-footer ftco-footer-2 ftco-section">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">LUKE TRAVELS</h2>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there
                        live the blind texts.</p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4 ml-md-5">
                    <h2 class="ftco-heading-2">Sitemap</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">Home</a></li>
                        <li><a href="#" class="py-2 d-block">Tour Packages</a></li>
                        <li><a href="#" class="py-2 d-block">About</a></li>
                        <li><a href="#" class="py-2 d-block">Contact</a></li>
                        <li><a href="#" class="py-2 d-block">Sign in</a></li>
                        <li><a href="#" class="py-2 d-block">Register</a></li>
                    </ul>
                </div>
            </div>


            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Have a Questions?</h2>
                    <div class="block-23 mb-3">
                        <ul>
                            <li><span class="icon icon-map-marker"></span><span class="text">No 23, Galle Road, Colombo, Sri Lanka</span>
                            </li>
                            <li><a href="#"><span class="icon icon-phone"></span><span
                                    class="text">+94 772 3929 210</span></a></li>
                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">

                <p>
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    All rights reserved </a>
                </p>
            </div>
        </div>
    </div>
</footer>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>
<script src="js/main.js"></script>

</body>
</html>

