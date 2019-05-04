<%--
  Created by IntelliJ IDEA.
  User: Luke
  Date: 2019-05-04
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register - LUKE Travels - Online Tour Agent</title>
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

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="indexc.jsp"><span>LUKE TRAVELS</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a href="indexc.jsp" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="tourPackages.jsp" class="nav-link">Tour Packages</a></li>
                <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
                <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
                <li class="nav-item"><a href="login.jsp" class="nav-link">Sign In</a></li>

                <li class="nav-item active"><a href="#" class="nav-link">Register</a></li>

                <li class="nav-item cta"><a href="#" class="nav-link">Book Now</a></li>


            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->


<section class="ftco-section services-section bg-dark">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-center">
            <div class="col-md-9 ftco-animate pb-5 mb-5 text-center">
                <br>

                <div class="card">
                    <div class="card-header">Register</div>
                    <div class="card-body">
                        <form action="Register" method="post">


                            <div class="form-group row">
                                <label for="fname"
                                       class="col-md-4 col-form-label text-md-right">First Name</label>
                                <div class="col-md-6">
                                    <input type="text" id="fname" class="form-control"
                                           name="fname" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="lname"
                                       class="col-md-4 col-form-label text-md-right">Last Name</label>
                                <div class="col-md-6">
                                    <input type="text" id="lname" class="form-control"
                                           name="lname" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="email_address"
                                       class="col-md-4 col-form-label text-md-right">E-Mail
                                    Address</label>
                                <div class="col-md-6">
                                    <input type="email" id="email_address" class="form-control"
                                           name="email" required autofocus>
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="phone"
                                       class="col-md-4 col-form-label text-md-right">Phone Number :</label>
                                <div class="col-md-6">
                                    <input type="tel" id="phone" class="form-control"
                                           name="phone" required autofocus>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password"
                                       class="col-md-4 col-form-label text-md-right">Password</label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control"
                                           name="pwd" required>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="retype_pwd"
                                       class="col-md-4 col-form-label text-md-right">Retype Password</label>
                                <div class="col-md-6">
                                    <input type="password" id="retype_pwd" class="form-control"
                                           name="retype_pwd" required>
                                </div>
                            </div>


                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn btn-primary">Sign In
                                </button>
                                <a href="#" class="btn btn-link"> Forgot Your Password? </a>
                            </div>
                        </form>
                    </div>
                    </form>

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
                    <h2 class="ftco-heading-2">Traveland</h2>
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



