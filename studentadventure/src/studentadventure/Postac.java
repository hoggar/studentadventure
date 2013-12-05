package studentadventure;

public abstract class Postac {
protected String nazwa; // nazwa
protected int hpMAX; // maksymalne punkty zycia
protected int hpAkt; // aktualne punkty zycia

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
