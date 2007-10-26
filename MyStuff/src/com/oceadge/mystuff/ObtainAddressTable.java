package com.oceadge.mystuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Steee
 * 
 * This class is related to the obtain_address_table table

 */


public class ObtainAddressTable {

  Connection c = null;
  PreparedStatement ps = null;
  Statement s = null;
  ResultSet rs = null;
  boolean found = false;
  
  
  /*
  obtain_address_number serial NOT NULL PRIMARY KEY,
  obtain_address_name character varying NOT NULL,  -- A description of the address.  E.g. Golden Disc
  obtain_address_branch character varying, -- The branch of this particular shop.  E.g. Henry Street
  obtain_address_address1 character varying,
  obtain_address_address2 character varying,
  obtain_address_address3 character varying,
  obtain_address_suburb character varying,
  obtain_address_county character varying,
  obtain_address_state character varying,
  obtain_address_zip character varying,
  obtain_address_country character varying,
  obtain_address_location_comments character varying  -- Any comments on the actual address
  
  
  /*
   * Method: insertFilm()
   *
   */
  public boolean insertAddress(String obtain_address_name,
                               String obtain_address_branch,
                               String obtain_address_address1,
                               String obtain_address_address2,
                               String obtain_address_address3,                          
                               String obtain_address_suburb,
                               String obtain_address_county,
                               String obtain_address_state,
                               String obtain_address_zip,
                               String obtain_address_country,
                               String obtain_address_location_comments) {

    DataBase d = new DataBase();
    c = d.establishConnection(); 
    boolean found = false;
    
    // Okay, this has to go in it's own class - pass the table name and parameters and return true or false at least.
    found = testFilmExists(film_name, film_year);
    System.out.println("Found = " + found);
    if (found){
      System.out.println("Film: " + film_name + " already exists");
      c.close();
      return true;
    }



//    ********************
//    INSERT - Prepared Statement
//    ********************

      try {
        ps = c.prepareStatement("INSERT INTO film_table VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, film_name);
        ps.setString(2, film_name2);
        ps.setString(3, film_name_alternative);
        ps.setString(4, film_name_original);
        ps.setInt(5, film_year);
        ps.setString(6, film_comments);
      } catch (SQLException se) {
        System.out.println("We got an exception while preparing a statement:" +
                           "Probably bad SQL.");
        se.printStackTrace();
        System.exit(1);        
      }

      try {
        ps.executeUpdate();
        System.out.println("Added " + film_name + " to table");
        c.close();
        return false;
      } catch (SQLException se) {
        System.out.println("We got an exception while executing an update:" +
                           "possibly bad SQL, or check the connection.");
        se.printStackTrace();
        System.exit(1);
      }
      return false;
  }
}
