/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;
import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.User;
import uts.isd.model.AccessLog;

/**
 *
 * @author Alexander
 */
public class DBManager {
    private Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

//----------------Alex's User Database Manager Functions-----------------------------------------------------------------------
    
    //Function to find a user based on email and password.
    public User findUser(String email, String password) throws SQLException {
        String fetch = "select * from ISDUSER.Users where EMAIL = '" + email + "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if (userEmail.equals(email) && userPass.equals(password)) {
                String userName = rs.getString(1);
                String userID = rs.getString(4);
                String userStatus = rs.getString(5);
                String userRole = rs.getString(6);
                String userPhone = rs.getString(7);
                return new User(userName, userEmail, userPass, userID, userStatus, userRole, userPhone);
            }
        }
        return null;
    }
    
    //Create new user
    public void addUser(String name, String email, String password, String ID, String status, String role, String phone) throws SQLException {
        st.executeUpdate("INSERT INTO ISDUSER.Users " + "VALUES ('" + name + "', '" + email + "', '" + password + "', '" + ID + "',  '" + status + "',  '" + role + "',  '" + phone + "')");
    }
    
    //Update old user
    public void updateUser(String name, String email, String password, String ID, String status, String role, String phone) throws SQLException {
        st.executeUpdate("UPDATE ISDUSER.Users SET NAME='" + name + "',PASSWORD='" + password + "',ID='" + ID + "',status='" + status + "',PHONE='" + phone + "' ,ROLE='" + role + "' WHERE EMAIL='" + email + "'");
    }
    
    //Delete user (only used in testing)
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM  ISDUSER.Users WHERE EMAIL = '" + email + "'");
    }
    
    //Change user status
    public void changeUserStatus(String email, String status) throws SQLException {
        st.executeUpdate("UPDATE ISDUSER.Users SET STATUS='" + status + "' WHERE EMAIL='" + email + "'");
    }
    
    //Find user using only email
    public User findUserEmailOnly(String email) throws SQLException {
        String fetch = "select * from ISDUSER.Users where EMAIL = '" + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String userEmail = rs.getString(2);
            if (userEmail.equals(email)) {
                String userName = rs.getString(1);
                String userPassword = rs.getString(3);
                String userNumber = rs.getString(4);
                String userStatus = rs.getString(5);
                String userRole = rs.getString(6);
                String userPhone = rs.getString(7);
                return new User(userName, userEmail, userPassword, userNumber, userStatus, userRole, userPhone);
            }
        }
        return null;
    }

    //Fetch all users in the database
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "select * from USERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();
        
        while(rs.next()){
            String name = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String ID = rs.getString(4);
            String status = rs.getString(5);
            String role = rs.getString(6);
            String phone = rs.getString(7);
            temp.add(new User(name, email, password, ID, status, role, phone));
        }
        return temp;
    }

    //Find user based on email and password input
    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "select * from ISDUSER.Users where EMAIL = '" + email + "' and password = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if (userEmail.equals(email) && userPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    //Create a new access log
    public void addAccessLog(String email, String action, String date, String time) throws SQLException {
        st.executeUpdate("INSERT INTO ISDUSER.ACCESS " + "VALUES ('" + email + "', '" + action + "', '" + date + "', '" + time + "')");
    }
       
    //Find all access logs based off email input
    public ArrayList<AccessLog> accessEmailSearch(String email) throws SQLException {
        System.out.println("The email is + " + email);
        String fetch = "SELECT * FROM ACCESS WHERE email = '" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<AccessLog> logs = new ArrayList();

        while (rs.next()) {
            String date = rs.getString(2);
            String time = rs.getString(3);
            String action = rs.getString(4);
            
            logs.add(new AccessLog(email, date, time, action));
        }
        
        System.out.println("The size of temp is + " + logs.size());
        return logs;
    } 

}
