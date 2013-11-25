package studentadventure;

public abstract class Postac {
protected String opis; //opis postaci
protected String nazwa; // nazwa
protected int hpMAX; // maksymalne punkty zycia
protected int hpAkt; // aktualne punkty zycia

public String toString() {
	return "<" + nazwa + " , " + hpMAX + "\\" + hpAkt + ">";
}
public int getHp() {
	return hpAkt;
}
public void setHp(int hp) {
	this.hpAkt = hp;
}

public String getopis() {
	return opis;
}
public void setopis(String opis) {
	this.opis = opis;
}
public String about() {
	return nazwa + " to " + opis; 
}
public int getHpMAX() {
	return hpMAX;
}
public void setHpMAX(int hpMAX) {
	this.hpMAX = hpMAX;
}

}
