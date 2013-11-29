package studentadventure;

import java.util.Scanner;

public class Start {
	private static Bohater bohater = new Bohater();
	private static SQLManager sqlmanager = new SQLManager();
	static Scanner czytaczPolecen = new Scanner(System.in);

	public static void main(String[] args) {
		Start.menu();
	}
	
	private static void ruch(String polecenie) {
		WorldDirections kierunek = sqlmanager.interpretTaskForDirection(polecenie);
		switch(kierunek) {
		case NORTH:
			System.out.println("Idziesz na polnoc");
			break;
		case SOUTH:
			System.out.println("Idziesz na poludnie");
			break;
		case WEST:
			System.out.println("Idziesz na zachod");
			break;
		case EAST:
			System.out.println("Idziesz na wschod");
			break;
		default:
			break;
		}
	}
	
	private static void gra() {
		while(true) {
			System.out.println("Podaj polecenie:");
			String polecenie = czytaczPolecen.nextLine();
			polecenie = czytaczPolecen.nextLine();
			Akcja zPolecenia = sqlmanager.interpretTaskForCommand(polecenie);
			switch (zPolecenia) {
			case RUCH:
				Start.ruch(polecenie);
				break;
			case WALKA:
				System.out.println("Rozpoczynasz walkę. Bądź ostrożny.");
				break;
			case JESC:
				System.out.println("Zjadasz coś. Czujesz, jak wzrastasz w siłę.");
				break;
			case ZALOZ:
				System.out.println("Zakładasz na siebie wskazany element ekwipunku.");
				break;
			case ZDEJMIJ:
				System.out.println("Zdejmujesz z siebie wskazany element odzieży.");
				break;
			case SPOJRZ:
				System.out.println("Rozejrzyj się. Co znajduje się wokół?");
				break;
			case ROZMOWA:
				System.out.println("Rozpocznij rozmowę z zacnym NPC. Postaraj się dowiedzieć od niego jak najwięcej.");
				break;
			case UZYJ:
				System.out.println("Użyj wybranego przez siebie przedmiotu z ekwipunku.");
				break;
			case ODPOCZYNEK:
				System.out.println("Odpocznij tu przez chwilę. Wszystko wokół staje się odległe i nieistotne, zapadasz w głęboki sen.\n"
						+ "Postaraj się nie chrapać, zwracanie na siebie uwagi strażnika nie jest najlepszym pomysłem.");
				break;
			case BRAK:
				System.out.println("Sformułuj swoje polecenie inaczej.");
				break;
			}
		}
	}

	private static void menu() {
		while (true) {
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
				break;
			default:
				System.out.println("Nie ma takiej opcji!");
				System.out.println("Wybierz inna!");
				break;
			}
		}
	}

}
