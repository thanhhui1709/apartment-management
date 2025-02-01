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

            .form-container input[type="text"],
            .form-container input[type="password"] {
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

            .change-password-container {
                background-color: #f9f9f9; /* A lighter background color for contrast */
                border: 1px solid #007bff; /* Highlight border for password section */
                margin-top: 20px;
            }

            .change-password-container label {
                color: #007bff; /* Matching the highlight border color */
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
        <jsp:useBean id="ut" class="util.Util" scope="page"/>
        <div class="full_container">
            <div class="inner_container">
                <!-- Sidebar  -->
                <%@include file="sidebar.jsp" %>
                <!-- end sidebar -->
                <!-- right content -->
                <div id="content">
                    <%@include file="topbar.jsp" %>
                    <div class="midde_cont">
                        <div class="container-fluid">
                            <div class="row column_title">
                                <div class="col-md-12">
                                    <div class="page_title">
                                        <h2>Profile</h2>
                                    </div>
                                </div>
                            </div>
                            <div class="row column1">
                                <div class="col-md-8 offset-md-2">
                                    <div class="white_shd full margin_bottom_30">
                                        <div class="full graph_head">
                                            <div class="heading1 margin_0">
                                                <h2>${sessionScope.person.name}</h2>
                                            </div>
                                        </div>
                                        <div class="full price_table padding_infor_info">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <div class="full dis_flex center_text">
                                                        <div class="profile_img">
                                                            <img width="180" class="rounded-circle" src="images/layout_img/user_img.jpg" alt="User Image">
                                                        </div>
                                                        <div class="profile_contant">
                                                            <div class="contact_inner">
                                                                <h3>${sessionScope.person.name}</h3>
                                                                <p><strong>About: </strong>Resident</p>
                                                                <ul class="list-unstyled">
                                                                    <li><i class="fa-regular fa-envelope"></i> ${sessionScope.person.email}</li>
                                                                    <li><i class="fa fa-phone"></i> ${sessionScope.person.phone}</li>
                                                                    <li><i class="fa-solid fa-house"></i> ${sessionScope.person.address}</li>
                                                                    <li><i class="fa-regular fa-user"></i> ${sessionScope.person.cccd}</li>
                                                                    <li><i class="fa-solid fa-calendar-days"></i> ${sessionScope.person.bod}</li>

                                                                </ul>
                                                                    <h6><a href="${ut.getTableNameByRoleIdEdit(sessionScope.account.roleId)}" class="button">Edit profile</a></h6>
                                                                

                                                                <button class="action-button" onclick="toggleVisibility('hiddenChangePassword')">Change Password</button>

                                                                
                                                                <div id="hiddenChangePassword" class="form-container" style="display: none;">
                                                                    <form action="update-password-resident" method="post">
                                                                        <label for="oldPassword">Old Password:</label>
                                                                        <input type="password" id="oldPassword" name="oldPassword" required>
                                                                        <label for="newPassword">New Password:</label>
                                                                        <input type="password" id="newPassword" name="newPassword" required>
                                                                        <button type="submit">Save</button>
                                                                        <p>${requestScope.msg}</p>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Footer -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

</html>