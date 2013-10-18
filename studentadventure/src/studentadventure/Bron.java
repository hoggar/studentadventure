package studentadventure;

public abstract class Bron 
{
	private String name; // nazwa broni 
	private String description; //opis broni
	private int level; //poziom broni
	private int sila_ataku; // współczynnik modyfikujący atak bohatera
	private int sila_obrony; // współczynnik modyfikujący obronę bohatera
	
	public String toString() { return "Bron: " + name + "ma poziom: " + level; } 
	
	public void setName(String name) { this.name = name; } 
	public String getName() { return name; } 
	
	public void setDescription(String description) { this.description = description; } 
	public String getDescription() { return description; } 
	
	public String about() { return name + " to " + description; }
}
