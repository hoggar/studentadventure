package studentadventure;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SQLManager {
	private final static String DRIVER = "org.sqlite.JDBC";
	private final static String DB_URL = "jdbc:sqlite:testSQL.db";

	private Connection conn;
	private Statement stat;

	public SQLManager() {
		try {
			Class.forName(SQLManager.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika");
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		createTables();
	}

	private boolean createTables() {
		String createCommandTable = "CREATE TABLE IF NOT EXISTS command (command VARCHAR(20) NOT NULL, action VARCHAR(20) NOT NULL)";
		try {
			stat.execute(createCommandTable);
		} catch (SQLException e) {
			System.err.println("Nie udalo sie stworzyc tabeli etc");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertCommand(String cmdName, String actName) {
		try {
			PreparedStatement prepStmt = conn
					.prepareStatement("INSERT INTO command VALUES (?,?); ");
			prepStmt.setString(1, cmdName);
			prepStmt.setString(2, actName);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Nie udalo sie zainsertowac rekordu");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Command> selectCommands() {
		List<Command> komendy = new LinkedList<Command>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM command");
			String cmdName, actName;
			while (result.next()) {
				cmdName = result.getString("command");
				actName = result.getString("action");
				komendy.add(new Command(cmdName, actName));
			}
		} catch (SQLException e) {
			System.err.println("Nie mozna bylo pobrac rekordow z db!");
			e.printStackTrace();
			return null;
		}
		return komendy;
	}

	public String interpretTask(String task) {
		Command komenda = null;
		try {
			ResultSet result = stat
					.executeQuery("SELECT * FROM command WHERE command='"
							+ task + "'");
			komenda = new Command(result.getString("command"),
					result.getString("action"));
		} catch (SQLException e) {
			System.err
					.println("Zla interpretacja polecenia (brak slowa w slowniku?)");
			e.printStackTrace();
			return null;
		}
		return komenda.getActionName();
	}

}
