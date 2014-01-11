package studentadventure;

import java.util.List;

import java.awt.Image;
import javax.imageio.ImageIO;

public class Bohater extends Postac {
	private int x, y; // współrzędne bohatera
	private int mpAkt; // aktualne punkty many
	private int mpMAX; // maksymalne punkty many
	private int EXP; // ilosc posiadanych punktow doswiadczenia
	private int STR; // ilosc punktow sily
	private int INT; // ilosc punktow inteligencji
	private int END; // ilosc punktow wytrzymalosci
	private int CHAR; // ilosc punktow charyzmy
	//private int Image obrazekPostaci;
	
	private List<Przedmiot> posiadanePrzedmioty;

	public String statystyki() {
		String temp = "HP: " + hpAkt + "\\" + hpMAX + "\n" + "MP: " + mpAkt
				+ "\\" + mpMAX + "\n" + "EXP: " + EXP + "\n" + "STR: " + STR
				+ "   INT: " + INT + "\n" + "END: " + END + "   CHAR: " + CHAR;
		return temp;
	}
	
	//public Bohater() {
	//	obrazekPostaci = ImageIO.read(getClass().getResource("./images/Untitled.png"));
	//}

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
			x = x - 1;
			break;
		case SOUTH:
			x = x + 1;
			break;
		case WEST:
			y = y - 1;
			break;
		case EAST:
			y = y + 1;
			break;
		}
	}

	public List<Przedmiot> getPosiadanePrzedmioty() {
		return posiadanePrzedmioty;
	}

	public void setPosiadanePrzedmioty(List<Przedmiot> posiadanePrzedmioty) {
		this.posiadanePrzedmioty = posiadanePrzedmioty;
	}

	public int getCHAR() {
		return CHAR;
	}

	public void setCHAR(int cHAR) {
		CHAR = cHAR;
	}

	public int getEND() {
		return END;
	}

	public void setEND(int eND) {
		END = eND;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int iNT) {
		INT = iNT;
	}

	public int getSTR() {
		return STR;
	}

	public void setSTR(int sTR) {
		STR = sTR;
	}

	public int getEXP() {
		return EXP;
	}

	public void setEXP(int eXP) {
		EXP = eXP;
	}

	public int getMpMAX() {
		return mpMAX;
	}

	public void setMpMAX(int mpMAX) {
		this.mpMAX = mpMAX;
	}

	public int getMpAkt() {
		return mpAkt;
	}

	public void setMpAkt(int mpAkt) {
		this.mpAkt = mpAkt;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
