<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib
    prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">
        <head>
            <!-- basic -->
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <!-- mobile metas -->
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <meta name="viewport" content="initial-scale=1, maximum-scale=1" />
            <!-- site metas -->
            <title>Pluto - Responsive Bootstrap Admin Panel Templates</title>
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
            <!-- calendar file css -->
            <link rel="stylesheet" href="js/semantic.min.css" />
            <!-- fancy box js -->
            <link rel="stylesheet" href="css/jquery.fancybox.css" />
            <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
              <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
            <style>
                .form-container {
                    width: 100%;
                    max-width: 900px;
                    margin: 50px auto;
                    background: #ffffff;
                    padding: 40px;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    border-radius: 8px;
                    border: 1px solid #e3e3e3;
                }
                .form-container h1 {
                    text-align: center;
                    margin-bottom: 30px;
                    font-size: 28px;
                    color: #333;
                }
                .form-group {
                    margin-bottom: 20px;
                    width: 100%;
                }
                .form-group label {
                    display: block;
                    font-weight: 600;
                    margin-bottom: 8px;
                    color: #666;
                }
                .form-group input {
                    width: 100%;
                    padding: 15px;
                    border: 1px solid #ccc;
                    border-radius: 6px;
                    font-size: 16px;
                    color: #333;
                }
                .form-group input:focus {
                    border-color: #4a90e2;
                    outline: none;
                    box-shadow: 0 0 4px rgba(74, 144, 226, 0.5);
                }
                .two-cols {
                    display: flex;
                    justify-content: space-between;
                }
                .two-cols .col {
                    width: 48%;
                }
                .three-cols {
                    display: flex;
                    justify-content: space-between;
                }
                .three-cols .col {
                    width: 32%;
                }
                .form-button {
                    text-align: center;
                    margin-top: 30px;
                }
                .form-button button {
                    padding: 15px 30px;
                    font-size: 18px;
                    border: none;
                    border-radius: 6px;
                    background-color: #4a90e2;
                    color: #ffffff;
                    cursor: pointer;
                    transition: background-color 0.3s;
                }
                .form-button button:hover {
                    background-color: #357ab8;
                }
            </style>
        </head>
        <body class="inner_page tables_page">
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
                                     <jsp:useBean id="ut" class="util.Util" scope="page"/>
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
                        <!-- end topbar -->
                        <div class="midde_cont">
                            <div class="container-fluid">
                                <div class="form-container">
                                    <h1>Add New Resident</h1>
                                    <form action="addNewResident">
                                        <div class="form-group">
                                            <div class="two-cols">
                                                <div class="col">
                                                    <label for="name">Name</label>
                                                    <input
                                                        type="text"
                                                        id="name"
                                                        name="name"
                                                        placeholder="Enter full name"
                                                        required
                                                        />
                                                </div>
                                                <div class="col">
                                                    <label for="dob">Date of Birth</label>
                                                    <input type="date" id="dob" name="dob" required />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="one-col">
                                                <label for="address">Address</label>
                                                <input
                                                    type="text"
                                                    id="address"
                                                    name="address"
                                                    placeholder="Enter address"
                                                    required
                                                    />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="two-cols">
                                                <div class="col">
                                                    <label for="phone">Phone</label>
                                                    <input
                                                        type="tel"
                                                        id="phone"
                                                        name="phone"
                                                        placeholder="Enter phone number"
                                                        required
                                                        />
                                                    <span id="phone-error" style="color: red"></span>
                                                </div>
                                                <div class="col">
                                                    <label for="email">Email</label>
                                                    <input
                                                        type="email"
                                                        id="email"
                                                        name="email"
                                                        placeholder="Enter email"
                                                        required
                                                        />
                                                    <span id="email-error" style="color: red"></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="three-cols">
                                                <div class="col">
                                                    <label for="id">ID</label>
                                                    <input
                                                        type="text"
                                                        id="id"
                                                        name="id"
                                                        placeholder="Enter ID"
                                                        required
                                                        />
                                                    <span id="id-error" style="color: red"></span>
                                                </div>
                                                <div class="col">
                                                    <label for="username">Username</label>
                                                    <input
                                                        type="text"
                                                        id="username"
                                                        name="username"
                                                        placeholder="Enter username"
                                                        required
                                                        />
                                                    <span id="username-error" style="color: red"></span>
                                                </div>
                                                <div class="col">
                                                    <label for="password">Password</label>
                                                    <input
                                                        type="password"
                                                        id="password"
                                                        name="password"
                                                        placeholder="Enter password"
                                                        required
                                                        />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-button">
                                            <button type="submit">Add Resident</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- end dashboard inner -->
                    </div>
                </div>
                <!-- jQuery -->
                <script src="js/jquery.min.js"></script>
                <script src="js/popper.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/custom.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script>
                    $(document).ready(function () {
                        const submitButton = $('button[type="submit"]');

                        // Function to update the submit button's disabled state
                        function updateSubmitButtonState() {
                            if (
                                    $("#email-error").text() ||
                                    $("#phone-error").text() ||
                                    $("#id-error").text() ||
                                    $("#username-error").text()
                                    ) {
                                submitButton.prop("disabled", true);
                            } else {
                                submitButton.prop("disabled", false);
                            }
                        }

                        $("#email").on("input", function () {
                            var email = $(this).val();
                            if (email) {
                                $.ajax({
                                    url: "checkDuplicateInfor",
                                    type: "GET",
                                    data: {type: "email", value: email},
                                    success: function (response) {
                                        if (response.exists) {
                                            $("#email-error").text("Email already exists.");
                                        } else {
                                            $("#email-error").text("");
                                        }
                                        updateSubmitButtonState();
                                    }
                                });
                            } else {
                                $("#email-error").text("");
                                updateSubmitButtonState();
                            }
                        });

                        $("#phone").on("input", function () {
                            var phone = $(this).val();
                            if (phone) {
                                $.ajax({
                                    url: "checkDuplicateInfor",
                                    type: "GET",
                                    data: {type: "phone", value: phone},
                                    success: function (response) {
                                        if (response.exists) {
                                            $("#phone-error").text("Phone number already exists.");
                                        } else {
                                            $("#phone-error").text("");
                                        }
                                        updateSubmitButtonState();
                                    }
                                });
                            } else {
                                $("#phone-error").text("");
                                updateSubmitButtonState();
                            }
                        });

                        $("#id").on("input", function () {
                            var id = $(this).val();
                            if (id) {
                                $.ajax({
                                    url: "checkDuplicateInfor",
                                    type: "GET",
                                    data: {type: "id", value: id},
                                    success: function (response) {
                                        if (response.exists) {
                                            $("#id-error").text("ID already exists.");
                                        } else {
                                            $("#id-error").text("");
                                        }
                                        updateSubmitButtonState();
                                    }
                                });
                            } else {
                                $("#id-error").text("");
                                updateSubmitButtonState();
                            }
                        });

                        $("#username").on("input", function () {
                            var username = $(this).val();
                            if (username.includes(" ")) {
                                $("#username-error").text("Username cannot contain spaces.");
                            } else {
                                $.ajax({
                                    url: "checkDuplicateInfor",
                                    type: "GET",
                                    data: {type: "username", value: username},
                                    success: function (response) {
                                        if (response.exists) {
                                            $("#username-error").text("Username already exists.");
                                        } else {
                                            $("#username-error").text("");
                                        }
                                        updateSubmitButtonState();
                                    }
                                });
                            }
                            updateSubmitButtonState();
                        });
                    });
                </script>

        </body>
    </html>
