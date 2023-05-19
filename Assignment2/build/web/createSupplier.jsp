<%-- 
    Document   : createSupplier
    Created on : 18 May 2023, 6:31:55 pm
    Author     : ecadd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Suppliers</title>
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
    <div class="formBox">
        <p class="formTitle">Create A Supplier</p>
        <form action="SupplierCreateServlet" method="post">
            <label for="Supplier Company Name" class="formParagraph">Contact Name</label>
            <br>
            <input type="text" id="inputContactName"  name="createContactName">
            <br>
            <label for="Supplier Company Name" class="formParagraph">Company Name</label>
            <br>
            <input type="text" id="inputCompanyName"  name="createCompanyName">
            <br>
            <label for="Supplier Email" class="formParagraph">Email</label>
            <br>
            <input type="text" id="inputEmail"  name="createEmail">
            <br>
            <label for="Supplier Address" class="formParagraph">Address</label>
            <br>
            <input type="text" id="inputAddress"  name="createAddress">
            <br>
            <label for="Supplier Status" class="formParagraph">Status</label>
            <br>
            <input type="text" id="inputStatus"  name="createStatus">
            <br>
            <button type="submit">Create</button>
        </form>
    </div>
</html>
