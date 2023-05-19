/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author Alexander
 */
public class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private String ID;
    private String status;
    private String role;
    private String phone;


    public User(String name, String email, String password, String ID, String status, String role, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ID = ID;
        this.status = status;
        this.role = role;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.ID = status;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
