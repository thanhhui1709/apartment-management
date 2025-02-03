<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans&display=swap" rel="stylesheet">
    <title>News</title>
    <link rel="icon" href="images/fevicon.png" type="image/png" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="css/responsive.css" />
    <link rel="stylesheet" href="css/custom.css" />
    <style>
        body {

        }
        .news-list {
            padding-left: 20px; /* Kho?ng cách bên trái */
        }
        .news-list li {
            padding: 10px ; /* Padding cho t?ng m?c */
            font-size: 18px; /* T?ng kích th??c ch? cho t?ng m?c */
        }
        .news-list li a {
            text-decoration: none; /* B? g?ch chân */
            color: #007bff; /* Màu liên k?t */
        }
        .news-list li a:hover {
            color: #0056b3; /* Màu khi hover */
        }
        .graph_head {
            margin-bottom: 20px; /* Gi?m kho?ng cách d??i tiêu ?? */
        }
    </style>
</head>
<body class="inner_page news_page">
    <div class="full_container">
        <div class="inner_container">
            <%@ include file="sidebar.jsp" %>
            <div id="content">
                <%@ include file="topbar.jsp" %>
                <div class="midde_cont">
                    <div class="container-fluid">
                        <div class="row column_title">
                            <div class="col-md-12">
                                <div class="page_title">
                                    <h2>News List</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="white_shd full margin_bottom_30">
                                    <div class="full graph_head">
                                        <div class="heading1 margin_0">
                                            <h2>Recently news</h2>
                                        </div>
                                    </div>
                                    <div class="news_section">
                                        <ul class="news-list">
                                            <c:forEach items="${sessionScope.listNews}" var="n">
                                                <li>-${n.date}<a href="news-detail?id=${n.id}">: ${n.title}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container-fluid">
                        <div class="footer">
                            <p>Copyright © 2025 Designed by Your Company. All rights reserved.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>