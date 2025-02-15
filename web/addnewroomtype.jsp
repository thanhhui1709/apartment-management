<%-- 
    Document   : addnewapartment
    Created on : Jan 23, 2025
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Apartment Management</title>
        <link rel="icon" href="images/fevicon.png" type="image/png" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
            }
            .form-container {
                background: #fff;
                padding: 40px;
                border-radius: 8px;
                max-width: 800px;
                margin: auto;
            }
            h1 {
                text-align: center;
                margin-bottom: 30px;
            }
            .form-group {
                margin-bottom: 20px;
            }
            .form-group label {
                display: block;
                margin-bottom: 8px;
                font-weight: bold;
            }
            .form-group input {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 6px;
            }
            .form-button {
                text-align: center;
                margin-top: 30px;
            }
            .form-button button {
                padding: 12px 25px;
                background-color: #4a90e2;
                color: #fff;
                cursor: pointer;
            }
            .form-button button:hover {
                background-color: #357ab8;
            }
        </style>
    </head>
    <body>
        <div class="full_container">
            <div class="inner_container">
                <%@include file="sidebar.jsp" %>
                <div id="content">
                    <%@include file="topbar.jsp" %>
                    <div class="container mt-5">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-container">
                                    <h1>Add New Room Type</h1>
                                    <form action="add-new-room-type" method="post">
                                        <div class="form-group"><label for="name">Name</label><input type="text" id="name" name="name" required /></div>
                                        <div class="form-group"><label for="limitPerson">Limit Person</label><input min="0" type="number" id="limitPerson" name="limitPerson" required /></div>
                                        <div class="form-group"><label for="square">Square</label><input min="0" step="any" type="number" id="square" name="square" required /></div>
                                        <div class="form-group"><label for="bedroom">Bedrooms</label><input min="0" type="number" id="bedroom" name="bedroom" required /></div>
                                        <div class="form-group"><label for="livingRoom">Living Rooms</label><input min="0" type="number" id="livingRoom" name="livingRoom" required /></div>
                                        <div class="form-group"><label for="bathroom">Bathrooms</label><input min="0" type="number" id="bathroom" name="bathroom" required /></div>
                                        <div class="form-group"><label for="balcony">Balconies</label><input min="0" type="number" id="balcony" name="balcony" required /></div>
                                        <div class="form-button">
                                            <button type="submit">Add</button>
                                            <h5 style="color:${status=="true"?"green":"red"};text-align:center ">${requestScope.message}</h5>
                                            <h5 style="color:red;text-align:center">${requestScope.error}</h5>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script src="js/jquery.min.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                </div>
            </div>
        </div>
    </body>
</html>