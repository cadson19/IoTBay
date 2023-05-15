package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
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



//UserUpdateServlet is 2/2 Servlets used to update details. UserEditServlet edits new details in.
public class UserUpdateServlet extends HttpServlet {

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
        
        
        
        //Edit.jsp has passed in new details. New details are put into variables.
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String ID = request.getParameter("ID");
        String status = "Active";
        String role = request.getParameter("role");
        String phone = request.getParameter("phone");

        //New user created with the new details.
        User user = new User(name, email, password, ID, status, role, phone);
        
        //Validator reset to prevent old errors.
        validator.clear(session);
        
        //New details are checked include:
        //Fields are not empty.
        //Name and password are correct formatting.
        if (validator.checkEmptyUpdate(password, name, phone)) {
            session.setAttribute("emptyError", "Please enter all fields");
            request.getRequestDispatcher("userEdit.jsp").include(request, response);
        } 
        else if (!validator.passwordFormat(password)) {
            session.setAttribute("passwordError", "Your password must have at least 5 letters and/or numbers and no spaces");
            request.getRequestDispatcher("userEdit.jsp").include(request, response);
        } 
        else if (!validator.nameFormat(name)) {
            session.setAttribute("nameError", "Your name must not include numbers");
            request.getRequestDispatcher("userEdit.jsp").include(request, response);
        }
        else if (!validator.phoneFormat(phone)) {
            System.out.println("its this one");
            session.setAttribute("phoneError", "Your phone must be 10 numbers");
            request.getRequestDispatcher("userEdit.jsp").include(request, response);
        }
        else {
        //If validation passes, the real code begins:
            try {
                //Double check that user is null
                if (user != null) {
                    //If user is not null, database is updated to new details.
                    //Session is updated.
                    //Updated message is sent through.
                    //Access log updated.
                    System.out.println("Change is registering");
                    session.setAttribute("user", user);
                    manager.updateUser(name, email, password, ID, status, role, phone);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                    manager.addAccessLog(email, action, dateString, timeString);
                    
                } 
                else {
                    //Rare error message that it does not work
                    session.setAttribute("existErr", "Update was not successful");
                    request.getRequestDispatcher("userEdit.jsp").include(request, response);
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(UserEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            validator.clear(session);
        }
}
    }

