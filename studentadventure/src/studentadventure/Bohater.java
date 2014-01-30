package studentadventure;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class Bohater extends Postac {
	private static final File bohaterNorth = new File(
			"./files/bohater-north.gif");
	private static final File bohaterSouth = new File(
			"./files/bohater-south.gif");
	private static final File bohaterWest = new File("./files/bohater-west.gif");
	private static final File bohaterEast = new File("./files/bohater-east.gif");

	private boolean czyRozmawia;
	private int mpAkt; // aktualne punkty many
	private int mpMAX; // maksymalne punkty many
	private int exp; // ilosc posiadanych punktow doswiadczenia
	private int sila; // ilosc punktow sily
	private int inteligencja; // ilosc punktow inteligencji
	private int wytrzymalosc; // ilosc punktow wytrzymalosci
	private int charyzma; // ilosc punktow charyzmy
	private List<Quest> posiadaneQuesty;
	private List<Przedmiot> posiadanePrzedmioty;

	public String statystyki() {
		String temp = "HP: " + hpAkt + "\\" + hpMAX + "\n" + "MP: " + mpAkt
				+ "\\" + mpMAX + "\n" + "EXP: " + exp + "\n" + "STR: " + sila
				+ "   INT: " + inteligencja + "\n" + "END: " + wytrzymalosc
				+ "   CHAR: " + charyzma;
		return temp;
	}

	public Bohater() {
		posiadaneQuesty = new LinkedList<Quest>();
		posiadanePrzedmioty = new LinkedList<Przedmiot>();
		sila = 50;
		exp = 0;
		inteligencja = 50;
		wytrzymalosc = 50;
		charyzma = 50;
		hpAkt = 100 + 10 * wytrzymalosc;
		hpMAX = 100 + 10 * wytrzymalosc;
		try {
			obrazekPostaci = ImageIO.read(bohaterSouth);
			fightImage = ImageIO.read(new File("./files/bohaterfight.gif"));
		} catch (IOException e) {
			System.err.println("Bohater nie ma obrazka");
			e.printStackTrace();
		}
	}

	public List<Quest> getPosiadaneQuesty() {
		return posiadaneQuesty;
	}

	public void setPosiadaneQuesty(List<Quest> posiadaneQuesty) {
		this.posiadaneQuesty = posiadaneQuesty;
	}

	public String ekwipunek() {
		String temp = "";
		if (posiadanePrzedmioty.size() != 0) {
			for (Przedmiot aktPrzedmiot : posiadanePrzedmioty) {
				temp = temp + "NAZWA: " + aktPrzedmiot.getnazwa() + "\nOPIS: "
						+ aktPrzedmiot.getopis();
				temp = temp + "\n";
			}
		} else
			temp = temp + "Brak przedmiotow\n";
		return temp;
	}

	public String questy() {
		String temp = "";
		if (posiadaneQuesty.size() != 0) {
			for (Quest aktQuest : posiadaneQuesty) {
				temp = temp + "Nazwa: " + aktQuest.getNazwa() + "\nCEL: "
						+ aktQuest.getCel() + "\n";
			}
		} else
			temp = temp + "Brak questow/zadan\n";
		return temp;
	}

	public void ruch(WorldDirections kierunek) {
		try {
			switch (kierunek) {
			case NORTH:
				y = y - 1;
				obrazekPostaci = ImageIO.read(bohaterNorth);
				break;
			case SOUTH:
				y = y + 1;
				obrazekPostaci = ImageIO.read(bohaterSouth);
				break;
			case WEST:
				x = x - 1;
				obrazekPostaci = ImageIO.read(bohaterWest);
				break;
			case EAST:
				x = x + 1;
				obrazekPostaci = ImageIO.read(bohaterEast);
				break;
			}
		} catch (IOException e) {
			System.err.println("Nie udalo sie zmienic obrazka postaci");
			e.printStackTrace();
		}
		this.czyRozmawia = false;
	}

	public List<Przedmiot> getPosiadanePrzedmioty() {
		return posiadanePrzedmioty;
	}

	public void setPosiadanePrzedmioty(List<Przedmiot> posiadanePrzedmioty) {
		this.posiadanePrzedmioty = posiadanePrzedmioty;
	}

	public int getMpAkt() {
		return mpAkt;
	}

	public void setMpAkt(int mpAkt) {
		this.mpAkt = mpAkt;
	}

	public int getMpMAX() {
		return mpMAX;
	}

	public void setMpMAX(int mpMAX) {
		this.mpMAX = mpMAX;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getSila() {
		return sila;
	}

	public void setSila(int sila) {
		this.sila = sila;
	}

	public int getInteligencja() {
		return inteligencja;
	}

	public void setInteligencja(int inteligencja) {
		this.inteligencja = inteligencja;
	}

	public int getWytrzymalosc() {
		return wytrzymalosc;
	}

	public void setWytrzymalosc(int wytrzymalosc) {
		this.wytrzymalosc = wytrzymalosc;
	}

	public int getCharyzma() {
		return charyzma;
	}

	public void setCharyzma(int charyzma) {
		this.charyzma = charyzma;
	}


	public boolean isCzyRozmawia() {
		return czyRozmawia;
	}

	public void setCzyRozmawia(boolean czyRozmawia) {
		this.czyRozmawia = czyRozmawia;
	}

}
