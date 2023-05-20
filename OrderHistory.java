/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fatin
 */
public class OrderHistory {
     private ArrayList<Order> OrderHistory;
     

    public OrderHistory(ArrayList<Order> OrderHistory) {
    	 OrderHistory = new ArrayList<Order>();
    
    }

    public ArrayList<Order> getOrderHistory() {
        return OrderHistory;
    }

    public void setOrderHistory(ArrayList<Order> OrderHistory) {
        this.OrderHistory = OrderHistory;
    }

  
  
}
