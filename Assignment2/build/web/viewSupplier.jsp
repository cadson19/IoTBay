<%-- 
    Document   : viewSupplier
    Created on : 18 May 2023, 5:08:25 pm
    Author     : ecadd
--%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Supplier"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Suppliers</title>
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
        <%
            ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        %>
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
