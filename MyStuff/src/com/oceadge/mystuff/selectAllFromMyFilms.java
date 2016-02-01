package myFilmsPackage;

/**
 * @author sbye
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
import java.sql.*;

public class selectAllFromMyFilms {
    public static void main(String args[]) {
        String url = "jdbc:odbc:oceadge_test";
        Connection con;
        String createString;
        String updateString;
        String selectAll;
        String query;
        int row_num;

        query = "SELECT FilmDetailsNumber, FilmName, FilmYear " +
        	      "FROM FilmDetailsTable";



        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, "", "");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet srs = stmt.executeQuery(query);
//            while (srs.next()) {
//              row_num = srs.getRow();
//              System.out.println("Moving through all the rows of the database");
//              System.out.println("Row Number: " + row_num);
//            }
//            while (srs.previous()) {
//           }
            while (srs.next()) {
            	int i = srs.getInt("FilmDetailsNumber");
              String s = srs.getString("FilmName");
              int n = srs.getInt("FilmYear");
              System.out.println(i + " " + s + " " + n);
            }
            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}