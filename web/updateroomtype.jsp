<%-- 
    Document   : updateroomtype.jsp
    Created on : Feb 14, 2025, 2:39:58 PM
    Author     : PC
--%>

<!DOCTYPE html>
<%@taglib
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
            <title>Apartment management</title>            <link rel="icon" href="images/fevicon.png" type="image/png" />
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
                body {
                    font-family: Arial, sans-serif;
                    background-color: #f4f4f9;
                    margin: 0;
                    padding: 0px;
                }

                .form-container {
                    background: #ffffff;
                    padding: 40px;
                    border-radius: 8px;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    max-width: 800px;
                    margin: auto;
                }

                .form-container h1 {
                    text-align: center;
                    margin-bottom: 30px;
                    color: #333;
                }

                .form-group {
                    margin-bottom: 10px;
                }

                .form-group label {
                    display: block;
                    margin-bottom: 8px;
                    font-weight: bold;
                    color: #555;
                }

                .form-group input,
                .form-group select {
                    width: 100%;
                    padding: 12px;
                    border: 1px solid #ccc;
                    border-radius: 6px;
                    font-size: 16px;
                    line-height: 1.5;
                    box-sizing: border-box;
                    transition: border-color 0.3s;
                }

                .form-group input:focus,
                .form-group select:focus {
                    border-color: #4a90e2;
                    outline: none;
                }

                .two-cols {
                    display: flex;
                    justify-content: space-between;
                }

                .form-button {
                    text-align: center;
                    margin-top: 30px;
                }

                .form-button button {
                    padding: 12px 25px;
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
                .error-message {
                color: red;
                font-size: 14px;
                margin-top: 5px;
            }

            </style>
        </head>
        <body class="inner_page tables_page">
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
                        <div class="midde_cont">
                            <div class="container-fluid">
                                <div class="form-container">
                                    <h1>Update Room Type Information</h1>
                                    <form action="update-room-type" method="post">
                                        <input type="text" id="id" name="id" value="${roomtype.id}" hidden=""/>
                                        <div class="form-group">
                                            <div class="one-col" style="padding: 0; margin-right: 5px">
                                                <label for="name">Name</label>
                                                <input
                                                    type="text"
                                                    id="name"
                                                    name="name"
                                                    placeholder="Enter name"
                                                    value="${roomtype.name}"
                                                    required=""
                                                    />
                                                <p class="error-message">${requestScope.nameError}</p>
                                            </div>
                                        </div>                                       
                                        <div class="form-group">
                                            <div class="two-cols">
                                                <div class="col" style="padding: 0; margin-right: 5px">
                                                    <label for="max-person">Max person</label>
                                                    <input
                                                        type="number"
                                                        id="max-person"
                                                        name="max-person"
                                                        min="0"
                                                        placeholder="Enter max person"
                                                        value="${roomtype.limitPerson}"
                                                        required=""
                                                        />
                                                    <p class="error-message">${requestScope.maxpersonError}</p>
                                                </div>
                                                <div class="col" style="padding: 0; margin-right: 5px">
                                                    <label for="square">Square</label>
                                                    <input
                                                        type="text"
                                                        id="square"
                                                        name="square"\
                                                        min="0"
                                                        step="any"
                                                        placeholder="Enter square"
                                                        value="${roomtype.square}"
                                                        required=""
                                                        />
                                                    <p class="error-message">${requestScope.squareError}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="two-cols">
                                                <div class="col" style="padding: 0; margin-right: 5px">
                                                    <label for="bedroom">Bedroom</label>
                                                    <input
                                                        type="number"
                                                        id="bedroom"
                                                        name="bedroom"
                                                        min="0"
                                                        placeholder="Enter number of bedroom"
                                                        value="${roomtype.bedroom}"
                                                        required=""
                                                        />
                                                    <p class="error-message">${requestScope.bedroomError}</p>
                                                </div>
                                                <div class="col" style="padding: 0; margin-right: 5px">
                                                    <label for="living-room">Living room</label>
                                                    <input
                                                        type="number"
                                                        id="living-room"
                                                        name="living-room"
                                                        min="0"
                                                        placeholder="Enter number of living room"
                                                        value="${roomtype.livingRoom}"
                                                        required=""
                                                        />
                                                    <p class="error-message">${requestScope.livingroomError}</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="two-cols">
                                                <div class="col" style="padding: 0; margin-right: 5px">
                                                    <label for="bath-room">Bath room</label>
                                                    <input
                                                        type="number"
                                                        id="bath-room"
                                                        name="bath-room"
                                                        min="0"
                                                        placeholder="Enter number of bath room"
                                                        value="${roomtype.bathRoom}"
                                                        required=""
                                                        />
                                                    <p class="error-message">${requestScope.bathroomError}</p>
                                                </div>
                                                <div class="col" style="padding: 0; margin-right: 5px">
                                                    <label for="balcony">Balcony</label>
                                                    <input
                                                        type="number"
                                                        id="balcony"
                                                        name="balcony"
                                                        min="0"
                                                        placeholder="Enter number of balcony"
                                                        value="${roomtype.balcony}"
                                                        required=""
                                                        />
                                                    <p class="error-message">${requestScope.balconyError}</p>
                                                </div>
                                            </div>
                                        </div>                                        
                                        <div class="form-button">
                                            <button type="submit">Update</button>
                                            <h5 style="color:${status=="true"?"green":"red"};text-align:center ">${requestScope.message}</h5>
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
        </body>
    </html>
