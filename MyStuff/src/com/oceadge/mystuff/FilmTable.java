package com.oceadge.mystuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oceadge.mystuff.search.*;

/**
 * @author Steee
 * 
 * This class is related to the film_table table
 *     film_number serial  (This will always be DEFAULT)
 *     film_name character varying
 *     film_name2 character varying
 *     film_name_alternative character varying
 *     film_name_original character varying
 *     film_year integer
 *     film_comments character varying
 */

public class FilmTable {

  Connection c = null;
  PreparedStatement ps = null;
  Statement s = null;
  ResultSet rs = null;
  boolean found = false;



	/*
   * Method: insertFilm()
   *
	 */
  public boolean insertFilm(String film_name, String film_name2, String film_name_alternative, String film_name_original, int film_year, String film_comments) {

    DataBase d = new DataBase();
    c = d.establishConnection();
    DoesExist f = new DoesExist();
    
    boolean found = false;
    
    found = f.testFilmExists(film_name, film_year);
    System.out.println("Found = " + found);
    if (found){
      System.out.println("Film: " + film_name + " already exists");
      return true;
    }



//	  ********************
//	  INSERT - Prepared Statement
//	  ********************

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

  /*
   * Method: getAllFilms()
   *
   */
  public void getAllFilms(){

    DataBase d = new DataBase();
    c = d.establishConnection();

    try {
      s = c.createStatement();
    } catch (SQLException se) {
      System.out.println("We got an exception while creating a statement:" +
                         "that probably means we're no longer connected.");
      se.printStackTrace();
      System.exit(1);
    }

    try {
      rs = s.executeQuery("SELECT * FROM film_table");
      c.close();
    } catch (SQLException se) {
      System.out.println("We got an exception while executing our query:" +
                         "that probably means our SQL is invalid");
      se.printStackTrace();
      System.exit(1);
    }

    int index = 0;

    try {
      while (rs.next()) {
          System.out.println("Here's the result of row " + index++ + ":");
          System.out.println(rs.getString(1) + ", " + rs.getString(2));
      }
    } catch (SQLException se) {
      System.out.println("We got an exception while getting a result:this " +
                         "shouldn't happen: we've done something really bad.");
      se.printStackTrace();
      System.exit(1);
    }
  }

  /*
   * Method testFilmExists()
   *
   *
  public boolean testFilmExists(String film_name, int film_year){

    s = null;
    rs = null;

    //establishConnection();

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
  */

  /*
   * Method editFilm()
   *
   */
  public boolean updateFilm(String search_film_name, int search_film_year, String film_name, String film_name2, String film_name_alternative, String film_name_original, int film_year, String film_comments){

    s = null;

    String updateFilm = "UPDATE film_table SET " +
                        "film_name = '" + film_name + "', " +
                        "film_name2 = '" + film_name2 + "', " +
                        "film_name_alternative = '" + film_name_alternative + "', " +
                        "film_name_original = '" + film_name_original + "', " +
                        "film_year = " + film_year + ", " +
                        "film_comments = '" + film_comments + "' " +
                        "WHERE film_name = '" + search_film_name + "' " +
                        "AND film_year = " + search_film_year;
    System.out.println(updateFilm);


    //updateString1 = "update Employees set name = 'hemanthbalaji' where Employee_id = 6323";

    //establishConnection();
    int i = 0;

    try {
      s = c.createStatement();
      i = s.executeUpdate(updateFilm);
    } catch (SQLException se) {
      System.out.println("We got an exception while executing our query:" +
                         "that probably means our SQL is invalid");
      se.printStackTrace();
      System.exit(1);
    }
    System.out.println("Successfully updated " + i + " rows.");

   /*
    try {
      stmt = con.createStatement();
        stmt.executeUpdate(updateString1);

      stmt.close();
      con.close();

    } catch(SQLException ex) {
      System.err.println("SQLException: " + ex.getMessage());
    }
    JOptionPane.showMessageDialog(null,"Data Updated into Employees Table");

    */

    return true;
  }
}