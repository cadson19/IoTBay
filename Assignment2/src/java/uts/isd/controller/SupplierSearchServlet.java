/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Supplier;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author ecadd
 */
public class SupplierSearchServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        String contactName = request.getParameter("findContactName");
        String companyName = request.getParameter("findCompanyName");
        
        ArrayList<Supplier> suppliers;
        
        try{
            suppliers = manager.findSupplier(contactName, companyName); 
            session.setAttribute("suppliers", suppliers);
            request.getRequestDispatcher("searchSupplier.jsp").include(request, response);
        }
        catch (SQLException | NullPointerException ex) {
            Logger.getLogger(RegisterCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
