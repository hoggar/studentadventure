package studentadventure;

public abstract class Postac {
private String description; //opis postaci
private String name; // nazwa
private int hpMAX; // maksymalne punkty zycia
private int hp; // aktualne punkty zycia

public String toString() {
	return "<" + name + " , " + hp + ">";
}
public int getHp() {
	return hp;
}
public void setHp(int hp) {
	this.hp = hp;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String about() {
	return name + " to " + description; 
}
public int getHpMAX() {
	return hpMAX;
}
public void setHpMAX(int hpMAX) {
	this.hpMAX = hpMAX;
}

}
