<%-- 
<<<<<<<<< Temporary merge branch 1
    Document   : login
    Created on : 13 Jan 2025, 22:12:51
    Author     : Lenovo
=========
    Document   : login.jsp
    Created on : Jan 13, 2025, 11:16:47 PM
    Author     : PC
>>>>>>>>> Temporary merge branch 2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

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
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
            <div class="full_container">
                <div class="container">
                    <div class="center verticle_center full_height">
                        <div class="login_section">
                            <div class="logo_login">
                                <div class="center">
                                    <img width="210" src="images/logo/logo.png" alt="#" />
                                </div>
                            </div>
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
>>>>>>> Stashed changes

                            <div class="login_form">
                                <form action="login" method="post">
                                    <fieldset>
                                        <div class="field">
                                            <label class="label_field">Username</label>
                                            <input type="text" name="username" placeholder="Username" value="${cookie.rememberedUser.value}" />
                                        </div>
                                        <div class="field">
                                            <label class="label_field">Password</label>
                                            <input type="password" name="password" placeholder="Password" value="${cookie.rememberedPass.value}" />
                                        </div>
                                        <div class="field">
                                            <label class="label_field">Role</label>
                                            <span>
                                                <select id="role" name="role" class="form-control">
<<<<<<< Updated upstream
                                                    <c:forEach items="${sessionScope.rolelist}" var="o">
                                                        <option value="${o.id}" <c:if test="${o.id == cookie.rememberedRole.value}">selected</c:if> <c:if test="${null == cookie.rememberedRole.value}"><c:if test="${o.id == 1}">selected</c:if></c:if>>${o.name}</option>
                                                    </c:forEach>
=======
                                                    <option value="1" selected="">Resident</option>
                                                    <option value="2">Staff</option>
                                                    <option value="3">Employee</option>
>>>>>>> Stashed changes
                                                </select>
                                            </span>
                                            <a class="forgot" href="requestpassword.jsp">Forgotten Password?</a>
                                        </div>
                                        <div class="field remember-me" style="display: flex ;justify-content: start">
                                            <label  class="label_field" for="remember-checkbox">Remember Me</label>
                                            <input type="checkbox" name="remember" id="remember-checkbox" value="on" style="width: 10%" />
                                        </div>
<<<<<<< Updated upstream
                                        <h6 style="color:${status=="true"?"green":"red"};text-align:center ">${requestScope.message}</h6>
                                        <h6 style="color:red;text-align:center">${requestScope.error}</h6>
                                        <div class="field margin_0">
                                            <label class="label_field hidden">hidden label</label>
                                            <button class="main_bt" type="submit">Sign In</button>
                                            <div>
                                                <i class="fa fa-google" aria-hidden="true"></i>
                                                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:6969/apartment-management/login-google&response_type=code&client_id=356880565891-7ehq5ej4qae557jaoor4d4jdi8pi4586.apps.googleusercontent.com&approval_prompt=force">Sign In With Google<a/>
                                            </div>
=======
                                        <div class="field margin_0">
                                            <label class="label_field hidden">hidden label</label>
                                            <button class="main_bt" type="submit">Sign In</button>
>>>>>>> Stashed changes
                                        </div>
                                    </fieldset>
                                </form>

                            </div>

<<<<<<< Updated upstream
=======
=======
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
                                        <label class="form-check-label"><input type="checkbox" class="form-check-input"> Remember Me</label>
                                        <a class="forgot" href="requestpassword.jsp">Forgotten Password?</a>
                                        <h6 style="color:${status=="true"?"green":"red"};text-align:center ">${requestScope.message}</h6>
                                        <h6 style="color:red;text-align:center">${requestScope.error}</h6>
                                    </div>
                                    <div class="field margin_0">
                                        <label class="label_field hidden">hidden label</label>
                                        <button class="main_bt">Sign In</button>
                                        <button class="main_bt" type="submit">Sign In</button>
                                    </div>
                                </fieldset>
                            </form>
>>>>>>> Stashed changes
>>>>>>> Stashed changes
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