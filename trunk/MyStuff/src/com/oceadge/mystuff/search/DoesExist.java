package com.oceadge.mystuff.search;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oceadge.mystuff.DataBase;

public class DoesExist {
  
  Connection c = null;
  Statement s = null;
  ResultSet rs = null;
  
  
  /*
   * Method testFilmExists()
   *
   */
  public boolean testFilmExists(String film_name, int film_year){

    s = null;
    rs = null;
    boolean found = false;
    
    DataBase d = new DataBase();
    c = d.establishConnection();

    try {
      s = c.createStatement();
      rs = s.executeQuery("SELECT * FROM film_table WHERE film_name = '"+ film_name +"' AND film_year = "+ film_year +"");
      found = rs.next();
    } catch (SQLException se) {
      System.out.println("We got an exception while executing our query:" +
                         "that probably means our SQL is invalid");
      se.printStackTrace();
      System.exit(1);
    }    
    return found;
  }
  
  
  /*
   * Method testAddressExists()
   *
   */
  public boolean testAddressExists(String obtain_address_address1, String obtain_address_suburb){

    s = null;
    rs = null;
    boolean found = false;
    
    DataBase d = new DataBase();
    c = d.establishConnection();

    try {
      s = c.createStatement();
      rs = s.executeQuery("SELECT * FROM obtain_address_table WHERE obtain_address_address1 = '"+ obtain_address_address1 +"' AND obtain_address_suburb = '"+ obtain_address_suburb +"'");
      found = rs.next();
    } catch (SQLException se) {
      System.out.println("We got an exception while executing our query:" +
                         "that probably means our SQL is invalid");
      se.printStackTrace();
      System.exit(1);
    }    
    return found;
  }
}
