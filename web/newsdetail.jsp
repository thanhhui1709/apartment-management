<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>News Detail</title>
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <style>
            body {
                background-color: #f8f9fa;
                margin: 0;
                padding: 0;
            }
            .news-container {
                background: #ffffff;
                padding: 50px; /* Padding cho h?p */
                border-radius: 10px; /* Bo góc */
                box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
                width: 100%; /* Chi?m toàn b? chi?u r?ng */
                margin: 50px 0; /* Gi?a trang theo chi?u d?c */
                transition: transform 0.3s;
            }
            .news-container:hover {
                transform: translateY(-5px);
            }
            .news-title {
                text-align: center;
                margin-bottom: 25px; /* Kho?ng cách d??i tiêu ?? */
                color: #343a40;
                font-size: 36px; /* Kích th??c tiêu ?? */
                font-weight: bold;
            }
            .news-date {
                text-align: center;
                color: #6c757d;
                margin-bottom: 30px;
                font-size: 20px; /* Kích th??c ngày */
            }
            .news-content {
                font-size: 22px; /* Kích th??c n?i dung */
                line-height: 1.8;
                color: #495057;
                padding: 15px; /* Padding cho n?i dung */
                border-left: 4px solid #007bff;
                background-color: #f8f9fa;
                margin-bottom: 30px;
            }
            .related-links {
                margin-top: 30px;
            }
            .related-links h3 {
                margin-bottom: 15px;
                color: #343a40;
            }
            .related-links ul {
                list-style-type: none;
                padding: 0;
            }
            .related-links li {
                margin-bottom: 10px;
            }
            .related-links a {
                text-decoration: none;
                color: #007bff;
                transition: color 0.3s;
            }
            .related-links a:hover {
                color: #0056b3;
            }
            .back-button {
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <div class="full_container">
            <div class="inner_container">
                <%@ include file="sidebar.jsp" %>
                <!-- end sidebar -->
                <!-- right content -->
                <div id="content">
                    <!-- topbar -->
                    <%@ include file="topbar.jsp" %>
                    <!-- end topbar -->
                    <!-- News Detail -->
                    <div class="container-fluid mt-5"> 
                        <div class="row">
                            <div class="col-12"> 
                                <div class="news-container">

                                    <h1 class="news-title" style="color: #004175; font-size: 30px">${requestScope.news.title}</h1>
                                    <p class="news-date">Date: February 1, 2025</p>
                                    <div class="news-content">
                                        ${requestScope.news.content}
                                    </div>
                                    <div class="related-links">
                                        <h5>Related Articles</h5>
                                        <ul>
                                            <c:forEach items="${requestScope.listOtherNews}" var="n">
                                                <li><a href="news-detail?id=${n.id}">${n.title}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                    <div class="back-button">
                                        <a href="view-news" class="btn btn-primary">Back to News List</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end news detail -->
                </div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>