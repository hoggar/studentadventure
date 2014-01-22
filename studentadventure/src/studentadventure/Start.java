package studentadventure;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import static java.lang.reflect.Array.get;

public class Start {
	final static int WIELKOSC_MAPY = 10;
	public static Bohater bohater = new Bohater();
	private static List<NPC> postacieNiezalezne = new LinkedList<NPC>();
	private static SQLManager sqlmanager = new SQLManager();
	public static Tile[][] mapa = new Tile[WIELKOSC_MAPY][WIELKOSC_MAPY];
	private static Okienko frame;
	private static File plikDialogow;

	public static void main(String[] args) {
		wybierzMape(1);
		frame = new Okienko();
		frame.setVisible(true);
		Start.gra();
	}

	private static void ruch(String polecenie) {
		int actX = bohater.getX();
		int actY = bohater.getY();
		WorldDirections kierunek = sqlmanager
				.interpretTaskForDirection(polecenie);
		switch (kierunek) {
		case NORTH:
			actY = actY - 1;
			if (actY >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.NORTH);
					frame.pisz("*Idziesz na północ*");
				} else
					frame.piszBlad("'Nie moge tam isc!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iść. Nawet jakbym chciał");
			break;
		case SOUTH:
			actY = actY + 1;
			if (actY < WIELKOSC_MAPY) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.SOUTH);
					frame.pisz("*Idziesz na południe*");
				} else
					frame.piszBlad("'Nie moge tam isc!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iść. Nawet jakbym chciał");
			break;
		case WEST:
			actX = actX - 1;
			if (actX >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.WEST);
					frame.pisz("*Idziesz na zachód*");
				} else
					frame.piszBlad("'Nie moge tam isc!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iść. Nawet jakbym chciał");
			break;
		case EAST:
			actX = actX + 1;
			if (actX < WIELKOSC_MAPY) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.EAST);
					frame.pisz("*Idziesz na wschód*");
				} else
					frame.piszBlad("'Nie moge tam isc!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iść. Nawet jakbym chciał");
			break;
		}
	}

	private static void wybierzMape(int numerMapy) {
		File plikMapy = null;
		File plikNPC;

		switch (numerMapy) {
		case 1:
			bohater.setX(0);
			bohater.setY(0);
			plikNPC = new File("./files/dziekanat.boh");
			plikMapy = new File("./files/dziekanat.map");
			plikDialogow = new File("./files/dialogi/dziekanat.xml");
			wczytajZasoby(plikMapy, plikNPC);
			break;
		}
	}

	public static void wczytajZasoby(File plikMapy, File plikNPC) {
		Scanner czytacz = null;
		try {
			czytacz = new Scanner(plikMapy);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int y = 0; y < WIELKOSC_MAPY; y++) {
			for (int x = 0; x < WIELKOSC_MAPY; x++) {
				int rodzajPola = czytacz.nextInt();
				try {
					mapa[x][y] = new Tile(rodzajPola, x, y);
				} catch (IOException e) {
					System.err.println("Nie dziala tworzenie mapy");
					e.printStackTrace();
				}
			}
		}

		try {
			czytacz = new Scanner(plikNPC);
		} catch (FileNotFoundException e) {
			System.err.println("Nie udalo sie odczytac NPC");
			e.printStackTrace();
		}

		while (czytacz.hasNextInt()) {
			int id = czytacz.nextInt();
			System.out.println(id);
			postacieNiezalezne.add(new NPC(id));
		}
	}

	public static void btnOnClick() {

		String polecenie = frame.getCmdFieldText();
		polecenie = polecenie.toLowerCase();
		Akcja zPolecenia = sqlmanager.interpretTaskForCommand(polecenie);

		switch (zPolecenia) {
		case RUCH:
			bohater.setCzyRozmawia(false);
			Start.ruch(polecenie);
			break;
		case WALKA:
			frame.pisz("Rozpoczynasz walkę. Bądź ostrożny.");
			break;
		case JESC:
			frame.pisz("Zjadasz coś. Czujesz, jak wzrastasz w siłę.");
			break;
		case ZALOZ:
			frame.pisz("Zakładasz na siebie wskazany element ekwipunku.");
			break;
		case ZDEJMIJ:
			frame.pisz("Zdejmujesz z siebie wskazany element odzieży.");
			break;
		case SPOJRZ:
			frame.pisz("Rozejrzyj się. Co znajduje się wokół?");
			break;
		case ROZMOWA:
			if (czyNPCJestBlisko()) {
				bohater.setCzyRozmawia(true);
				frame.pisz("Skupiłeś uwagę postaci niezależnej");
			} else
				frame.pisz("Nie masz z kim rozmawiać!");
			break;
		case UZYJ:
			frame.pisz("Użyj wybranego przez siebie przedmiotu z ekwipunku.");
			break;
		case ODPOCZYNEK:
			frame.pisz("Odpocznij tu przez chwilę. Wszystko wokół staje się odległe i nieistotne, zapadasz w głęboki sen.\n"
					+ "Postaraj się nie chrapać, zwracanie na siebie uwagi strażnika nie jest najlepszym pomysłem.");
			break;
		case POKAZ:
			Pokazywanie coPokazac = sqlmanager
					.interpretTaskForPokazywanie(polecenie);
			if (coPokazac != null) {
				if (coPokazac.getZnaczenie().equalsIgnoreCase("PRZEDMIOTY")) {
					frame.piszReszta(bohater.ekwipunek());
				} else if (coPokazac.getZnaczenie().equalsIgnoreCase("QUESTY")) {
					frame.piszReszta(bohater.questy());
				}
			} else frame.piszBlad("'Nie rozumiem'");
			break;
		case BRAK:
			if (bohater.isCzyRozmawia() == false)
				frame.pisz("Sformułuj swoje polecenie inaczej.");
			else
				Start.rozmowa(polecenie);
			break;
		}
		frame.czyscCmdField();
		frame.repaint();
	}

	private static boolean czyNPCJestBlisko() {
		for (NPC aktPostac : postacieNiezalezne) {
			if ((Math.abs(bohater.getX() - aktPostac.getX()) <= 1)
					&& (Math.abs(bohater.getY() - aktPostac.getY()) <= 1)) {
				return true;
			}
		}
		return false;
	}

	private static NPC zwrocRozmowce() {
		for (NPC aktPostac : postacieNiezalezne) {
			if ((Math.abs(bohater.getX() - aktPostac.getX()) <= 1)
					&& (Math.abs(bohater.getY() - aktPostac.getY()) <= 1)) {
				return aktPostac;
			}
		}
		return null;
	}

	private static void rozmowa(String polecenie) {
		NPC rozmowca = zwrocRozmowce();
		frame.piszDialogi("Bohater: " + polecenie);

		String nazwaRozmowcy = rozmowca.getNazwa() + ": ";

		// Wyszukiwanie rodzaju dialogu w DB
		Dialog dialog = null;
		dialog = sqlmanager.interpretTaskForDialog(polecenie);
		if (dialog != null) {
			// Pobieranie dialogu z pliku XML
			String dialogNPC = pobranieDialogu(rozmowca.getNazwaXML(),
					dialog.getZnaczenie());
			if (dialogNPC != null) {
				// Jeśli jest to ZADANIE
				if (dialog.getZnaczenie().equals("ZADANIE")) {
					boolean czyPosiada = false;
					for (Quest aktQuest : bohater.getPosiadaneQuesty()) {
						if (aktQuest.getNazwa().contains("dziekanatu"))
							czyPosiada = true;
					}
					if (!czyPosiada) {
						frame.piszDialogi(nazwaRozmowcy + dialogNPC
								+ "\n===Otrzymales nowe zadanie===");
						bohater.getPosiadaneQuesty().add(new Quest(1));
					}
				} else if (dialog.getZnaczenie().contains("ODPOWIEDZ")) {
					// Jeśli jest to ODPOWIEDZ na zagadkę
					for (Quest aktQuest : bohater.getPosiadaneQuesty()) {
						if ((aktQuest.isCzyZagadka())
								&& (polecenie.contains(aktQuest.getDobraOdp()))) {
							frame.piszDialogi(nazwaRozmowcy + dialogNPC);
							bohater.getPosiadanePrzedmioty().add(
									aktQuest.getNagroda());
							bohater.getPosiadaneQuesty().remove(aktQuest);
						}
					}
				} else
					frame.piszDialogi(nazwaRozmowcy + dialogNPC); // Każdy inny
				// przypadek
			}
		} else
			frame.piszDialogi(nazwaRozmowcy + "Nie rozumiem Pana!");
	}

	private static String pobranieDialogu(String osoba, String jakiDialog) {
		int temp = 0;
		String dialogDoZwrocenia = null;
		try {
			File fXmlFile = new File("/Users/Marcin/Desktop/staff.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(plikDialogow);

			doc.getDocumentElement().normalize();

			// W pole cytowane wpisujesz czyj to ma być dialog
			NodeList bList = doc.getElementsByTagName(osoba);
			Node bNode = bList.item(temp);
			Element bElement = (Element) bNode;

			// W pole cytowane wpisujesz który dialog chcesz
			dialogDoZwrocenia = bElement.getElementsByTagName(jakiDialog)
					.item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dialogDoZwrocenia;
	}

	private static void gra() {
		frame.pisz("\"...i oto właśnie drodzy państwo jest transformata Fouriera\"\n\n"
				+ "'Boże co za nudy'\n"
				+ "'Ciekawe jak kiedyś uczył profesor'\n"
				+ "*Myśli intensywnie*\n"
				+ "'Wiem, zbuduje wehikuł czasu!\n"
				+ "'Ale najpierw potrzebuję urlopu dziekańskiego\n"
				+ "'Muszę iść do dziekanatu!'\n");
	}

}
