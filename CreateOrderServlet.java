/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author fatin
 */
@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/CreateOrderServlet"})
public class CreateOrderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            HttpSession session = request.getSession();
            UserValidator validator = new UserValidator();
            DBManager manager = (DBManager) session.getAttribute("manager");
            
            // Retrieve form data
            
            String productId = request.getParameter("productId");
            int productQuantity = Integer.parseInt(request.getParameter("orderQuantity"));////PARSE
            LocalDate orderDate = LocalDate.parse(request.getParameter("date"));
            // Retrieve customer details and IoT device details
            
            // Validate the data
            
            // Create a new Order object
            //get user id
            String userId= session.getId();
            
            Random random = new Random();
            String ID = Integer.toString(random.nextInt(99999999) + 1);
            
            manager.addOrder(ID, userId, productId, productQuantity);
            manager.addOrderHistory(ID, userId, orderDate);
            request.getRequestDispatcher("viewOrder.jsp").include(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}