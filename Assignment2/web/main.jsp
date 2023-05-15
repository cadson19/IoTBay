<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.AccessLog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : main
    Created on : 15/05/2023, 1:58:05 AM
    Author     : Alexander
--%>

<html>
    <head>
        <title>Main</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>


    <body>
        <!-- Imports -->
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
        
        <!-- Content-->
        
        
        
        <div>
            <br>

            <table class="mainTable">
                <thead>
                <th colspan="2" style="text-align: center;">Account Information</th>
                </thead>
                <tr>
                    <td>Name</td>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>${user.password}</td>
                </tr>
                <tr>
                    <td>User ID</td>
                    <td>${user.ID}</td>
                </tr>
                <tr>
                    <td>Account Status</td>
                    <td>${user.status}</td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td>${user.role}</td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td>${user.phone}</td>
                </tr>

            </table>

            
            <div class="buttonContainer">
                <a class="mainButton" href="UserEditServlet"?email='<%= user.getEmail()%>' &name='<%= user.getName()%>' &password='<%= user.getPassword()%>' &ID='<%= user.getID()%>' &status='<%= user.getStatus()%>' &role='<%= user.getRole()%>' &phone='<%= user.getPhone()%>'">
                    <p>Edit details</p>
                </a>
                <a class="mainButton" href="UserDeleteServlet"?email='<%= user.getEmail()%>' &name='<%= user.getName()%>' &password='<%= user.getPassword()%>' &ID='<%= user.getID()%>' &status='<%= user.getStatus()%>' &role='<%= user.getRole()%>' &phone='<%= user.getPhone()%>'">
                    <p>Deactivate account</p>
                </a>
                 <form action="AccessLogServlet">
                    <button type="submit" name="email" value="${user.email}" class="mainButton">   Access Logs </button>
                </form>
                <a class="mainButton" href="logOut.jsp">
    <p>Log out</p>
  </a>
    
    
    
    
    
    
    
</div>            

            </form>
        </div>
    </body> 
</html>
