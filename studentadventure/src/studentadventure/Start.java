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
				} else
					frame.pisz("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case SOUTH:
			actY = actY + 1;
			if (actY < WIELKOSC_MAPY) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.SOUTH);
				} else
					frame.pisz("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case WEST:
			actX = actX - 1;
			if (actX >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.WEST);
				} else
					frame.pisz("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case EAST:
			actX = actX + 1;
			if (actX < WIELKOSC_MAPY) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.EAST);
				} else
					frame.pisz("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		default:
			frame.pisz("Idziesz nie wiadomo gdzie. Może lepiej podaj gdzie chcesz iść.");
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
		if(bohater.isCzyRozmawia()) {
			
		}
		String polecenie = frame.getCmdFieldText();
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
			System.out.println("UDALO SIE POROZMAWIAC");
			bohater.setCzyRozmawia(true);
			Start.rozmowa(polecenie);
			break;
		case UZYJ:
			frame.pisz("Użyj wybranego przez siebie przedmiotu z ekwipunku.");
			break;
		case ODPOCZYNEK:
			frame.pisz("Odpocznij tu przez chwilę. Wszystko wokół staje się odległe i nieistotne, zapadasz w głęboki sen.\n"
					+ "Postaraj się nie chrapać, zwracanie na siebie uwagi strażnika nie jest najlepszym pomysłem.");
			break;
		case BRAK:
			frame.pisz("Sformułuj swoje polecenie inaczej.");
			break;
		}

		frame.repaint();
	}

	private static void rozmowa(String polecenie) {
		NPC rozmowca = null;
		for (NPC aktPostac : postacieNiezalezne) {
			if ((Math.abs(bohater.getX() - aktPostac.getX()) <= 1)
					|| (Math.abs(bohater.getY() - aktPostac.getY()) <= 1)) {
				rozmowca = aktPostac;
				break;
			}
		}
		Dialog.Type typDialogu = sqlmanager.interpretTaskForDialog(polecenie);
		String dialogNPC = pobranieDialogu(rozmowca.nazwa, typDialogu.toString());
		frame.pisz(dialogNPC);

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
			dialogDoZwrocenia =  bElement.getElementsByTagName(jakiDialog).item(0)
					.getTextContent();
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
