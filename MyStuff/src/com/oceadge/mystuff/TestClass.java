package com.oceadge.mystuff;

public class TestClass {

	/**
	 * Using this to test classes and methods
	 */
	public static void main(String[] args) {
    
    
    // Update a film
    //
    FilmTable f = new FilmTable();
    boolean result = f.updateFilm("Shooter 8", 2010, "The Host", "", "", "", 2010, "Updated");
    System.out.println(result);
    
    // 
    
		 
    // Insert a film
    //
	  //FilmTable f = new FilmTable();
	  //boolean result = f.insertFilm("Shooter 14", "", "", "", 2006, "It was not real");
    //if (result == true){
    //  System.out.println("Film already exists in database.");      
    //}
    //else{
    //  System.out.println("Film added to database.");
    //}

    
    // Select *
    //
    //FilmTable ft = new FilmTable();
    //f.getAllFilms();
    
    // Search if film already exists
    //
    //boolean isFound = false;
    //FilmTable f = new FilmTable();
    //isFound = f.testFilmExists("Jaws 4");
    //System.out.println("Film found? - " + isFound);
	}
}