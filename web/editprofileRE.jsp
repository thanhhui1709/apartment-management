<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Profile</title>
        <link rel="icon" href="images/fevicon.png" type="image/png" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="css/custom.css" />
        <style> body {
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
                margin-bottom: 20px;
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
            }</style>
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
                                    <h1>Edit Profile</h1>
                                    <form action="editprofileREServlet" method="post">
                                        <div class="form-group">
                                            <div class="two-cols">
                                                <div class="col" style="padding: 0; margin-left: 5px">
                                                    <label for="email">Email:</label>
                                                    <input value="${sessionScope.person.email}" type="email" id="email" name="editProfileEmail" required />
                                                </div>
                                                <div class="col" style="padding: 0; margin-right: 5px">
                                                    <label for="phone">Phone:</label>
                                                    <input value="${sessionScope.person.phone}" type="text" id="phone" name="editProfilePhone" required pattern="[0-9]+" title="Phone number should contain only digits." />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="address">Address:</label>
                                            <input value="${sessionScope.person.address}" type="text" id="address" name="editProfileAddress" required />
                                        </div>
                                        <div class="form-button">
                                            <button type="submit">Save</button>
                                            <h5 style="color: ${requestScope.status == 'false'?'red': 'green'}">${requestScope.msg}</h5>
                                            <span  style="text-decoration: underline; display: inline-block"><a><a href="profile.jsp">Back</a></span>
                                        </div>
                                    </form>
                                </div>
                            </div>
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
