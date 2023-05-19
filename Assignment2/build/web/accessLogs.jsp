<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.AccessLog"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>

<!-- Author: Alexander Choi -->


<!-- Shows a users entire access log history-->
<html>
    <head>
        <title>Access Logs</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>

    <body>
        <!-- Import -->
        <%
            User user = (User) session.getAttribute("user");
            ArrayList<AccessLog> accesslogs = (ArrayList<AccessLog>) session.getAttribute("accesslogs");
        %>
        <!-- End of Imports -->

        <!--IOTBay Header-->
        <div class="header">
            <p class="headerText">IOT Bay</p>
        </div>
        <div class="header2">
            <a href="deviceCatalogue.jsp" class="header2Button">DEVICE CATALOGUE</a>
            <a href="order.jsp" class="header2Button">ORDER</a>
            <a href="main.jsp" class="header2Button">MAIN</a>
            <a href="logOut.jsp" class="header2Button">LOGOUT</a>
        </div>
        <!--End of IOTBay Header-->

        <!--Content -->
        <p class="h1"> All access logs for ${user.name} </p>
        <table class="mainTable">
            <thead>
                <th> User ID </th>
                <th> Action </th>
                <th> Date </th>
                <th> Time </th>
            </thead>
            <c:forEach items="${accesslogsall}" var="accesslog" >
                <tr>
                    <td><c:out value="${accesslog.email}"/></td>
                    <td><c:out value="${accesslog.action}"/> </td>
                    <td><c:out value="${accesslog.date}"/></td>
                    <td><c:out value="${accesslog.time}"/></td>
                    </tr>
                </c:forEach>
            </table>   
    </body>
</html>
