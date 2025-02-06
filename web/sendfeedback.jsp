<%-- 
    Document   : sendfeedback
    Created on : 25 Jan 2025, 13:43:41
    Author     : NCPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="util.Util"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
<title>Apartment management</title>        <meta name="keywords" content="">
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
    <body>
        <div class="full_container">
            <div class="inner_container">
                <!-- Sidebar  -->
                <%@include file="sidebar.jsp" %>
                <!-- end sidebar -->
                <!-- right content -->
                <div id="content">

                    <!-- topbar -->
                    <%@include file="topbar.jsp" %>
                    <!-- end topbar -->


                    <div class="container mt-5">
                        <div class="card shadow-sm p-4" style="height: 50%;">
                            <h4 class="mb-4 text-center">Submit Your Feedback</h4>
                            <form action="sendfeedback" method="post">
                                <!-- Hidden rID field -->
                                <input type="hidden" name="rID" value="${rID}">

                                <!-- Type of Request Dropdown -->
                                <div class="form-group">
                                    <label for="typeOfRequest" class="font-weight-bold">Type of Request</label>
                                    <select id="typeOfRequest" name="typeOfRequest" class="form-control" required>
                                        <option value="" disabled selected>--Select type--</option>
                                        <c:forEach items="${requestScope.listOfTypeRequest}" var="tr">
                                            <option value="${tr.id}">${tr.name}</option>
                                        </c:forEach>
                                    </select>
                                    <br>
                                    <label for="content" class="font-weight-bold">Feedback Details</label>
                                    <div class="d-flex justify-content-center">
                                        <textarea 
                                            name="content" 
                                            maxlength="200" 
                                            class="form-control" 
                                            placeholder="Write your feedback here (max 200 characters)..." 
                                            style="resize: none;  height: 50vh; max-height: 50vh;" 
                                            required></textarea>
                                    </div>
                                    <small class="form-text text-muted text-center">Maximum 200 characters.</small>

                                    <!-- Submit Button -->
                                    <div class="text-center mt-3">
                                        <button type="submit" name="name" class="btn btn-primary btn-lg">Submit Feedback</button>
                                    </div>
                                </div>

                        </div>



                    </div>
                    <!-- end dashboard inner -->
                </div>
            </div>
            <!-- jQuery ->->
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
