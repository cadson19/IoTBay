package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
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



//UserDeleteController is 2/2 Servlets used to update details. UserDeleteController changes status.
public class UserDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserValidator validator = new UserValidator();
        DBManager manager = (DBManager) session.getAttribute("manager");

        
        
        //Get variables from session.
        //Status can manually be set as we know they are active coming into this.
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String ID = request.getParameter("ID");
        String status = "Inactive";
        String role = request.getParameter("role");
        String phone = request.getParameter("phone");

        //New user created with the old details.
        User user = new User(name, email, password, ID, status, role, phone);
        
        validator.clear(session);
            try {
                //Double check the user exits. If they do exist, use the updateUser function to update the status to Inactive.
                if (user != null) {
                    session.setAttribute("user", user);
                    manager.updateUser(name, email, password, ID, status, role, phone);
                    session.setAttribute("user", user);
                    session.invalidate();
                    request.getRequestDispatcher("index.jsp").include(request, response);
                    
                } else {
                    //Rare error message that it does not work
                    session.setAttribute("updated", "Deactivation was not successful");
                    request.getRequestDispatcher("userDelete.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("userDelete.jsp");
        }

    }



