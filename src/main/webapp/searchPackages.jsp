<%@ page import="com.onlinetourguide.dao.TourPkgFetchDao" %>
<%@ page import="com.onlinetourguide.model.TourPackage" %>
<%@ page import="com.onlinetourguide.model.User" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2019-05-02
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tour Packages - PARADISE TRAVELS | Online Tour guide</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">


    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    TourPkgFetchDao fetchDao = new TourPkgFetchDao();
%>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.html"><span>PARADISE TRAVELS</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="indexc.jsp" class="nav-link">Home</a></li>
                <li class="nav-item active"><a href="tourPackages.jsp" class="nav-link">Tour Packages</a></li>
                <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
                <%--                <li class="nav-item"><a href="login.jsp" class="nav-link">Sign In</a></li>--%>
                <%--                <li class="nav-item"><a href="login.jsp" class="nav-link">Register</a></li>--%>

                <%
                    if (session.getAttribute("username") == null) {
                        out.print("<li class=\"nav-item\"><a href=\"login.jsp\" class=\"nav-link\">Sign In</a></li>");
                        out.print("<li class=\"nav-item\"><a href=\"#\" class=\"nav-link\">Register</a></li>");
                    } else {
                        //out.print("<li class=\"nav-item\"><a class=\"nav-link\"> Hi "+username+"</a></li>");
                        out.print("<li class=\"nav-item dropdown\"><a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Hi ! " + ((User) session.getAttribute("cid")).getName() + "</a><div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\"> <a class=\"dropdown-item\" href=\"CustomerPendingBooking.jsp\">Pending Bookings</a> <a class=\"dropdown-item\" href=\"customerCurrentBooking.jsp\">Current Bookings</a> <form action=\"Logout\" method=\"get\"> <button type=\"submit\" class=\"btn btn-link\">Logout</button></form> </div></li>");
                    }
                %>


                <li class="nav-item cta">

                    <a class="btn btn-primary py-3 px-5" data-toggle="modal"

                        <%
                                if (session.getAttribute("username") == null && session.getAttribute("cid") == null) {
                                    out.print("data-target=\"#SignUpModal\"");
                                } else {
                                    out.print("");
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


<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/bg_2.jpg');"
         data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-center">
            <div class="col-md-9 ftco-animate pb-5 mb-5 text-center">
                <h1 class="mb-3 bread">Places to Travel</h1>
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i
                        class="ion-ios-arrow-forward"></i></a></span> <span>Tour Packages <i
                        class="ion-ios-arrow-forward"></i></span></p>
            </div>
        </div>
    </div>
</section>


<section class="ftco-section ftco-no-pb ftco-no-pt">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="search-wrap-1 ftco-animate p-4">
                    <form action="SearchPkg" method="post" class="search-property-1">
                        <div class="row">
                            <div class="col-lg align-items-end">
                                <div class="form-group">
                                    <label for="#">Destination</label>
                                    <div class="form-field">
                                        <div class="icon"><span class="ion-ios-search"></span></div>
                                        <input name="city"  type="text" class="form-control" placeholder="Search place">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg align-items-end">
                                <div class="form-group">
                                    <label for="#">Check-in date</label>
                                    <div class="form-field">
                                        <div class="icon"><span class="ion-ios-calendar"></span></div>
                                        <input name= "checkIndate" type="text" class="form-control checkin_date"
                                               placeholder="Check In Date">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg align-items-end">
                                <div class="form-group">
                                    <label for="#">Check-out date</label>
                                    <div class="form-field">
                                        <div class="icon"><span class="ion-ios-calendar"></span></div>
                                        <input name="checkout" type="text" class="form-control checkout_date"
                                               placeholder="Check Out Date">
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg align-self-end">
                                <div class="form-group">
                                    <div class="form-field">
                                        <input type="submit" value="Search" class="form-control btn btn-primary">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center pb-5">
            <div class="col-md-12 heading-section text-center ftco-animate">
                <h2 class="mb-4">BEST OF THE ISLAND</h2>
                <p>Find best Sri Lanka tour packages to plan your holiday in Sri Lanka.</p>
            </div>
        </div>
        <div class="row">


            <%
                String city = (String) session.getAttribute("city");
                int duration = (int) session.getAttribute("duration");

                System.out.println(city +" " +duration);

                for (TourPackage tp : fetchDao.searchPackage(city,duration)) {%>
            <div class="col-md-6 col-lg-3 ftco-animate">
                <div class="project">
                    <div class="img">
                        <img src="data:image/jpg;base64,<%out.print(tp.getImageURL_1()); %>" class="img-fluid"
                             alt="Colorlib Template">
                    </div>
                    <div class="text">
                        <h4 class="price"><%out.print(tp.getPrice());%> LKR</h4>
                        <span> <%out.print(tp.getDuration());%> Days Tour</span>
                        <h3><a href="SelectedTour?bid=<%out.print(tp.getId());%>"><%out.print(tp.getTour_name());%></a></h3>
                        <a href="SelectedTour?bid=<%out.print(tp.getId());%>" class="nav-link cta">Book Now</a>
                        <div class="star d-flex clearfix">
                            <div class="mr-auto float-left">
                                <%

                                    int v = (int )(Math.random() * 5 + 2);

                                    for(int i = 1; i<v;i++)
                                    {
                                        out.print("<span class=\"ion-ios-star\"></span>");
                                    }
                                %>




                            </div>
                            <div class="float-right">
                                <span class="rate"><a href="#">
                                <%
                                    int val = (int )(Math.random() * 50 + 1);
                                    out.print(val);
                                %>
                                </a></span>
                            </div>
                        </div>
                    </div>
                    <%--                    <a href="images/destination-1.jpg"--%>
                    <%--                       class="icon image-popup d-flex justify-content-center align-items-center">--%>
                    <%--                        <span class="icon-expand"></span>--%>
                    <%--                    </a>--%>
                </div>
            </div>
            <%}%>


        </div>


        <%--        <div class="row mt-5">--%>
        <%--            <div class="col text-center">--%>
        <%--                <div class="block-27">--%>
        <%--                    <ul>--%>
        <%--                        <li><a href="#">&lt;</a></li>--%>
        <%--                        <li class="active"><span>1</span></li>--%>
        <%--                        <li><a href="#">2</a></li>--%>
        <%--                        <li><a href="#">3</a></li>--%>
        <%--                        <li><a href="#">4</a></li>--%>
        <%--                        <li><a href="#">5</a></li>--%>
        <%--                        <li><a href="#">&gt;</a></li>--%>
        <%--                    </ul>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>


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
                    <h2 class="ftco-heading-2">PARADISE TRAVELS</h2>
                    <p>A successful visit to Sri Lanka depends on having an expert tour guide at your disposal.
                        We look forward to meeting you, and to helping to make your visit an unforgettable success!
                        We have long experience of the country, its customs
                        and traditions, and its many astonishing historical and cultural sites.</p>
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
                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@paradisetravels.com</span></a>
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
