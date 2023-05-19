/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author ecadd
 */
public class SupplierManagerServlet extends HttpServlet{
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        UserValidator validator = new UserValidator();
        
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = time.format(formatterTime);
        //Creating Date Variable for Access Log
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = currentDate.format(formatterDate);
        //Getting Action Variable for Access Log
        String action = "Accesssed Manage Supplier";
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String allowedRole = "Staff";
        
        User user = null;
        
        try{
            user = manager.findUser(email, password);
            if(role.equals(allowedRole)){
                System.out.println(email);
                session.setAttribute("user", user);
                request.getRequestDispatcher("manageSupplier.jsp").include(request, response);
                manager.addAccessLog(email, action, dateString, timeString);
            }
            else{
                session.setAttribute("existErr", "Not an allowed Role!");
                request.getRequestDispatcher("manageSupplier.jsp").include(request, response);
            }
        }catch(SQLException ex){
            
        }
    }
}
