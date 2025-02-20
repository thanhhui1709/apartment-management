<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Contract Detail</title>
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
                margin: 0;
                padding: 0;
                font-family: 'Roboto', sans-serif;
            }
            .contract-container {
                background: #ffffff;
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
                margin: 50px auto;
                max-width: 1200px;
            }
            .contract-title {
                color: #007bff;
                font-size: 36px;
                font-weight: bold;
                text-align: center;
                margin-bottom: 30px;
            }
            .row-field {
                display: flex;
                align-items: center;
                margin-bottom: 20px;
            }
            .field-label {
                flex: 1;
                font-weight: bold;
                color: #555;
            }
            .field-value {
                flex: 2;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
            }
            .contract-image {
                margin: 0;
                text-align: center;
            }
            .contract-image img {
                max-width: 100%; /* Ensure image is responsive */
                height: auto; /* Maintain aspect ratio */
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                cursor: pointer; /* Indicate clickable */
            }
            .back-button {
                text-align: center;
                margin-top: 30px;
            }
            #btn {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                font-size: 18px;
                transition: background-color 0.3s ease;
            }
            #btn:hover {
                background-color: #0056b3;
            }
            .modal-body img {
                width: 100%; /* Full width in the modal */
                max-height: 80vh; /* Limit height for better visibility */
                object-fit: contain; /* Keep aspect ratio */
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <%@ include file="sidebar.jsp" %>
                <!-- end sidebar -->
                <div id="content" class="col-md-12">
                    <%@ include file="topbar.jsp" %>
                    <!-- end topbar -->
                    <div class="contract-container">
                        <h2 class="contract-title">${requestScope.contract.title}</h2>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="row-field">
                                    <div class="field-label">Contract ID:</div>
                                    <div class="field-value">${requestScope.contract.id}</div>
                                </div>
                                <div class="row-field">
                                    <div class="field-label">Staff:</div>
                                    <div class="field-value">${requestScope.contract.staff.name}</div>
                                </div>
                                <div class="row-field">
                                    <div class="field-label">Admin:</div>
                                    <div class="field-value">${requestScope.contract.admin.name}</div>
                                </div>
                                <div class="row-field">
                                    <div class="field-label">Accountant:</div>
                                    <div class="field-value">${requestScope.contract.accountant.name}</div>
                                </div>
                                <div class="row-field">
                                    <div class="field-label">Company:</div>
                                    <div class="field-value">${requestScope.contract.company.name}</div>
                                </div>
                                <div class="row-field">
                                    <div class="field-label">Sign Date:</div>
                                    <div class="field-value">${requestScope.contract.signDate}</div>
                                </div>
                                <div class="row-field">
                                    <div class="field-label">Description:</div>
                                    <div class="field-value">${requestScope.contract.description}</div>
                                </div>
                            </div>
                            <div class="col-md-6 contract-image">
                                <strong>Image:</strong>
                                <br/>
                                <img src="images/avatar/anh.jpg" alt="Contract Image" data-toggle="modal" data-target="#imageModal" />
                            </div>
                        </div>
                        <div class="back-button">
                            <button id="btn" onclick="window.location = 'view-all-contract';">Back to Contract List</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="imageModal" tabindex="-1" role="dialog" aria-labelledby="imageModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="imageModalLabel">Contract Image</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <img src="images/avatar/anh.jpg" alt="Contract Image" />
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>