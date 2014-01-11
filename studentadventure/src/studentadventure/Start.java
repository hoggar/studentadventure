package studentadventure;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Start {
	final static int WIELKOSC_MAPY = 10;
	public static Bohater bohater = new Bohater();
	private static SQLManager sqlmanager = new SQLManager();
	public static Tile[][] mapa = new Tile[WIELKOSC_MAPY][WIELKOSC_MAPY];
	private static Okienko frame;

	public static void main(String[] args) {
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
			actX = actX - 1;
			if (actX >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.NORTH);
				} else
					frame.pisz("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case SOUTH:
			actX = actX + 1;
			if (actX < WIELKOSC_MAPY) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.SOUTH);
				} else
					frame.pisz("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case WEST:
			actY = actY - 1;
			if (actY >= 0) {
				if (mapa[actX][actY].isCzyMoznaPoTymChodzic()) {
					bohater.ruch(WorldDirections.WEST);
				} else
					frame.pisz("'Nie moge tam isc!'");
			} else
				System.out.println("KONIEC MAPY!");
			break;
		case EAST:
			actY = actY + 1;
			if (actY < WIELKOSC_MAPY) {
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

		switch(numerMapy) {
		case 1:
			bohater.setX(0);
			bohater.setY(0);
			plikMapy = new File("./files/dziekanat.map");
			wczytajMape(plikMapy);
			break;
		}
	}
	
	public static void wczytajMape(File plikMapy) {
		Scanner czytaczMapy = null;
		try {
			czytaczMapy = new Scanner(plikMapy);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String opis = "";
		boolean cMC = false;
		for (int y = 0; y < WIELKOSC_MAPY; y++) {
			for (int x = 0; x < WIELKOSC_MAPY; x++) {
				int rodzajPola = czytaczMapy.nextInt();
				try {
					mapa[x][y] = new Tile(rodzajPola,x,y);
				} catch (IOException e) {
					System.err.println("Nie dziala tworzenie mapy");
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void btnOnClick() {
		String polecenie = frame.getCmdFieldText();
		Akcja zPolecenia = sqlmanager.interpretTaskForCommand(polecenie);
		
		switch (zPolecenia) {
		case RUCH:
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
			frame.pisz("Rozpocznij rozmowę z zacnym NPC. Postaraj się dowiedzieć od niego jak najwięcej.");
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
	
	private static void gra() {
		wybierzMape(1);
		frame.repaint();
		frame.pisz("\"...i oto właśnie drodzy państwo jest transformata Fouriera\"\n\n"
						+ "'Boże co za nudy'\n"
						+ "'Ciekawe jak kiedyś uczył profesor'\n"
						+ "*Myśli intensywnie*\n"
						+ "'Wiem, zbuduje wehikuł czasu!\n"
						+ "'Ale najpierw potrzebuję urlopu dziekańskiego\n"
						+ "'Muszę iść do dziekanatu!'\n");
	}

}
