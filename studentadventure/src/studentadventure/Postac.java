package studentadventure;

public abstract class Postac {
private String description; //opis postaci
private String name; // nazwa
private int hp; // punkty zycia

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

}
