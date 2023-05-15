<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@page import="uts.isd.model.*" %>
<%-- 
    Document   : login
    Created on : 15/05/2023, 1:57:30 AM
    Author     : Alexander
--%>

<html>
    <head>
        <title>Index</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>


        <!--Imports-->
        <%
            String emptyError = (String) session.getAttribute("emptyError");
            String emailError = (String) session.getAttribute("emailError");
            String passwordError = (String) session.getAttribute("passwordError");
            String badLoginError = (String) session.getAttribute("badLoginError");
        %>
        <!--End of Imports-->
        
        <!--IOTBay Header-->
        <div class="header">
            <p class="headerText">IOT Bay</p>
        </div>
        <div class="header2">
            <a href="deviceCatalogue.jsp" class="header2ButtonAnon">CATALOGUE</a>
            <a href="order.jsp" class="header2ButtonAnon">ORDER</a>

        </div>
        <!--End of IOTBay Header-->
        <br>
        <!--Start of Content-->
        <div class="formBox">
            <p class="formTitle">LOG IN</p>
            <form action="LoginServlet" method="post">

                <label for="email" class="formParagraph">EMAIL ADDRESS</label>
                <br>

                <input type="text" id="fname"  name="email">
                <br>
                <br>
                <br>
                <label for="password" class="formParagraph">PASSWORD</label>
                <br>
                
                <input type="password" id="fname" name="password">
                <br>
                <br>
                <br>
                <a href="registerOption.jsp" class="formButton">REGISTER</a>
                <input type="submit" value="LOGIN" class="formButton" >
                <a href="index.jsp" class="formButton">GO BACK</a>
                <br>
                <p class="formError"> <%=(emptyError != null ? emptyError : "")%>  </p>
                <p class="formError"><%=(badLoginError != null ? badLoginError : "")%></p>
                <p class="formError"><%=(emailError != null ? emailError : "")%> </p>
                <p class="formError"><%=(passwordError != null ? passwordError : "")%></p>
            </form>
        </div>
        <!--End of Content-->
    </body>
</html>
