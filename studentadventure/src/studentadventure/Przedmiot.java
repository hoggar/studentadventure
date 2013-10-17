package studentadventure;

public abstract class Przedmiot {
	private String name; // nazwa przedmiotu
	private String description; //opis przedmiotu
	private int level; //poziom przedmiotu
	
public String toString() {
	return "Przedmiot: " + name + "ma poziom:  " + level;
	}
public void setName(String name) {
	this.name = name;
	}
public String getName() {
	return name;
	}
public void setDescription(String description) {
	this.description = description;
	}
public String getDescription() {
	return description;
	}
public String about() {
	return name + " to " + description; 
	}

}