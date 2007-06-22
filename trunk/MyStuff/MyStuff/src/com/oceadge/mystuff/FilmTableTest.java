/**
 * 
 * Testing using JUnit
 * 
 * 
 */
package com.oceadge.mystuff;

import junit.framework.TestCase;

/**
 * @author T803900
 *
 */
public class FilmTableTest extends TestCase {

  /* (non-Javadoc)
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception {
    super.setUp();
  }

  /* (non-Javadoc)
   * @see junit.framework.TestCase#tearDown()
   */
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test method for {@link myFilmDB.FilmTable#insertFilm(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String)}.
   */
  public void testInsertFilm() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link myFilmDB.FilmTable#getAllFilms()}.
   */
  public void testGetAllFilms() {
    FilmTable f = new FilmTable();
    f.getAllFilms();
  }

  /**
   * Test method for {@link myFilmDB.FilmTable#testFilmExists(java.lang.String, int)}.
   */
  public void testTestFilmExists() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link myFilmDB.FilmTable#updateFilm(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String)}.
   */
  public void testUpdateFilm() {
    FilmTable f = new FilmTable();
    boolean result = f.updateFilm("Shooter 8", 2010, "The Host", "", "", "", 2010, "Updated");
    System.out.println(result);
  }

}
