<%-- 
    Document   : logOut
    Created on : 15/05/2023, 1:58:26 AM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logout</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    

    <body>
        <!--Imports-->
        <%
        User user = (User) session.getAttribute("user");
        %>
        <!--End of Imports-->
        <!--IOTBay Header-->
        <div class="header">
            <p class="headerText">IOT Bay</p>
        </div>
        <div class="header2">
            <a href="deviceCatalogue.jsp" class="header2Button">LOGIN</a>
            <a href="order.jsp" class="header2Button">ORDER</a>
            <a href="main.jsp" class="header2Button">MAIN</a>
            <a href="logOut.jsp" class="header2Button">LOGOUT</a>
        </div>
        <!--End of IOTBay Header-->
        <!--Start of Content -->

        <h1 class="h1">Are you sure you want to log out?</h1>
        <form action="LogOutServlet">
            <input type="hidden" id="email" name="email" value="${user.email}"> <br>
            <div class="deleteBox">
                <a href="main.jsp" class="formButton">Cancel</a>
                <input type="submit" value="Logout" class="formButton" >
            </div> 
        </form>
        <!--End of Content -->

    </body>
</html>
