import java.sql.*;
import java.util.*;

public class Datenbank {

	private static Connection con;
	private static final String dbPath = "Pokemon.db";
	public static ArrayList<String> Types = new ArrayList<String>();
	public static ArrayList<String> types_color = new ArrayList<String>();
	public static ArrayList<String> effective_against_Types = new ArrayList<String>();
	public static ArrayList<String> not_effective_against_Types = new ArrayList<String>();
	public static ArrayList<String> immune_Types = new ArrayList<String>();

	// Ladet den LDBC-Treiber(connection zur Datenbank)
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
			if (!con.isClosed()) {
				System.out.println("Connected to Database");
			}
		} catch (SQLException e) {
			System.out.println("" + e);
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					if (!con.isClosed() && con != null) {
						con.close();
						if (con.isClosed())
							System.out.println("Connection to Database closed");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void getTypes(String qry, int j) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);

			int columns = rs.getMetaData().getColumnCount();

			if (j == 0) {
				Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						Types.add(rs.getString(i));
						
					}
				}
			}
			if (j == 1) {
				effective_against_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						effective_against_Types.add(rs.getString(i));
					}
				}
			}
			if (j == 2) {
				not_effective_against_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						not_effective_against_Types.add(rs.getString(i));
					}
				}
			}
			if (j == 3) {
				immune_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						immune_Types.add(rs.getString(i));
					}
				}
			}
			if (j == 4) {
				types_color.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						types_color.add(rs.getString(i));
					}
				}
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getTypes(int i, int j) {
		switch(j) {
		case 0:
			return Types.get(i);
		case 1:
			return effective_against_Types.get(i);
		case 2:
			return not_effective_against_Types.get(i);
		case 3:
			return immune_Types.get(i);
		default:
			return "Fail to get Types";
		}
		
	}
}
