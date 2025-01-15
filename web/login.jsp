
    <%-- 
<<<<<<< HEAD
    Document   : login
    Created on : 13 Jan 2025, 22:12:51
    Author     : Lenovo
=======
    Document   : login.jsp
    Created on : Jan 13, 2025, 11:16:47 PM
    Author     : PC
>>>>>>> d700b0225ea6300d7147d934b2b1aab1fb873155
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    </head>
    <body class="inner_page login">

        <div class="full_container">
            <div class="container">
                <div class="center verticle_center full_height">
                    <div class="login_section">
                        <div class="logo_login">
                            <div class="center">
                                <img width="210" src="images/logo/logo.png" alt="#" />
                            </div>
                        </div>
                        <div class="login_form">
                            <form action="login" method="post">
                                <fieldset>
                                    <div class="field">
                                        <label class="label_field">Username</label>
                                        <input type="text" name="username" placeholder="Username" />
                                    </div>
                                    <div class="field">
                                        <label class="label_field">Password</label>
                                        <input type="password" name="password" placeholder="Password" />
                                    </div>
                                    <div class="field">
                                        <label class="label_field hidden">hidden label</label>
                                        <label class="form-check-label"><input type="radio" class="form-check-input" name="role" value="1"> Resident</label>
                                        <label class="form-check-label"><input type="radio" class="form-check-input" name="role" value="2"> Staff</label>
                                        <label class="form-check-label"><input type="radio" class="form-check-input" name="role" value="3"> Employee</label>
                                        <label class="form-check-label"><input type="checkbox" class="form-check-input"> Remember Me</label>
                                        <a class="forgot" href="requestpassword.jsp">Forgotten Password?</a>
                                        <h6 style="color:${status=="true"?"green":"red"};text-align:center ">${requestScope.message}</h6>
                                        <h6 style="color:red;text-align:center">${requestScope.error}</h6>
                                    </div>
                                    <div class="field margin_0">
                                        <label class="label_field hidden">hidden label</label>
                                        <button class="main_bt" type="submit">Sing In</button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
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
        <!-- nice scrollbar -->
        <script src="js/perfect-scrollbar.min.js"></script>
        <script>
            var ps = new PerfectScrollbar('#sidebar');
        </script>
        <!-- custom js -->
        <script src="js/custom.js"></script>
    </body>
</html>