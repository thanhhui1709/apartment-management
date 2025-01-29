
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
                <%@include file="sidebar.jsp" %>
                <!-- end sidebar -->
                <!-- right content -->
                <div id="content">

                    <!-- topbar -->
                    <%@include file="topbar.jsp" %>
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
        <script src="js/custom.js"></script>
    </body>
</html>