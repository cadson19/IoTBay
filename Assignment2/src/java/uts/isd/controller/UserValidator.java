package uts.isd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Alexander Choi
 */

public class UserValidator implements Serializable {

    
    //Email must contain one @ and one .
    private String emailPattern = "^(.+)@(.+)$";
    
    //Name can only contain letters
    private String namePattern = "^[ A-Za-z]+$";
    
    //Password length must be at least 5
    private String passwordPattern = "[a-z0-9]{5,}";
  
    //Staff key is set to staff
    private String staffKey = "staff";
    
    //Phone needs to be 10 digits
    private String phonePattern = "^\\d{10}$";

    
    
    public UserValidator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }


    
    //Empty field checkers - dependent on the page's needs.
    public boolean checkEmptyLogin(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }
    public boolean checkEmptyRegisterCust(String email, String name, String password, String phone){
        return email.isEmpty() || name.isEmpty() || password.isEmpty() || phone.isEmpty();
    }
    public boolean checkEmptyRegisterStaff(String email, String name, String password, String key, String phone){
        return email.isEmpty() || name.isEmpty() || password.isEmpty() || key.isEmpty() || phone.isEmpty();
    }
    public boolean checkEmptyUpdate(String name, String password, String phone){
        return name.isEmpty() || password.isEmpty() || phone.isEmpty();
    }
    
    //Variable format checkers - match the variables declared earlier.
    public boolean emailFormat(String email){
        return validate(emailPattern, email);
    }
    public boolean nameFormat(String name){
        return validate(namePattern, name);
    }
    public boolean passwordFormat(String password){
        return validate(passwordPattern, password);
    }
    public boolean phoneFormat(String phone){
        return validate(phonePattern, phone);
    }

    //Key checker - makes sure the staff key supplied matches the preset staff key.
    public boolean checkKey(String key) {
        return staffKey.equals(key);
    }

    
    //Validator resetter - clears all error messages.
    public void clear(HttpSession session) {
        session.setAttribute("emptyError", "");
        session.setAttribute("emailError", "");
        session.setAttribute("nameError", "");
        session.setAttribute("passwordError", "");
        session.setAttribute("keyError", "");
        session.setAttribute("phoneError", "");
        session.setAttribute("createdError", "");
        session.setAttribute("badLoginError", "");
    }
}
