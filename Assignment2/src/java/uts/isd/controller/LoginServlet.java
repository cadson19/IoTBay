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



//LoginServlet helps users login to the system.
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserValidator validator = new UserValidator();

        
        
        DBManager manager = (DBManager) session.getAttribute("manager");

        
        
        //Email and password variables created from the current session.
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        
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
        String action = "Logged in";
        
        
        
        //User initiated for later use.
        User user = null;

        
        
        //Login validation begins. Empty fields and formatting of email and password are checked.
        //If a validation fails, the login.jsp page is reloaded but this time with the corresponding errors and messages.
        if (validator.checkEmptyLogin(email, password)) {
            session.setAttribute("emptyError", "Please enter all fields");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } 
        else if (!validator.emailFormat(email)) {
            session.setAttribute("emailError", "Your email address must include @");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } 
        else if (!validator.passwordFormat(password)) {
            session.setAttribute("passwordError", "Your password must have at least 5 letters and/or numbers and no spaces");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } 
        //If validation passes, the real code begins:
        else {
            try {
                //Attempt to make user equal to a user in the database that matches the credentials supplied.
                user = manager.findUser(email, password);
                //If user matches credentials in the system and they have an active account, web page moves onto the main page.
                //Access log is also updated.
                if (user != null && user.getStatus().equals("Active")) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                    manager.addAccessLog(email, action, dateString, timeString);
                //If user credentials fail to match or account is inactive, login.jsp is reloaded with the bad login error.
                } 
                else {
                    //return error and redirect to login.jsp if email does not match password in database
                    session.setAttribute("badLoginError", "Invalid email/password combination");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            } 
            catch (SQLException | NullPointerException ex) {
                
            }
        }
        
        
        
        //Reset validator for future logins.
        validator.clear(session);
    }
}
