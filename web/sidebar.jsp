<%-- 
    Document   : sidebar
    Created on : 29 Jan 2025, 16:45:26
    Author     : NCPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" href="images/fevicon.png" type="image/png" />
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- site css -->
        <link rel="stylesheet" href="style.css" />
        <!-- responsive css -->
        <link rel="stylesheet" href="css/responsive.css" />
        <!-- color css -->
        <link rel="stylesheet" href="css/colors.css" />
        <!-- select bootstrap -->
        <link rel="stylesheet" href="css/bootstrap-select.css" />
        <!-- scrollbar css -->
        <link rel="stylesheet" href="css/perfect-scrollbar.css" />
        <!-- custom css -->
        <link rel="stylesheet" href="css/custom.css" />
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <nav id="sidebar">
            <div class="sidebar_blog_1">
                <div class="sidebar-header">
                    <div class="logo_section">
                        <a href="index.jsp"><img class="logo_icon img-responsive" src="images/logo/logo_icon.png" alt="#" /></a>
                    </div>
                </div>
                <div class="sidebar_user_info">
                    <div class="icon_setting"></div>
                    <div class="user_profle_side">
                        <div class="user_img"><img class="img-responsive" src="images/layout_img/user_img.jpg" alt="#" /></div>
                        <div class="user_info">
                            <h6>Resident</h6>
                            <p><span class="online_animation"></span> Online</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="sidebar_blog_2">
                <h4>General</h4>
                <ul class="list-unstyled components">
                    <li class="active">
                        <a href="#dashboard" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-dashboard yellow_color"></i> <span>Dashboard</span></a>
                        <ul class="collapse list-unstyled" id="dashboard">
                            <li>
                                <a href="dashboard.html">> <span>Default Dashboard</span></a>
                            </li>
                            <li>
                                <a href="dashboard_2.html">> <span>Dashboard style 2</span></a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="widgets.html"><i class="fa fa-clock-o orange_color"></i> <span>Widgets</span></a></li>
                    <li>
                        <a href="#element" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-diamond purple_color"></i> <span>Elements</span></a>
                        <ul class="collapse list-unstyled" id="element">
                            <li><a href="general_elements.html">> <span>General Elements</span></a></li>
                            <li><a href="media_gallery.html">> <span>Media Gallery</span></a></li>
                            <li><a href="icons.html">> <span>Icons</span></a></li>
                            <li><a href="invoice.html">> <span>Invoice</span></a></li>
                        </ul>
                    </li>
                    <li><a href="view-resident"><i class="fa fa-table purple_color2"></i> <span>Tables</span></a></li>
                    <li><a href="view-all-staff"><i class="fa fa-table purple_color2"></i> <span>Staff Information</span></a></li>
                    <li><a href="view-all-company"><i class="fa fa-table purple_color2"></i> <span>Company Information</span></a></li>
                    <li><a href="view-all-request"><i class="fa fa-table purple_color2"></i> <span>Request Information</span></a></li>
                    <li><a href="view-feed-back-user"><i class="fa fa-table purple_color2"></i> <span>Feedback User</span></a></li>
                    <li><a href="view-all-feedback"><i class="fa fa-table purple_color2"></i> <span>Feedback Admin</span></a></li>
                    <li><a href="view-news"><i class="fa fa-newspaper-o yellow_color"></i> <span>News</span></a></li>
                    <li><a href="${ut.getSiteToViewRule(sessionScope.account.roleId)}"><i class="fa fa-table purple_color2"></i> <span>Rule of apartment</span></a></li>

                    <li>
                        <a href="#apps" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-object-group blue2_color"></i> <span>Apps</span></a>
                        <ul class="collapse list-unstyled" id="apps">
                            <li><a href="email.html"> <span>Email</span></a></li>
                            <li><a href="calendar.html"> <span>Calendar</span></a></li>
                            <li><a href="media_gallery.html">> <span>Media Gallery</span></a></li>
                        </ul>
                    </li>
                    <li><a href="price.html"><i class="fa fa-briefcase blue1_color"></i> <span>Pricing Tables</span></a></li>
                    <li>
                        <a href="contact.html">
                            <i class="fa fa-paper-plane red_color"></i> <span>Contact</span></a>
                    </li>
                    <li class="active">
                        <a href="#additional_page" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-clone yellow_color"></i> <span>Additional Pages</span></a>
                        <ul class="collapse list-unstyled" id="additional_page">
                            <li>
                                <a href="profile.jsp">> <span>Profile</span></a>
                            </li>
                            <li>
                                <a href="project.html">> <span>Projects</span></a>
                            </li>
                            <li>
                                <a href="login.html">> <span>Login</span></a>
                            </li>
                            <li>
                                <a href="404_error.html">> <span>404 Error</span></a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="map.html"><i class="fa fa-map purple_color2"></i> <span>Map</span></a></li>
                    <li><a href="charts.html"><i class="fa fa-bar-chart-o green_color"></i> <span>Charts</span></a></li>
                    <li><a href="settings.html"><i class="fa fa-cog yellow_color"></i> <span>Settings</span></a></li>
                </ul>
            </div>
        </nav>
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- wow animation -->
        <script src="js/animate.js"></script>
        <!-- select country -->
        <script src="js/bootstrap-select.js"></script>
        <!-- owl carousel -->
        <script src="js/owl.carousel.js"></script> 
        <!-- chart js -->
        <script src="js/Chart.min.js"></script>
        <script src="js/Chart.bundle.min.js"></script>
        <script src="js/utils.js"></script>
        <script src="js/analyser.js"></script>
        <!-- nice scrollbar -->
        <script src="js/perfect-scrollbar.min.js"></script>
        <script>
            var ps = new PerfectScrollbar('#sidebar');
        </script>
        <!-- custom js -->
        <script src="js/custom.js"></script>
        <script src="js/chart_custom_style1.js"></script>
    </body>
</html>
