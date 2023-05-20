<%-- 
    Document   : createOrder
    Created on : 18/05/2023, 3:46:26 PM
    Author     : fatin
--%>
<%@page import="uts.isd.model.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <title>Create an Order</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
   <body>
    <div class="header">
            <p class="headerText">IOT Bay</p>
        </div>
        <div class="header2">
            <a href="deviceCatalogue.jsp" class="header2ButtonAnon">CATALOGUE</a>
            <a href="createOrder.jsp" class="header2ButtonAnon">ORDER</a>
            <a href="main.jsp" class="header2Button">MAIN</a>
            <a href="logOut.jsp" class="header2Button">LOGOUT</a>
        </div>
        <!--End of IOTBay Header-->
        <br>
        <!--Start of Content-->
        <div class="formBox">
         <p class="formTitle" >Create Order </p>
        <form method="post" action="CreateOrderServlet">
        <label for="product">Product:</label>
        <input type="text" id="productId" name="productId" required><br><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="orderQuantity" required><br><br>
        
          <input class="formButton" type="submit" value="SUBMIT">
        <a href="main.jsp" class="formButton">GO BACK</a>
   

    </form>
</body>
</html>