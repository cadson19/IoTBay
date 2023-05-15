/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;

/**
 *
 * @author Alexander
 */
public abstract class DB {   

protected String URL = "jdbc:derby://localhost:1527/";//replace this string with your jdbc:derby local host url   
protected String db = "group8db";//name of the database   
protected String dbuser = "isduser";//db root user   
protected String dbpass = "admin"; //db root password   
protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
protected Connection conn; //connection null-instance to be initialized in sub-classes

}
