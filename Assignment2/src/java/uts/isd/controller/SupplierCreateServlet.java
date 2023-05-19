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

public class SupplierCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try {
            ArrayList<Supplier> suppliers = manager.fetchSuppliers();
            session.setAttribute("suppliers", suppliers);
            request.getRequestDispatcher("createSupplier.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Handle the exception and display an error message or redirect to an error page
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String contactName = request.getParameter("createContactName");
        String companyName = request.getParameter("createCompanyName");
        String email = request.getParameter("createEmail");
        String address = request.getParameter("createAddress");
        String status = request.getParameter("createStatus");

        try {
            System.out.println(contactName);
            manager.addSupplier(contactName, companyName, email, address, status);
            response.sendRedirect("searchSupplier.jsp"); // Redirect to the search page after adding the supplier
        } catch (SQLException ex) {
            Logger.getLogger(SupplierCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Handle the exception and display an error message or redirect to an error page
        }
    }
}