<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Util"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Pluto</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- site icon -->
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
    <body class="dashboard dashboard_1">
        <jsp:useBean id="ut" class="util.Util" scope="page"/>
        <div class="full_container">
            <div class="inner_container">
                <!-- Sidebar  -->
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
                            <li><a href="${ut.getSiteToViewRule(sessionScope.account.roleId)}"><i class="fa fa-table purple_color2"></i> <span>Rule of apartment</span></a></li>

                            <li>
                                <a href="#apps" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-object-group blue2_color"></i> <span>Apps</span></a>
                                <ul class="collapse list-unstyled" id="apps">
                                    <li><a href="email.html">> <span>Email</span></a></li>
                                    <li><a href="calendar.html">> <span>Calendar</span></a></li>
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
                <!-- end sidebar -->
                <!-- right content -->
                <div id="content">

                    <!-- topbar -->
                    <div class="topbar">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <div class="full">
                                <button type="button" id="sidebarCollapse" class="sidebar_toggle"><i class="fa fa-bars"></i></button>
                                <div class="logo_section">
                                    <a href="index.jsp"><img class="img-responsive" src="images/logo/logo.png" alt="#" /></a>
                                </div>
                                <div class="right_topbar">
                                    <div class="icon_info">
                                        <ul>
                                            <li><a href="#"><i class="fa fa-bell-o"></i><span class="badge">2</span></a></li>
                                            <li><a href="#"><i class="fa fa-question-circle"></i></a></li>
                                            <li><a href="#"><i class="fa fa-envelope-o"></i><span class="badge">3</span></a></li>
                                        </ul>
                                        <ul class="user_profile_dd">
                                            <li>
                                                <a class="dropdown-toggle" data-toggle="dropdown"><img class="img-responsive rounded-circle" src="images/layout_img/user_img.jpg" alt="#" /><span class="name_user">User</span></a>
                                                <div class="dropdown-menu">
                                                    <a class="dropdown-item" href="${ut.getTableNameByRoleId(sessionScope.account.roleId)}">My Profile</a>
                                                    <a class="dropdown-item" href="settings.html">Settings</a>
                                                    <a class="dropdown-item" href="help.html">Help</a>
                                                    <a class="dropdown-item" href="logout"><span>Log Out</span> <i class="fa fa-sign-out"></i></a>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>
                    <div class="midde_cont">
                        <div class="container-fluid">

                            <div class="row">
                                <!-- table section -->
                                <div class="col-md-12">
                                    <div class="white_shd full margin_bottom_30">
                                        <div class="full graph_head">
                                            <div class="heading1 margin_0">
                                                <h2>Request history</h2>
                                            </div>
                                        </div>
                                        <div style="margin-left: 40px;">
                                            <form action="filterequest" method="post">
                                                <div class="row align-items-center">
                                                    <div class="col-md-2">
                                                        <input type="date" class="form-control" name="from" placeholder="From" value="${sessionScope.from}">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <input type="date" class="form-control" name="to" placeholder="To" value="${sessionScope.to}">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select class="form-control" name="typeRequest">
                                                            <c:choose>
                                                                <c:when test="${sessionScope.selectedType == null}">
                                                                    <option value="" disabled selected> --Select Type-- </option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${sessionScope.selectedType.id}" selected>${sessionScope.selectedType.name}</option>
                                                                     <option value="" > --Select Type-- </option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <c:forEach items="${requestScope.listType}" var="t">
                                                                <option value="${t.id}">${t.name}</option>
                                                            </c:forEach>
                                                            <!-- Add more options as needed -->
                                                        </select>
                                                    </div>




                                                    <div class="col-md-4 d-flex">
                                                        <button type="submit" class="btn btn-primary" style="margin-right: 5px;">Filter</button>
                                                        <a href=""  class="btn btn-primary">Create new Request</a>
                                                    </div>
                                                </div>

                                            </form>

                                        </div>





                                        <div class="table_section padding_infor_info">
                                            <div class="table-responsive-sm">
                                                <table class="table w-100">
                                                    <thead>
                                                        <tr>
                                                            <th>Creation Date</th>
                                                            <th>Response Date</th>
                                                            <th>Type</th>
                                                            <th>Executor</th>
                                                            <th>Description</th>                                               
                                                            <th>Status</th>


                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${requestScope.listRequest}" var="l">
                                                            <tr>
                                                                <td>${l.date}</td>
                                                                <td>
                                                                    <c:choose>
                                                                        <c:when test="${l.responseDate == null}">Not responded</c:when>
                                                                        <c:otherwise>${l.responseDate}</c:otherwise>
                                                                    </c:choose>
                                                                </td>

                                                                <td>${l.requestType.name}</td>
                                                                <td>${l.staffId.name}</td>                                               
                                                                <td>${l.detail}</td>
                                                                <td>
                                                                    <c:choose>
                                                                        <c:when test="${l.status == '0'}">In process</c:when>
                                                                        <c:when test="${l.status == '1'}">Done</c:when>
                                                                        <c:otherwise>Unknown</c:otherwise>
                                                                    </c:choose>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- More tables can be added here -->
                            </div>
                        </div>
                    </div>
                    <!-- end topbar -->
                    <!-- dashboard inner -->

                    <!-- end dashboard inner -->
                </div>
            </div>
        </div>
        <!-- jQuery -->
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