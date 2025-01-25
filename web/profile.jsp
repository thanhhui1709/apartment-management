<%@ page import="util.Util"%> 
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
        <title>Pluto - Responsive Bootstrap Admin Panel Templates</title>
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
        <!-- calendar file css -->
        <link rel="stylesheet" href="js/semantic.min.css" />
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
        <style>
            .form-container {
                margin-top: 20px;
                padding: 15px;
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 10px;
                max-width: 400px;
            }

            .form-container label {
                font-weight: bold;
                font-size: 14px;
                color: #333;
                margin-bottom: 5px;
                display: inline-block;
            }

            .form-container input[type="text"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 14px;
                background-color: #fff;
                box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
            }

            .form-container button {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 10px 15px;
                font-size: 14px;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .form-container button:hover {
                background-color: #0056b3;
            }

            .profile_img img {
                border: 2px solid #007bff;
                padding: 5px;
            }

            .action-button {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 10px 15px;
                font-size: 14px;
                cursor: pointer;
                border-radius: 5px;
                transition: background-color 0.3s ease;
                margin-right: 10px;
            }

            .action-button:hover {
                background-color: #0056b3;
            }
        </style>

    </head>
    <body class="inner_page profile_page">
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
                                    <a href="index.html"><img class="img-responsive" src="images/logo/logo.png" alt="#" /></a>
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
                                                    <a class="dropdown-item" href="profile.jsp">My Profile</a>
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
                    <!-- dashboard inner -->
                    <div class="midde_cont">
                        <div class="container-fluid">
                            <div class="row column_title">
                                <div class="col-md-12">
                                    <div class="page_title">
                                        <h2>Profile</h2>
                                    </div>
                                </div>
                            </div>
                            <!-- row -->
                            <div class="row column1">
                                <div class="col-md-2"></div>
                                <div class="col-md-8">
                                    <div style="width: 100% " class="white_shd full margin_bottom_30">
                                        <div class="full graph_head">
                                            <div class="heading1 margin_0">
                                                <h2>${requestScope.resident.name}</h2>
                                            </div>
                                        </div>
                                        <div class="full price_table padding_infor_info">
                                            <div class="row">
                                                <!-- User profile section -->
                                                <div class="col-lg-12">
                                                    <div class="full dis_flex center_text">
                                                        <div class="profile_img">
                                                            <img width="180" class="rounded-circle" src="images/layout_img/user_img.jpg" alt="#" />
                                                        </div>
                                                        <div class="profile_contant">
                                                            <div class="contact_inner">
                                                                <h3>${sessionScope.person.name}</h3>
                                                                <p><strong>About: </strong>Resident</p>
                                                                <ul class="list-unstyled">
                                                                    <li><i class="fa-regular fa-envelope"></i>: ${sessionScope.person.email}</li>
                                                                    <li><i class="fa fa-phone"></i>: ${sessionScope.person.phone}</li>
                                                                    <li><i class="fa-solid fa-house"></i>: ${sessionScope.person.address}</li>
                                                                    <li><i class="fa-regular fa-user"></i>: ${sessionScope.person.cccd}</li>
                                                                    <li><i class="fa-solid fa-calendar-days"></i>: ${sessionScope.person.bod}</li>
                                                                </ul>
                                                                <li>
                                                                    <button class="action-button" onclick="toggleChangepw2()">Change profile</button>
                                                                    <jsp:useBean id="ut" class="util.UtilEdit" scope="page" />
                                                                    <div style="display: none" id="hiddenChangeprofile" class="form-container">
                                                                        <form action="${ut.getTableNameByRoleIdEdit(sessionScope.account.roleId)}" method="post">
                                                                            <label for="input1">Email:</label>
                                                                            <input value="${sessionScope.person.email}" type="text" id="input1" name="editprofileemail" required />
                                                                            <label for="input1">Phone:</label>
                                                                            <input value="${sessionScope.person.phone}" type="text" id="input1" name="editprofilephone" required />
                                                                            <label for="input2">Address:</label>
                                                                            <input value="${sessionScope.person.address}" type="text" id="input2" name="editprofileaddress" required />
                                                                            <button type="submit">Save</button>
                                                                            <p>${requestScope.msg}</p>
                                                                        </form>
                                                                    </div>
                                                                    <button class="action-button" onclick="toggleChangepw()">Change password</button>
                                                                    <div style="display: none" id="hiddenChangepw" class="form-container">
                                                                        <form action="update-password-resident" method="post">
                                                                            <label for="input1">Old password:</label>
                                                                            <input type="text" id="input1" name="oldpassword" required />
                                                                            <label for="input2">New password:</label>
                                                                            <input type="text" id="input2" name="newpassword" required />
                                                                            <button type="submit">Save</button>
                                                                            <p>${requestScope.msg}</p>
                                                                        </form>
                                                                    </div>
                                                                </li>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-md-2"></div>
                                </div>
                                <!-- end row -->
                            </div>
                            <!-- footer -->
                        </div>
                        <!-- end dashboard inner -->
                    </div>
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
        <!-- calendar file css -->    
        <script src="js/semantic.min.js"></script>
    </body>
    <script>
                                                                        function toggleChangepw() {
                                                                            const form = document.getElementById("hiddenChangepw");
                                                                            if (form.style.display === "none" || form.style.display === "") {
                                                                                form.style.display = "block";
                                                                            } else {
                                                                                form.style.display = "none";
                                                                            }
                                                                        }
                                                                        function toggleChangepw2() {
                                                                            const form = document.getElementById("hiddenChangeprofile");
                                                                            if (form.style.display === "none" || form.style.display === "") {
                                                                                form.style.display = "block";
                                                                            } else {
                                                                                form.style.display = "none";
                                                                            }
                                                                        }
    </script>
</html>