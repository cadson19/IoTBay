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
 * @author Alexander Choi
 */



//LogOutServlet makes the current session null and resets the entire website.
public class LogOutServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");


        
        //Access Log Variables being created
        //Creating Time Variable for Access Log
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = time.format(formatterTime);
        //Creating Date Variable for Access Log
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = currentDate.format(formatterDate);
        //Getting Action Variable for Access Log
        String action = "Logged Out";
        
        
        
        //Store current username in variable called string for later use with access logs.
        String email = request.getParameter("email");
        

        
        //User is reset to nothing.
        User user = null;
        try {
            //Email is still stored, so we can update the access log even though we are logged out. The Session is then
            //set to a 'null' user, meaning that we are now logged out. Session is invalidated as well and then index is loaded.
            manager.addAccessLog(email, action, dateString, timeString);
            session.setAttribute("user", user);
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request, response);
            
        } 
        catch (SQLException | NullPointerException ex) {

        }
    }
}
