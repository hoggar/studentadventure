package studentadventure;

import java.util.List;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bohater extends Postac {
	private boolean czyRozmawia;
	private int mpAkt; // aktualne punkty many
	private int mpMAX; // maksymalne punkty many
	private int exp; // ilosc posiadanych punktow doswiadczenia
	private int sila; // ilosc punktow sily
	private int inteligencja; // ilosc punktow inteligencji
	private int wytrzymalosc; // ilosc punktow wytrzymalosci
	private int charyzma; // ilosc punktow charyzmy
	private static Image obrazekPostaci;
	
	private List<Przedmiot> posiadanePrzedmioty;

	public String statystyki() {
		String temp = "HP: " + hpAkt + "\\" + hpMAX + "\n" + "MP: " + mpAkt
				+ "\\" + mpMAX + "\n" + "EXP: " + exp + "\n" + "STR: " + sila
				+ "   INT: " + inteligencja + "\n" + "END: " + wytrzymalosc + "   CHAR: " + charyzma;
		return temp;
	}
	
	public Bohater() {
		sila=50;
		exp=0;
		inteligencja=50;
		wytrzymalosc=50;
		charyzma=50;
		hpMAX=100+10*wytrzymalosc;
		try {
			obrazekPostaci = ImageIO.read(new File("./files/bohater.gif"));
		} catch (IOException e) {
			System.err.println("Bohater nie ma obrazka");
			e.printStackTrace();
		}
	}

	public String ekwipunek() {
		String temp = null;
		for (Przedmiot aktPrzedmiot : posiadanePrzedmioty) {
			temp.concat(aktPrzedmiot.getnazwa());
			temp.concat("\n");
		}
		return temp;
	}

	public void ruch(WorldDirections kierunek) {
		switch (kierunek) {
		case NORTH:
			y = y - 1;
			break;
		case SOUTH:
			y = y + 1;
			break;
		case WEST:
			x = x - 1;
			break;
		case EAST:
			x = x + 1;
			break;
		}
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

	public static Image getObrazekPostaci() {
		return obrazekPostaci;
	}

	public static void setObrazekPostaci(Image obrazekPostaci) {
		Bohater.obrazekPostaci = obrazekPostaci;
	}
	
	public boolean isCzyRozmawia() {
		return czyRozmawia;
	}

	public void setCzyRozmawia(boolean czyRozmawia) {
		this.czyRozmawia = czyRozmawia;
	}


}
