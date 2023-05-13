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
	public static ArrayList<Integer> PokemonNumbers = new ArrayList<Integer>();
	public static ArrayList<String> Pokemon_Names = new ArrayList<String>();
	public static String type1;
	public static String type2;
	

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

	public static void getTypes(String type, int j, int k) {
		try {
			Statement stmt = con.createStatement();

			if (j == 0) {
				ResultSet rs = stmt.executeQuery("SELECT Types FROM Pokemon_Types");
				int columns = rs.getMetaData().getColumnCount();
				Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						Types.add(rs.getString(i));

					}
				}
				rs.close();
				stmt.close();
			}
			if (j == 1 && k == 1) {
				ResultSet rs = stmt
						.executeQuery("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '" + type + "'");
				int columns = rs.getMetaData().getColumnCount();
				effective_against_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						effective_against_Types.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			}
			if (j == 2 && k == 1) {
				ResultSet rs = stmt.executeQuery(
						"SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '" + type + "'");
				int columns = rs.getMetaData().getColumnCount();
				not_effective_against_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						not_effective_against_Types.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			}
			if (j == 3 && k == 1) {
				ResultSet rs = stmt
						.executeQuery("SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + type + "'");
				int columns = rs.getMetaData().getColumnCount();
				immune_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						immune_Types.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			}
			if (j == 4) {
				ResultSet rs = stmt.executeQuery("SELECT Type_color FROM Pokemon_Types");
				int columns = rs.getMetaData().getColumnCount();
				types_color.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						types_color.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			}
			if (j == 1 && k == 2) {
				ResultSet rs = stmt
						.executeQuery("SELECT Type FROM Pokemon_Type_Effective WHERE Effective LIKE '" + type + "'");
				int columns = rs.getMetaData().getColumnCount();
				effective_against_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						effective_against_Types.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			}
			if (j == 2 && k == 2) {
				ResultSet rs = stmt.executeQuery(
						"SELECT Type FROM Pokemon_Type_Not_Effective WHERE Not_Effective LIKE '" + type + "'");
				int columns = rs.getMetaData().getColumnCount();
				not_effective_against_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						not_effective_against_Types.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			}
			if (j == 3 && k == 2) {
				ResultSet rs = stmt
						.executeQuery("SELECT Type FROM Pokemon_Type_Immune WHERE Immune LIKE '" + type + "'");
				int columns = rs.getMetaData().getColumnCount();
				immune_Types.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						immune_Types.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getTypes(int i, int j) {
		switch (j) {
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

	public static void getPokemonNumber(String firstType, String secondType) {
		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("Select Pokedex_Number From Pokemon_Number_Types WHERE Primary_Type IS '"
					+ firstType + "' AND Secondary_Type IS '" + secondType + "' OR Primary_Type IS '" + secondType
					+ "' AND Secondary_Type IS '" + firstType + "'");
			int columns = rs.getMetaData().getColumnCount();
			PokemonNumbers.clear();
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					PokemonNumbers.add(rs.getInt(i));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void getPokemonNames(int j) {
		if (j == 0) {

			try {
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery("Select Pokemon_Name From Pokemon_Number_Types");
				int columns = rs.getMetaData().getColumnCount();
				PokemonNumbers.clear();
				while (rs.next()) {
					for (int i = 1; i <= columns; i++) {
						Pokemon_Names.add(rs.getString(i));
					}
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}

	public static void getPokemonTypes(int j) {
		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("Select Primary_type from Pokemon_Number_Types where Pokedex_Number IS '"+ j +"'");
			type1 = rs.getString(1);
			
			rs = stmt.executeQuery("Select Secondary_type from Pokemon_Number_Types where Pokedex_Number IS '"+ j +"'");
			type2 = rs.getString(1);
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
