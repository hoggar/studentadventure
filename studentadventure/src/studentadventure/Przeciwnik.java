package studentadventure;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Przeciwnik extends Postac {
	private int ileDajeExp;
	private int atak;
	private int obrona;
	private String opis;
	
	public Przeciwnik(int numerPrzeciwnika) {
		switch(numerPrzeciwnika) {
		case 1:
			nazwa="Szczur";
			x=7;
			y=8;
			atak=15;
			obrona=5;
			hpAkt=50;
			hpMAX=50;
			try {
				obrazekPostaci = ImageIO.read(new File("./files/images/przeciwnicy/szczur.gif"));
				fightImage = ImageIO.read(new File("./files/images/przeciwnicy/szczurfight.gif"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	
	public int getIleDajeExp() {
		return ileDajeExp;
	}
	public void setIleDajeExp(int ileDajeExp) {
		this.ileDajeExp = ileDajeExp;
	}
	public int getAtak() {
		return atak;
	}
	public void setAtak(int atak) {
		this.atak = atak;
	}
	public int getObrona() {
		return obrona;
	}
	public void setObrona(int obrona) {
		this.obrona = obrona;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Image getFightImage() {
		return fightImage;
	}
	public void setFightImage(Image fightImage) {
		this.fightImage = fightImage;
	}
}
