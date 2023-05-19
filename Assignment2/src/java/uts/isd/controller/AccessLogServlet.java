package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.AccessLog;
import uts.isd.model.dao.DBManager;
/**
 *
 * @author Alexander Choi
 */



//Facilitates SQL commands to get all the ACCESS log results.



public class AccessLogServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        
        //Store user email into a variable called email.
        String email = request.getParameter("email");


        //Store results in an arrayList called accesslogs.
        ArrayList<AccessLog> accesslogs;
        
        try {
            //Use DBManager function that gets all rows form an email and store it in the accesslogs list.
            accesslogs = manager.accessEmailSearch(email);
            System.out.println(accesslogs.size());
            session.setAttribute("accesslogsall", accesslogs);
            request.getRequestDispatcher("accessLogs.jsp").include(request, response);

        } 
        catch (SQLException | NullPointerException ex) {
            
        }
    }
}

