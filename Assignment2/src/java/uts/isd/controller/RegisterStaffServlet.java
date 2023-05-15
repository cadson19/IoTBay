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
/**
 *
 * @author Alexander Choi
 */



//Purpose of this controller is to allow customers to register a new customer account
public class RegisterStaffServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserValidator validator = new UserValidator();
        DBManager manager = (DBManager) session.getAttribute("manager");

        
        
        //Variables are initiated based on the inputs.
        //Key, email, name and password are given by the user.
        //ID is a random number between 1 and 99999999
        //Role is assumed to be staff due to being in the staff creation portal.
        //Status is assumed to be active.
        Random random = new Random();
        String key = request.getParameter("staffPassword");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String ID = Integer.toString(random.nextInt(99999999) + 1);       
        String role = "Staff";
        String status = "Active";
        String phone = request.getParameter("phone");
        
                

        
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
        String action = "Registered as a Staff";
        
        
        
        //Staff Registration validation begins. 
        //Empty fields and formatting of email, password and name are checked.
        //Staff key is also checked.
        //If a validation fails, the staffRegister.jsp page is reloaded but this time with the corresponding errors and messages.
        if (validator.checkEmptyRegisterStaff(email, password, name, key, phone)) {
            session.setAttribute("emptyError", "Please enter all fields");
            request.getRequestDispatcher("registerStaff.jsp").include(request, response);
        } 
        else if (!validator.emailFormat(email)) {
            session.setAttribute("emailError", "Your email address must include @");
            request.getRequestDispatcher("registerStaff.jsp").include(request, response);
        } 
        else if (!validator.passwordFormat(password)) {
            session.setAttribute("passwordError", "Your password must have at least 5 letters and/or numbers and no spaces");
            request.getRequestDispatcher("registerStaff.jsp").include(request, response);
        } 
        else if (!validator.nameFormat(name)) {
            session.setAttribute("nameError", "Your name must not include numbers");
            request.getRequestDispatcher("registerStaff.jsp").include(request, response);
        } 
        else if (!validator.checkKey(key)) {
            session.setAttribute("keyError", "Staff key is incorrect");
            request.getRequestDispatcher("registerStaff.jsp").include(request, response);
        }
        else if (!validator.phoneFormat(phone)) {
            session.setAttribute("phoneError", "Your phone must be 10 numbers");
            request.getRequestDispatcher("registerStaff.jsp").include(request, response);
        }
        //If validation passes, the real code begins:
        else {
            try {
                //Temp is initiated as a potenital user matching the email supplied.
                User temp = manager.findUserEmailOnly(email);
                if (temp != null) {
                    session.setAttribute("createdError", "Email already in use.");
                    request.getRequestDispatcher("registerStaff.jsp").include(request, response);
                } 
                //If temp becomes null (query found no matching emails) then a new user is created using the supplied information.
                //Information is then passed onto main through the user variable.
                //Access log is updated.
                else {
                    manager.addUser(name, email, password, ID, status, role, phone);
                    User user = new User(name, email, password, ID, status, role, phone);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                    manager.addAccessLog(email, action, dateString, timeString);

                }
            } catch (SQLException | NullPointerException ex) {
                Logger.getLogger(RegisterStaffServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Reset validator for future logins.
        validator.clear(session);
    }
}

