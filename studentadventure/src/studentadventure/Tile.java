package studentadventure;

import java.util.ArrayList;
import java.util.List;

public class Tile {
	private int x,y;
	private String opis;
	private boolean czyMoznaPoTymChodzic;
	private List<Postac> pobliskieNPC;
	private List<WorldDirections> mozliweKierunki;
	
	public Tile() {
		pobliskieNPC = new ArrayList<Postac>();
		setMozliweKierunki(new ArrayList<WorldDirections>());
	}
	
	public Tile(int _x, int _y, String _opis, boolean move) {
		setX(_x);
		setY(_y);
		setOpis(_opis);
		setCzyMoznaPoTymChodzic(move);
		pobliskieNPC = new ArrayList<Postac>();
		setMozliweKierunki(new ArrayList<WorldDirections>());
	}
	
	public boolean dodajNPC(String nazwa, String about) {
		NPC nowy = new NPC();
		nowy.setNazwa(nazwa);
		nowy.setOpis(about);
		pobliskieNPC.add(nowy);
		return true;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public boolean isCzyMoznaPoTymChodzic() {
		return czyMoznaPoTymChodzic;
	}
	public void setCzyMoznaPoTymChodzic(boolean czyMoznaPoTymChodzic) {
		this.czyMoznaPoTymChodzic = czyMoznaPoTymChodzic;
	}
	public List<Postac> getPobliskieNPC() {
		return pobliskieNPC;
	}
	public void setPobliskieNPC(List<Postac> pobliskieNPC) {
		this.pobliskieNPC = pobliskieNPC;
	}

	public List<WorldDirections> getMozliweKierunki() {
		return mozliweKierunki;
	}

	public void setMozliweKierunki(List<WorldDirections> mozliweKierunki) {
		this.mozliweKierunki = mozliweKierunki;
	} 
}
