package studentadventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {
	final static int WIELKOSC_MAPY_X = 6;
	final static int WIELKOSC_MAPY_Y = 5;
	private static Bohater bohater = new Bohater();
	private static SQLManager sqlmanager = new SQLManager();
	private static Scanner czytaczPolecen = new Scanner(System.in);
	private static Tile[][] mapa = new Tile[WIELKOSC_MAPY_X][WIELKOSC_MAPY_Y];

	public static void main(String[] args) {
		Start.menu();
	}

	private static void ruch(String polecenie) {
		int actX = bohater.getX();
		int actY = bohater.getY();
		WorldDirections kierunek = sqlmanager
				.interpretTaskForDirection(polecenie);
		switch (kierunek) {
		case NORTH:
			actX = actX - 1;
			System.out.println(actX);
			if (actX >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.NORTH);
				} else
					System.out.println("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case SOUTH:
			actX = actX + 1;
			System.out.println(actX);
			if (actY <= WIELKOSC_MAPY_X) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.SOUTH);
				} else
					System.out.println("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case WEST:
			actY = actY - 1;
			System.out.println(actY);
			if (actY >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.WEST);
				} else
					System.out.println("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case EAST:
			actY = actY + 1;
			System.out.println(actY);
			if (actY <= WIELKOSC_MAPY_Y) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.EAST);
				} else
					System.out.println("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		default:
			System.out
					.println("Idziesz nie wiadomo gdzie. Może lepiej podaj gdzie chcesz iść.");
			break;
		}
	}

	private static void wczytajMape() {
		File plikMapy = new File("./files/mapa1.map");
		Scanner czytaczMapy = null;

		try {
			czytaczMapy = new Scanner(plikMapy);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		boolean moznoscChodzenia = false;
		String liniaZPliku = czytaczMapy.nextLine();
		int wspolX = Integer.valueOf(liniaZPliku);
		bohater.setX(wspolX);
		liniaZPliku = czytaczMapy.nextLine();
		int wspolY = Integer.valueOf(liniaZPliku);
		bohater.setY(wspolY);
		liniaZPliku = czytaczMapy.nextLine();

		while (true) {
			liniaZPliku = czytaczMapy.nextLine();
			wspolX = Integer.valueOf(liniaZPliku);
			liniaZPliku = czytaczMapy.nextLine();
			wspolY = Integer.valueOf(liniaZPliku);
			
			String opisKafelka = czytaczMapy.nextLine();
			liniaZPliku = czytaczMapy.nextLine();
			if (liniaZPliku.contains("true")) {
				moznoscChodzenia = true;
			} else
				moznoscChodzenia = false;

			System.out.println(wspolX + " " + wspolY + " \n" + opisKafelka + " \n" + moznoscChodzenia + "\n");

			mapa[wspolX][wspolY] = new Tile(wspolX, wspolY, opisKafelka,
					moznoscChodzenia);
			
			if(czytaczMapy.hasNextLine())
				liniaZPliku = czytaczMapy.nextLine();
			else break;
		}
	}

	private static void gra() {
		wczytajMape();
		System.out
				.println("\"...i oto właśnie drodzy państwo jest transformata Fouriera\"\n"
						+ "'Boże co za nudy'\n"
						+ "'Ciekawe jak kiedyś uczył profesor'\n"
						+ "*Myśli intensywnie*\n"
						+ "'Wiem, zbuduje wehikuł czasu!\n"
						+ "'Ale najpierw potrzebuję urlopu dziekańskiego\n"
						+ "'Muszę iść do dziekanatu!'");

		while (true) {
			System.out.println(bohater.getX() + " " + bohater.getY());
			System.out.println(mapa[bohater.getX()][bohater.getY()].getOpis());
			System.out.println("Podaj polecenie:");
			String polecenie = czytaczPolecen.nextLine();
			Akcja zPolecenia = sqlmanager.interpretTaskForCommand(polecenie);
			switch (zPolecenia) {
			case RUCH:
				Start.ruch(polecenie);
				break;
			case WALKA:
				System.out.println("Rozpoczynasz walkę. Bądź ostrożny.");
				break;
			case JESC:
				System.out
						.println("Zjadasz coś. Czujesz, jak wzrastasz w siłę.");
				break;
			case ZALOZ:
				System.out
						.println("Zakładasz na siebie wskazany element ekwipunku.");
				break;
			case ZDEJMIJ:
				System.out
						.println("Zdejmujesz z siebie wskazany element odzieży.");
				break;
			case SPOJRZ:
				System.out.println("Rozejrzyj się. Co znajduje się wokół?");
				break;
			case ROZMOWA:
				System.out
						.println("Rozpocznij rozmowę z zacnym NPC. Postaraj się dowiedzieć od niego jak najwięcej.");
				break;
			case UZYJ:
				System.out
						.println("Użyj wybranego przez siebie przedmiotu z ekwipunku.");
				break;
			case ODPOCZYNEK:
				System.out
						.println("Odpocznij tu przez chwilę. Wszystko wokół staje się odległe i nieistotne, zapadasz w głęboki sen.\n"
								+ "Postaraj się nie chrapać, zwracanie na siebie uwagi strażnika nie jest najlepszym pomysłem.");
				break;
			case BRAK:
				System.out.println("Sformułuj swoje polecenie inaczej.");
				break;
			}
		}
	}

	private static void menu() {
		boolean controlVar = true;
		while (controlVar) {
			System.out.println("Witaj w Student Adventure");
			System.out.println("-------------------------");
			System.out.println("1. Graj");
			System.out.println("2. Wyjdz");
			int wybor = czytaczPolecen.nextInt();
			switch (wybor) {
			case 1:
				Start.gra();
				break;
			case 2:
				controlVar = false;
				break;
			default:
				System.out.println("Nie ma takiej opcji!");
				System.out.println("Wybierz inna!");
				break;
			}
		}
	}

}
