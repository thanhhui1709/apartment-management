<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.ApartmentDAO" %>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- site metas -->
        <title>Apartment management</title>        <link rel="icon" href="images/fevicon.png" type="image/png" />
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
        <link rel="stylesheet" href="<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />"/>
        <style>
            .table th, .table td {
                border: 1px solid rgba(0, 0, 0, 0.2);
            }
            .table {
                border-collapse: collapse;
            }
            .table th {
                text-align: center;
                background-color: #6B90DA;
                color: black;
            }
            .search-section {
                margin-bottom: 15px; /* Giảm khoảng cách giữa các phần tử */
            }
        </style>
    </head>
    <body class="inner_page tables_page">
        <jsp:useBean id="aptDAO" class="dao.ApartmentDAO" scope="page"/>
        <div class="full_container">
            <div class="inner_container">
                <%@include file="sidebar.jsp" %>
                <div id="content">
                    <%@include file="topbar.jsp" %>
                    <div class="midde_cont">
                        <div class="container-fluid">
                            <div class="row column_title">
                                <div class="col-md-12">
                                    <div class="page_title">
                                        <h2>My apartment</h2>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="white_shd full margin_bottom_30">
                                        <div class="full graph_head">
                                            <div class="heading1 margin_0">
                                                <h2>Apartment</h2>
                                            </div>
                                        </div>
                                        <div style="margin-left: 40px;">
                                            <form action="view-all-resident-apartment" method="GET">

                                            </form>
                                        </div>
                                        <div class="table_section padding_infor_info">
                                            <div class="table-responsive-sm">
                                                <table class="table w-100">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 10%;">Số Phòng</th>
                                                            <th style="width: 10%;">Số người ở</th>
                                                            <th style="width: 30%;">Tầng</th>
                                                            <th style="width: 30%;">Thông tin</th>
                                                            <th style="width: 5%;">Khác</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <h3>${requestScope.message}</h3>
                                                    <h3 style="color: red">${requestScope.error}</h3>
                                                    <c:forEach items="${sessionScope.listapartment}" var="listapartment">
                                                        <tr>
                                                            <td>${listapartment.id}</td>
                                                            <td>${listapartment.numberOfPerson}</td>
                                                            <td>${listapartment.floor.number}</td>
                                                            <td>${listapartment.infor}</td>
                                                            <td style="text-align: center">
                                                                    <a href="#" data-toggle="modal" data-target="#apartmentDetail${listapartment.id}">
                                                                        <i class="fa fa-home" aria-hidden="true"></i>
                                                                    </a>
                                                                   <a href="updatenopersonre?id=${listapartment.id}"><i class="fa-solid fa-pen-to-square"></i></a>   
                                                                </td>
                                                                
                                                        </tr>
                                                        <div id="apartmentDetail${listapartment.id}" class="modal fade">
                                                            <div class="modal-dialog" style="max-width: 30%">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h3>Apartment Information</h3>
                                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                    </div>
                                                                    <div class="modal-body" style="display: flex ">
                                                                        
                                                                        <div style="width: 50%;margin-left: 5%;">
                                                                            <p><strong>Loại phòng</strong> ${listapartment.roomtype.name}</p>
                                                                            <p><strong>Số người tối đa</strong> ${listapartment.roomtype.limitPerson}</p>
                                                                            <p><strong>Diện tích</strong> ${listapartment.roomtype.square}</p>
                                                                            <p><strong>Số phòng ngủ</strong> ${listapartment.roomtype.bedroom}</p>
                                                                            <p><strong>Số phòng khách</strong> ${listapartment.roomtype.livingRoom}</p>
                                                                            <p><strong>Số phòng tắm</strong> ${listapartment.roomtype.bathRoom}</p>
                                                                            <p><strong>Số ban công</strong> ${listapartment.roomtype.balcony}</p>
                                                                            
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                                            
                                                    </c:forEach>
                                                        <h6>A là mã phòng, sau A là số tầng, sau _ là số phòng</h6>

                                                    <!--                                                    <td>
                                                                                                            <a href="update-room-type?id=${room.id}"><i class="fa-solid fa-pen-to-square"></i></a>
                                                    <c:if test="${!aptDAO.getApartmentByRoomType(room.id)}">
                                                    <a href="delete-room-type?id=${room.id}"><i class="fa-solid fa-trash"></i></a>
                                                    </c:if>
                                            </td>-->
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--                    <form method="get" action="view-all-feedback" style="display: flex; align-items: center; gap: 10px;">
                                             Dropdown ch?n trang 
                                            <label for="page" style="font-size: 14px; font-weight: bold;">Trang:</label>
                                            <select id="page" name="page" onchange="this.form.submit()" 
                                                    style="padding: 6px 12px; font-size: 14px; border: 1px solid #ddd; border-radius: 4px; cursor: pointer;">
                    <c:forEach begin="1" end="${requestScope.totalPage}" var="page">
                        <option value="${page}" <c:if test="${page == requestScope.currentPage}">selected</c:if>>
                        ${page}
                    </option>
                    </c:forEach>
                </select>

                <input type="text" value="${param.searchName}" class="form-control" name="searchName" hidden="">
                <input type="date"  name="startDate" placeholder="Start Date" value="${param.startDate}" hidden="">
                <input type="date"  name="endDate" placeholder="End Date" value="${param.endDate}" hidden="">
                <input type="text"  name="endDate" placeholder="End Date" value="${param.serviceType}" hidden="">
            </form>-->
                    <div class="container-fluid">
                        <div class="footer">
                            <p>Copyright © 2018 Designed by html.design. All rights reserved.</p>
                        </div>
                    </div>
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