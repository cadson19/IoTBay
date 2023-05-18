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



//UserEditServlet is 1/2 Servlets used to update details. UserEditServlet obtains the user's details.
public class UserEditServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserValidator validator = new UserValidator();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        
        //Access Log Variables Created
        //Creating Time Variable for Access Log
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = time.format(formatterTime);
        //Creating Date Variable for Access Log
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = currentDate.format(formatterDate);
        //Getting Action Variable for Access Log
        String action = "Edited Details";
        
        
        //Creates variables using the current details the session user has.
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String ID = request.getParameter("ID");
        String phone = request.getParameter("phone");

        //Creation of a new user to be used later.
        User user = null;
        
        try {
            //User is set to an existing user based on the the database manager finding a user with the email and password.
            user = manager.findUser(email, password);
            //If user is not null (a user was found) then the existence is confirmed and user is passed onto userEdit.jsp where new details can be put in.
            //Access logs are updated.
            if (user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("userEdit.jsp").include(request, response);
                manager.addAccessLog(email, action, dateString, timeString);
            } 
            else {
                //If user is null (a user was not found) then the existence is not confirmed and an error is created.
                session.setAttribute("existErr", "user does not exist in the database!");
                request.getRequestDispatcher("userEdit.jsp").include(request, response);
            }
        } catch (SQLException ex) {
        }
        validator.clear(session);
    }
}