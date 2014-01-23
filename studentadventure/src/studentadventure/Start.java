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
	public static int numerPoziomu;

	public static void main(String[] args) {
		numerPoziomu = 1;
		wybierzMape(numerPoziomu);
		frame = new Okienko();
		frame.setVisible(true);
		Start.gra();
	}

	/**
	 * Funkcja odpowiedzlana za poruszania siê bohatera po mapie
	 * @param polecenie Polecenie wydane przez Gracza
	 */
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
					frame.pisz("*Idziesz na pó³noc*");
				} else
					frame.piszBlad("'Nie moge tam iœæ!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iœæ. Nawet jakbym chcia³");
			break;

		case SOUTH:
			actY = actY + 1;
			if (actY < WIELKOSC_MAPY) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.SOUTH);
					frame.pisz("*Idziesz na po³udnie*");
				} else
					frame.piszBlad("'Nie moge tam iœæ!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iœæ. Nawet jakbym chcia³");
			break;

		case WEST:
			actX = actX - 1;
			if (actX >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.WEST);
					frame.pisz("*Idziesz na zachód*");
				} else
					frame.piszBlad("'Nie moge tam iœæ!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iœæ. Nawet jakbym chcia³");
			break;

		case EAST:
			actX = actX + 1;
			if (actX < WIELKOSC_MAPY) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.EAST);
					frame.pisz("*Idziesz na wschód*");
				} else
					frame.piszBlad("'Nie moge tam iœæ!'");
			} else
				frame.piszBlad("Nie ma gdzie tam iœæ. Nawet jakbym chcia³");
			break;
		}
	}

	/**
	 * Funkcja s³u¿¹ca do ustawienia odpowiednich plików do obiektów
	 * @param numerMapy Numer mapy w grze
	 */
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
		case 2:
			bohater.setX(4);
			bohater.setY(0);
			plikNPC = null;
			plikMapy = new File("./files/garaz.map");
			plikDialogow = null;
			wczytajZasoby(plikMapy, plikNPC);
			break;
		}
	}

	/**
	 * Funkcja odpowiedzialna za wczytywanie zasoboów z pliku do zmiennych
	 * @param plikMapy Plik w którym znajdujê siê mapa
	 * @param plikNPC Plik w którym znajduj¹ siê bohaterzy niezale¿ni
	 */
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
		
		if (plikNPC != null) {
			try {
				czytacz = new Scanner(plikNPC);
			} catch (FileNotFoundException e) {
				System.err.println("Nie uda³o sie odczytaæ NPC");
				e.printStackTrace();
			}

			while (czytacz.hasNextInt()) {
				int id = czytacz.nextInt();
				System.out.println(id);
				postacieNiezalezne.add(new NPC(id));
			}
		}
	}

	/**
	 * Funkcja wyzwalana w trakcie naciœniêcia przycisku
	 */
	public static void btnOnClick() {

		String polecenie = frame.getCmdFieldText();
		polecenie = polecenie.toLowerCase();
		Akcja zPolecenia = sqlmanager.interpretTaskForCommand(polecenie);

		switch (zPolecenia) {
		case RUCH:
			Start.ruch(polecenie);
			break;
		case WALKA:
			frame.pisz("Rozpoczynasz walkÄ™. BÄ…dÅº ostroÅ¼ny.");
			break;
		case JESC:
			frame.pisz("Zjadasz coÅ›. Czujesz, jak wzrastasz w siÅ‚Ä™.");
			break;
		case ZALOZ:
			frame.pisz("ZakÅ‚adasz na siebie wskazany element ekwipunku.");
			break;
		case ZDEJMIJ:
			frame.pisz("Zdejmujesz z siebie wskazany element odzieÅ¼y.");
			break;
		case SPOJRZ:
			frame.pisz("Rozejrzyj siÄ™. Co znajduje siÄ™ wokÃ³Å‚?");
			break;
		case ROZMOWA:
			if (czyNPCJestBlisko()) {
				bohater.setCzyRozmawia(true);
				frame.pisz("Skupi³eœ uwagê postaci niezale¿nej");
			} else
				frame.pisz("Nie masz z kim rozmawiaÄ‡!");
			break;
		case UZYJ:
			frame.pisz("UÅ¼yj wybranego przez siebie przedmiotu z ekwipunku.");
			break;
		case ODPOCZYNEK:
			frame.pisz("Odpocznij tu przez chwilÄ™. Wszystko wokÃ³Å‚ staje siÄ™ odlegÅ‚e i nieistotne, zapadasz w gÅ‚Ä™boki sen.\n"
					+ "Postaraj siÄ™ nie chrapaÄ‡, zwracanie na siebie uwagi straÅ¼nika nie jest najlepszym pomysÅ‚em.");
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
			} else
				frame.piszBlad("'Nie rozumiem'");
			break;
		case BRAK:
			if (bohater.isCzyRozmawia() == false)
				frame.pisz("Sformu³uj swoje polecenie inaczej.");
			else
				Start.rozmowa(polecenie);
			break;
		}
		frame.czyscCmdField();
		frame.repaint();
	}

	/**
	 * Przeszukiwania pól wokó³ bohatera w celu wyszukania NPC
	 * @return Zwraca true jeœli NPC jest blisko lub false gdy nie jest
	 */
	private static boolean czyNPCJestBlisko() {
		for (NPC aktPostac : postacieNiezalezne) {
			if ((Math.abs(bohater.getX() - aktPostac.getX()) <= 1)
					&& (Math.abs(bohater.getY() - aktPostac.getY()) <= 1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Zwraca NPC który jest wokó³ bohatera 
	 * @return Postaæ która jest wokó³ bohatera
	 */
	private static NPC zwrocRozmowce() {
		for (NPC aktPostac : postacieNiezalezne) {
			if ((Math.abs(bohater.getX() - aktPostac.getX()) <= 1)
					&& (Math.abs(bohater.getY() - aktPostac.getY()) <= 1)) {
				return aktPostac;
			}
		}
		return null;
	}
	
	/**
	 * Rozmowê z NPC w grze
	 * @param polecenie Polecenie wydane przez gracza
	 */
	private static void rozmowa(String polecenie) {
		NPC rozmowca = zwrocRozmowce();
		frame.piszDialogi("Bohater: " + polecenie);
		// polecenie = sqlmanager.dePolish(polecenie);

		String nazwaRozmowcy = rozmowca.getNazwa() + ": ";

		// Wyszukiwanie rodzaju dialogu w DB
		Dialog dialog = null;
		dialog = sqlmanager.interpretTaskForDialog(polecenie);
		if (dialog != null) {
			// Pobieranie dialogu z pliku XML
			String dialogNPC = pobranieDialogu(rozmowca.getNazwaXML(),
					dialog.getZnaczenie());
			if (dialogNPC != null) {
				// JeÅ›li jest to ZADANIE
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
					// Jeœli jest to ODPOWIEDZ na zagadkê™
					for (Quest aktQuest : bohater.getPosiadaneQuesty()) {
						if ((aktQuest.isCzyZagadka())
								&& (aktQuest.sprawdzOdpowiedz(polecenie))) {
							frame.piszDialogi(nazwaRozmowcy + dialogNPC);
							bohater.getPosiadanePrzedmioty().add(
									aktQuest.getNagroda());
							bohater.getPosiadaneQuesty().remove(aktQuest);
							numerPoziomu = 2;
							gra();
							wybierzMape(numerPoziomu);
						}
					}
				} else
					frame.piszDialogi(nazwaRozmowcy + dialogNPC); // KaÅ¼dy inny
				// przypadek
			}
		} else
			frame.piszDialogi(nazwaRozmowcy + rozmowca.dajNiezrozumienie());
	}

	/**
	 * Pobieranie dialogu postaci z pliku XMLowego
	 * @param osoba Nazwa NPC do parsowania XML. Zobacz {@link NPC#getNazwaXML()}.
	 * @param jakiDialog Rodzaj dialogu.
	 * @return Dialog NPC
	 */
	private static String pobranieDialogu(String osoba, String jakiDialog) {
		int temp = 0;
		String dialogDoZwrocenia = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(plikDialogow);

			doc.getDocumentElement().normalize();

			// W pole cytowane wpisujesz czyj to ma byÄ‡ dialog
			NodeList bList = doc.getElementsByTagName(osoba);
			Node bNode = bList.item(temp);
			Element bElement = (Element) bNode;

			// W pole cytowane wpisujesz ktÃ³ry dialog chcesz
			dialogDoZwrocenia = bElement.getElementsByTagName(jakiDialog)
					.item(0).getTextContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dialogDoZwrocenia;
	}

	private static void gra() {
		frame.czyscLog();
		
		if(numerPoziomu == 1){
		
		frame.pisz("\"...i oto w³aœnie drodzy pañstwo jest transformata Fouriera\"\n\n"
				+ "'Bo¿e co za nudy'\n"
				+ "'Ciekawe jak kiedyœ uczy³‚ profesor'\n"
				+ "*Myœli intensywnie*\n"
				+ "'Wiem, zbuduje wehiku³‚ czasu!\n"
				+ "'Ale najpierw potrzebujê urlopu dziekañskiego\n"
				+ "'Muszê iœæ do dziekanatu!'\n");
		}
		else if (numerPoziomu == 2)
		{
		frame.pisz("*Znalaz³em siê w swiom gara¿u.\n*"
					+ "Pora na skonstruowanie wehiku³u!\n\n");
			
		}
	}

}
