<%-- 
    Document   : searchSupplier
    Created on : 18 May 2023, 6:30:31 pm
    Author     : ecadd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Suppliers</title>
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
        <p class="formTitle">Search Suppliers</p>
        <form action="SupplierSearchServlet">
            <label for="Supplier Company Name" class="formParagraph">Contact Name</label>
            <br>
            <input type="text" id="inputContactName"  name="findContactName">
            <br>
            <label for="Supplier Company Name" class="formParagraph">Company Name</label>
            <br>
            <input type="text" id="inputCompanyName"  name="findCompanyName">
            <br>
            <button type="submit">Search</button>
        </form>
    </div>
    <table class="mainTable">
            <thead>
                
                    <th>Contact Name</th>
                    <th>Company Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Status</th>
                
            </thead>
            <tbody>
                <c:forEach items="${suppliers}" var="supplier">
                    <tr>
                        <td><c:out value="${supplier.contactName}"/></td>
                        <td><c:out value="${supplier.companyName}"/></td>
                        <td><c:out value="${supplier.email}"/></td>
                        <td><c:out value="${supplier.address}"/></td>
                        <td><c:out value="${supplier.status}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
         </table>
</html>
