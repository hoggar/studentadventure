package studentadventure;

public abstract class Postac {
private String description; //opis postaci
private String name; // nazwa
private int hp; // punkty zycia
private int exp; // punkty doswiadczenia
private int mvp; // punkty ruchu

public String toString() {
	return "<" + name + " , " + hp + " , " + mvp + " , " + exp + ">";
}
public int getHp() {
	return hp;
}
public void setHp(int hp) {
	this.hp = hp;
}
public int getExp() {
	return exp;
}
public void setExp(int exp) {
	this.exp = exp;
}
public int getMvp() {
	return mvp;
}
public void setMvp(int mvp) {
	this.mvp = mvp;
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
