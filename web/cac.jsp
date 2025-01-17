<%-- 
    Document   : cac
    Created on : Jan 18, 2025, 10:45:33 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${requestScope.listResident}" var="resident">
              <th>${resident.pId}</th>
                                                                <th>${resident.name}</th>
                                                                <th>${resident.bod}</th>
                                                                <th>${resident.phone}</th>
                                                                <th>${resident.email}</th>                                               
                                                                <th>${resident.address}</th>
                                                                <th>${resident.status}</th>
                                                                <td><a href="details.html?user=mary" class="btn btn-primary">View Detail</a></td> <!-- Link đến chi tiết -->
        </c:forEach>
</html>
