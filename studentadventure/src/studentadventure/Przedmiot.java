package studentadventure;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Przedmiot {
	protected String nazwa; // nazwa przedmiotu
	protected String opis; // opis przedmiotu
	protected Image grafikaPrzedmiotu;

	protected int level; // poziom przedmiotu
	protected int x; // wspolrzedna x przedmiotu na mapie
	protected int y; // wspolrzedna y przedmiotu na mapie

	public Przedmiot(int x2, int y2, String nazwa2, String opis2) {
		x = x2;
		y = y2;
		nazwa = nazwa2;
		opis = opis2;
		try {
			switch (nazwa2) {
			case "kulki":
				grafikaPrzedmiotu = ImageIO.read(new File(
						"./files/images/przedmioty/kulki.gif"));
				break;
			case "sprezyna":
				grafikaPrzedmiotu = ImageIO.read(new File(
						"./files/images/przedmioty/sprezyna.gif"));
				break;
			case "zebatki":
				grafikaPrzedmiotu = ImageIO.read(new File(
						"./files/images/przedmioty/cos.gif"));
				break;
			case "narzedzia":
				grafikaPrzedmiotu = ImageIO.read(new File(
						"./files/images/przedmioty/narzedzia.gif"));
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Przedmiot() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Przedmiot: " + nazwa + " ma poziom:  " + level;
	}

	public void setnazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getnazwa() {
		return nazwa;
	}

	public void setopis(String opis) {
		this.opis = opis;
	}

	public String getopis() {
		return opis;
	}

	public String about() {
		return nazwa + " to " + opis;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}