package studentadventure;

public abstract class Przedmiot {
	protected String nazwa; // nazwa przedmiotu
	protected String opis; //opis przedmiotu
	protected int level; //poziom przedmiotu
	
public String toString() {
	return "Przedmiot: " + nazwa + "ma poziom:  " + level;
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