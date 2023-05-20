package uts.isd.controller;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.User;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import uts.isd.model.Order;


public class TestOrderDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;

    public static void main(String[] args) throws SQLException {
        (new TestOrderDB()).runQueries();
    }

    public TestOrderDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestUserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readChoice() {
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'L':
                    testAccessLog();
                    break;
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;

            }
        }
    }

    private void testAdd() {
        System.out.print("orderID: ");
        String orderID = in.nextLine();
        System.out.print("userId ");
        String userId = in.nextLine();
        System.out.print("deviceId: ");
        String deviceId = in.nextLine();
        System.out.print("quantity: ");
        String quantityString = in.nextLine();
        int quantity = Integer.parseInt(quantityString);

        
        try {
            db.addOrder(orderID, userId, deviceId, quantity);

        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("order is added to the database.");
    }

    private void testRead() throws SQLException {
        System.out.print("orderid: ");
        String id = in.nextLine();       
        Order order = db.getOrder(id);
        if (order != null) {
                System.out.print("orderid:" + order.getOrderid() + "     " + "userid:" + order.getUserid()+ "     " + "deviceid:" + order.getDeviceid() + "     " + "quanitity:" + order.getQuantity());
        } else {
            System.out.println("Order does not exist.");
        }
    }

    private void testUpdate() {
        System.out.print("orderid ");
        String orderid = in.nextLine();
      

        try {
            if (db.getOrder(orderid) != null) {
                System.out.print("productid: ");
                String productid = in.nextLine();
                System.out.print("quantity ");
 String quantityString = in.nextLine();
        int quantity = Integer.parseInt(quantityString);            
                db.updateOrder(productid, quantity, orderid);
            } else {
                System.out.println("Order does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testDelete() {
        System.out.print("orderid: ");
        String orderid = in.nextLine();
 

        try {
            if (db.getOrder(orderid) != null) {
                db.deleteOrder(orderid);
            }   
             else {
                System.out.println("Order does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 

    private void testAccessLog(){
        

        System.out.print("orderid: ");
        String orderId = in.nextLine();
        System.out.print("userid: ");
        String userid= in.nextLine();
        System.out.print("orderDate: ");
        String orderDate = in.nextLine();
        LocalDate date = LocalDate.parse(orderDate);//yyyy-MM-dd
        
        
        try {
            db.addOrderHistory(orderId, userid, date);
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Access Log added");
        
        
    }
}
