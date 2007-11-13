package com.oceadge.mystuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oceadge.mystuff.search.DoesExist;

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
   * Method: insertAddress()
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
    DoesExist f = new DoesExist();
    boolean found = false;    
    
    found = f.testAddressExists(obtain_address_address1, obtain_address_suburb);
    System.out.println("Found = " + found);
    if (found){
      System.out.println("Address: " + obtain_address_address1 + ", " + obtain_address_suburb + " already exists");
      return true;
    }

   
    // Address not found so insert into the table
    // 
    // Prepared Statement - INSERT
    //

    try {
      ps = c.prepareStatement("INSERT INTO obtain_address_table VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      ps.setString(1, obtain_address_name);
      ps.setString(2, obtain_address_branch);
      ps.setString(3, obtain_address_address1);
      ps.setString(4, obtain_address_address2);
      ps.setString(5, obtain_address_address3);
      ps.setString(6, obtain_address_suburb);
      ps.setString(7, obtain_address_county);
      ps.setString(8, obtain_address_state);
      ps.setString(9, obtain_address_zip);
      ps.setString(10, obtain_address_country);
      ps.setString(11, obtain_address_location_comments);
    } catch (SQLException se) {
      System.out.println("We got an exception while preparing a statement:" +
                         "Probably bad SQL.");
      se.printStackTrace();
      System.exit(1);        
    }

    try {
      ps.executeUpdate();
      System.out.println("Added address: " + obtain_address_name + "-" + obtain_address_branch + ", " + obtain_address_suburb + " to table");
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
