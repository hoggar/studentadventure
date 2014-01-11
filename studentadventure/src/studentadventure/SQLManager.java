package studentadventure;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLManager {
	private final static String DRIVER = "org.sqlite.JDBC";
	private final static String DB_URL = "jdbc:sqlite:gamedb.db";

	private Connection conn;
	private Statement stat;

	public SQLManager() {
		boolean doesDBFileExists = false;
		Path pathOfDB = Paths.get("gamedb.db");
		if(Files.exists(pathOfDB)) {
			doesDBFileExists = true;
		}
		
		try {
			Class.forName(SQLManager.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika");
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
			System.out.println("Jest polaczenie z DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(!doesDBFileExists) {
			createTables();
			insertValues();
		}
	}

	private boolean createTables() {
		String createCommandTable = "CREATE TABLE IF NOT EXISTS command (command VARCHAR(20) NOT NULL, action VARCHAR(20) NOT NULL)";
		String createWorldDirectionsTable = "CREATE TABLE IF NOT EXISTS direction (word VARCHAR(20) NOT NULL, direction VARCHAR(20) NOT NULL)";
		try {
			stat.execute(createCommandTable);
			stat.execute(createWorldDirectionsTable);
		} catch (SQLException e) {
			System.err.println("Nie udalo sie stworzyc tabeli etc");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean insertValues() {
		List<String> insertCommands = new ArrayList<String>();
		List<String> insertWorldDirections = new ArrayList<String>();

		// Uzupelnianie list zapytaniami insert
		insertValuesIntoInsertCommandList(insertCommands);
		insertValuesIntoInsertWorldDirectionsList(insertWorldDirections);

		// Wykonaj kazde zapytanie insertCommand
		for (String actualInsertQuery : insertCommands) {
			try {
				stat.execute(actualInsertQuery);
			} catch (SQLException e) {
				System.err.println("Nie udalo sie insertowac");
				e.printStackTrace();
				return false;
			}
		}

		// Wykonaj kazde zapytanie insertWorldDirections
		for (String actualInsertQuery : insertWorldDirections) {
			try {
				stat.execute(actualInsertQuery);
			} catch (SQLException e) {
				System.err.println("Nie udalo sie insertowac");
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}

	private void insertValuesIntoInsertWorldDirectionsList(List<String> list) {
		list.add("INSERT INTO direction VALUES ('polnoc','NORTH')");
		list.add("INSERT INTO direction VALUES ('pln','NORTH')");
		list.add("INSERT INTO direction VALUES ('pn','NORTH')");
		list.add("INSERT INTO direction VALUES ('north','NORTH')");
		list.add("INSERT INTO direction VALUES ('n','NORTH')");
		list.add("INSERT INTO direction VALUES ('poludnie','SOUTH')");
		list.add("INSERT INTO direction VALUES ('pld','SOUTH')");
		list.add("INSERT INTO direction VALUES ('pd','SOUTH')");
		list.add("INSERT INTO direction VALUES ('south','SOUTH')");
		list.add("INSERT INTO direction VALUES ('s','SOUTH')");
		list.add("INSERT INTO direction VALUES ('zachod','WEST')");
		list.add("INSERT INTO direction VALUES ('zach','WEST')");
		list.add("INSERT INTO direction VALUES ('west','WEST')");
		list.add("INSERT INTO direction VALUES ('w','WEST')");
		list.add("INSERT INTO direction VALUES ('wschod','EAST')");
		list.add("INSERT INTO direction VALUES ('wsch','EAST')");
		list.add("INSERT INTO direction VALUES ('east','EAST')");
		list.add("INSERT INTO direction VALUES ('e','EAST')");
	}

	private void insertValuesIntoInsertCommandList(List<String> list) {
		list.add("INSERT INTO command VALUES ('idz','RUCH')");
		list.add("INSERT INTO command VALUES ('pojdz','RUCH')");
		list.add("INSERT INTO command VALUES ('rusz','RUCH')");
		list.add("INSERT INTO command VALUES ('wyrusz','RUCH')");
		list.add("INSERT INTO command VALUES ('wyruszaj','RUCH')");
		list.add("INSERT INTO command VALUES ('porusz','RUCH')");
		list.add("INSERT INTO command VALUES ('poruszaj','RUCH')");
		list.add("INSERT INTO command VALUES ('podazaj','RUCH')");
		list.add("INSERT INTO command VALUES ('przejdz','RUCH')");
		list.add("INSERT INTO command VALUES ('przesun','RUCH')");
		list.add("INSERT INTO command VALUES ('rozmawiaj','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('porozmawiaj','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('powiedz','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('pogadaj','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('zagadaj','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('zagaj','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('oznajmij','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('wypowiedz','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('opowiedz','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('przepowiedz','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('odpowiedz','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('podpowiedz','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('zapowiedz','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('gadaj','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('mow','ROZMOWA')");
		list.add("INSERT INTO command VALUES ('walcz','WALKA')");
		list.add("INSERT INTO command VALUES ('zabij','WALKA')");
		list.add("INSERT INTO command VALUES ('uderz','WALKA')");
		list.add("INSERT INTO command VALUES ('atakuj','WALKA')");
		list.add("INSERT INTO command VALUES ('zaatakuj','WALKA')");
		list.add("INSERT INTO command VALUES ('kontratakuj','WALKA')");
		list.add("INSERT INTO command VALUES ('powalcz','WALKA')");
		list.add("INSERT INTO command VALUES ('zawalcz','WALKA')");
		list.add("INSERT INTO command VALUES ('bij','WALKA')");
		list.add("INSERT INTO command VALUES ('zbij','WALKA')");
		list.add("INSERT INTO command VALUES ('pobij','WALKA')");

		// Kierunki
		list.add("INSERT INTO command VALUES ('polnoc','RUCH')");
		list.add("INSERT INTO command VALUES ('pln','RUCH')");
		list.add("INSERT INTO command VALUES ('pn','RUCH')");
		list.add("INSERT INTO command VALUES ('n','RUCH')");
		list.add("INSERT INTO command VALUES ('poludnie','RUCH')");
		list.add("INSERT INTO command VALUES ('pld','RUCH')");
		list.add("INSERT INTO command VALUES ('pd','RUCH')");
		list.add("INSERT INTO command VALUES ('s','RUCH')");
		list.add("INSERT INTO command VALUES ('zachod','RUCH')");
		list.add("INSERT INTO command VALUES ('zach','RUCH')");
		list.add("INSERT INTO command VALUES ('w','RUCH')");
		list.add("INSERT INTO command VALUES ('wschod','RUCH')");
		list.add("INSERT INTO command VALUES ('wsch','RUCH')");
		list.add("INSERT INTO command VALUES ('e','RUCH')");
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

	private String dePolish(String taskToDePolish) {
		String depolishedTask = taskToDePolish;
		depolishedTask = depolishedTask.replaceAll("ń", "n");
		depolishedTask = depolishedTask.replaceAll("ę", "e");
		depolishedTask = depolishedTask.replaceAll("ź", "z");
		depolishedTask = depolishedTask.replaceAll("ą", "a");
		depolishedTask = depolishedTask.replaceAll("ć", "c");
		depolishedTask = depolishedTask.replaceAll("ó", "o");
		depolishedTask = depolishedTask.replaceAll("ż", "z");
		depolishedTask = depolishedTask.replaceAll("ł", "l");
		return depolishedTask;
	}

	public Akcja interpretTaskForCommand(String task) {
		Command komenda = null;
		String depolishedTask = dePolish(task);
		String[] splitedTask = depolishedTask.split("\\s");
		for (String actualTask : splitedTask) {

			try {
				ResultSet result = stat
						.executeQuery("SELECT COUNT(*) AS 'doesExist' FROM command WHERE command='"
								+ actualTask.toLowerCase() + "'");

				if (result.getInt("doesExist") != 0) {
					result = stat
							.executeQuery("SELECT * FROM command WHERE command='"
									+ actualTask.toLowerCase() + "'");
					komenda = new Command(result.getString("command"),
							result.getString("action"));

					for (Akcja akcja : Akcja.values()) {
						if (akcja.toString().equalsIgnoreCase(
								komenda.getActionName()))
							return akcja;
					}

				}
			} catch (SQLException e) {
				System.err
						.println("Zla interpretacja polecenia (brak slowa w slowniku?)");
				e.printStackTrace();
			}

		}
		return Akcja.BRAK;
	}

	public WorldDirections interpretTaskForDirection(String task) {
		Direction kierunek = null;
		String depolishedTask = dePolish(task);
		String[] splitedTask = depolishedTask.split("\\s");
		for (String actualTask : splitedTask) {

			try {
				ResultSet result = stat
						.executeQuery("SELECT COUNT(*) AS 'doesExist' FROM direction WHERE word='"
								+ actualTask.toLowerCase() + "'");

				if (result.getInt("doesExist") != 0) {
					result = stat
							.executeQuery("SELECT * FROM direction WHERE word='"
									+ actualTask.toLowerCase() + "'");
					kierunek = new Direction(result.getString("word"),
							result.getString("direction"));

					for (WorldDirections kierSwiata : WorldDirections.values()) {
						if (kierunek.getDirection().equalsIgnoreCase(
								kierSwiata.toString()))
							return kierSwiata;
					}

				}
			} catch (SQLException e) {
				System.err
						.println("Zla interpretacja polecenia (brak slowa w slowniku?)");
				e.printStackTrace();
			}

		}
		return WorldDirections.BRAK;
	}
}