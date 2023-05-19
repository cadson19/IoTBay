<%-- 
    Document   : manageSupplier
    Created on : 18 May 2023, 1:27:30 pm
    Author     : ecadd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Supplier</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
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
        <form action="SupplierViewServlet">
            <button type="submit" class="mainButton">View Supplier Records</button>
        </form>
        <form action="SupplierSearchServlet">
            <button type="submit" class="mainButton">Search Supplier Records</button>
        </form>
        <form action="SupplierCreateServlet">
            <button type="submit" class="mainButton">Create Supplier Record</button>
        </form>
        <form action="SupplierDeleteServlet">
            <input type="hidden" name="email" value="${user.email}">
            <input type="hidden" name="password" value="${user.password}">
            <input type="hidden" name="role" value="${user.role}">
            <button type="submit" class="mainButton">Update / Delete Record</button>
        </form>
</html>
