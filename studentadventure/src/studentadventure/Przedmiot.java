package studentadventure;

public class Przedmiot {
	protected String nazwa; // nazwa przedmiotu
	protected String opis; //opis przedmiotu
	
	protected int level; //poziom przedmiotu
	protected int x; //wspolrzedna x przedmiotu na mapie
	protected int y; // wspolrzedna y przedmiotu na mapie
	
	
public Przedmiot(int x2, int y2, String nazwa2, String opis2) {
		x=x2;
		y=y2;
		nazwa=nazwa2;
		opis=opis2;
	
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

}