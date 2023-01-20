import java.sql.*;
import java.util.*;

public class Datenbank {

	private static Connection con;
	private static final String dbPath ="Pokemon.db";
	public static ArrayList<String> Typen = new ArrayList<String>();
	
	//Ladet den LDBC-Treiber(connection zur Datenbank)
	static {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Erfolgreich JDBC geladen");
		} catch (ClassNotFoundException e) {
			System.err.println("Fehler beim Laden des JDBC-Treibers");
			e.printStackTrace();
		}
	}
	
	public Datenbank() {
		connectToDatabase();
	}
	
	private void connectToDatabase() {
		try {
			if (con != null) {
				return;
			}
			con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
			if(!con.isClosed()) {
				System.out.println("Connected to Database");
			}
		}
		catch (SQLException e) {
			System.out.println(""+e);
		}
		
	Runtime.getRuntime().addShutdownHook(new Thread() {
		public void run() {
			try {
				if(!con.isClosed() && con != null) {
					con.close();
					if(con.isClosed())
						System.out.println("Connection to Database closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	}
	public static void getTypes(String qry) {
		Typen.clear();
        try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(qry);

        int columns = rs.getMetaData().getColumnCount();

        while(rs.next()) {
            for(int i = 1;i<=columns;i++) {
                Typen.add(rs.getString(i));
            }
        }
        rs.close();
        stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
	 public static String getTypen(int i) {
		  return Typen.get(i);
	  }
}
