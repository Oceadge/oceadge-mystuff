/**
 * @author Steee
 * 
 * This class is related to the film_table table
 *
 */

package com.oceadge.mystuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBase {

  final String DATABASE = "jdbc:postgresql://localhost/my_stuff";
  final String DATABASE_U = "postgres";
  final String DATABASE_P = "postgres4me";
  
  static Connection c = null;
  
  /*
   * Method: establishConnection()
   *
   */
  public Connection establishConnection(){
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException cnfe) {
      System.out.println("Couldn't find the driver!");
      System.out.println("Let's print a stack trace, and exit.");
      cnfe.printStackTrace();
      System.exit(1);
    }

    try {
      // The second and third arguments are the username and password,
      // respectively. They should be whatever is necessary to connect
      // to the database.
      c = DriverManager.getConnection(DATABASE, DATABASE_U, DATABASE_P);
      return c;
    } catch (SQLException se) {
      System.out.println("Couldn't connect: print out a stack trace and exit.");
      se.printStackTrace();
      System.exit(1);
    }
    return null;
  }
}
