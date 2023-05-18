<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : userDelete
    Created on : 15/05/2023, 1:54:30 AM
    Author     : Alexander
--%>
<html>
    <head>
        <title>Delete Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <!--Imports -->

        <%
            User user = (User) session.getAttribute("user");
            String updated = (String) session.getAttribute("updated");
            String emptyErrUam = (String) session.getAttribute("emptyErrUam");
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String UsernameErr = (String) session.getAttribute("UsernameErr");
            String numberErr = (String) session.getAttribute("numberErr");
            String phoneError = (String) session.getAttribute("phoneError");
        %>
        <!--End of Imports-->
        <<!--IOTBay Header-->
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
        
        
        
        <h1 class="h1">Are you sure you want to deactivate your account?</h1>
        
        <form action="UserDeleteController">
            <input type="hidden" id="email" name="email" value="${user.email}" readonly> <br>
            <input type="hidden" id="name" name="name" value="${user.name}" readonly> <br>
            <input type="hidden" id="password" name="password" value="${user.password}"><br>
            <input type="hidden" id="ID" name="ID" value="${user.ID}" ><br>
            <input type="hidden" id="role" name="role" value="${user.role}" ><br>
            <input type="hidden" id="phone" name="phone" value="${user.phone}" ><br>
            <div class="deleteBox">
                <a href="main.jsp" class="formButton">Cancel</a>
                <input type="submit" value="Delete" class="formButton" >
            </div>
            
        </form>
            
            
            
            
            
            
            
            
            


        <!--End of Content -->
    </body>

</html>
