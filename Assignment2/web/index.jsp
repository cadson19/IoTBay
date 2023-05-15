<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<%-- 
    Document   : index
    Created on : 15/05/2023, 1:58:30 AM
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
        <!--IOTBay Header-->
        <div class="header">
            <p class="headerText">IOT Bay</p>
        </div>
        <div class="header2">
            <a href="deviceCatalogue.jsp" class="header2ButtonAnon">CATALOGUE</a>
            <a href="order.jsp" class="header2ButtonAnon">ORDER</a>

        </div>
        <!--End of IOTBay Header-->
        
        <!--Start of Content-->
        <div class="centreBox">
            <div>
                <a href="login.jsp" class="indexButton">LOGIN</a>
            </div>
            <div>
                <a href="registerOption.jsp" class="indexButton">REGISTER</a>
            </div>
        </div>
        <!--End of Content-->

        

        <jsp:include page="/ConnServlet" flush="true"/>
            

    </body>
</html>
