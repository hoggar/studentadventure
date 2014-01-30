package studentadventure;

import java.awt.Image;

public abstract class Postac {
	protected int x, y;
	protected String nazwa; // nazwa
	protected int hpMAX, hpAkt; // maksymalne punkty zycia
	protected boolean walecznosc;
	protected Image obrazekPostaci;
	protected Image fightImage;
	
	public Image getObrazekPostaci() {
		return obrazekPostaci;
	}

	public void setObrazekPostaci(Image obrazekPostaci) {
		this.obrazekPostaci = obrazekPostaci;
	}
	
	public boolean isWalecznosc() {
		return walecznosc;
	}

	public void setWalecznosc(boolean walecznosc) {
		this.walecznosc = walecznosc;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHpAkt() {
		return hpAkt;
	}

	public void setHpAkt(int hpAkt) {
		this.hpAkt = hpAkt;
	}

	public String toString() {
		return "<" + getNazwa() + " , " + hpMAX + "\\" + hpAkt + ">";
	}

	public int getHp() {
		return hpAkt;
	}

	public void setHp(int hp) {
		this.hpAkt = hp;
	}

	public int getHpMAX() {
		return hpMAX;
	}

	public void setHpMAX(int hpMAX) {
		this.hpMAX = hpMAX;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}
