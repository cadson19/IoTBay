/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author ecadd
 */
public class SupplierDeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try{
            request.getRequestDispatcher("deleteSupplier.jsp").include(request, response);
        }
        catch (NullPointerException ex) {
            Logger.getLogger(RegisterCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
