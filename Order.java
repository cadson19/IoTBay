/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author fatin
 */
public class Order {
       private String orderid;
    private String userid;
    private String deviceid;
    private int quantity;

    public Order(String orderid,String userid,String deviceid, int quantity) {
        this.orderid = orderid;
        this.userid = userid;
        this.deviceid = deviceid;
        this.quantity = quantity;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}