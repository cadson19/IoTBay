/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author Alexander
 */
public class AccessLog {

    private String email;
    private String action;
    private String date;
    private String time;
    
    public AccessLog(String email, String action, String date, String time) {
        this.email = email;
        this.action = action;
        this.date = date;
        this.time = time;
    }

    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getAction(){
        return action;
    }
    public void setAction(String action){
        this.action = action;
    }
    
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
}
