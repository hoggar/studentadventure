package studentadventure;

public class Pokazywanie {
	private String nazwa;
	private String znaczenie;
	
	public Pokazywanie (String n, String z) {
		nazwa=n;
		znaczenie=z;
	}
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getZnaczenie() {
		return znaczenie;
	}

	public void setZnaczenie(String znaczenie) {
		this.znaczenie = znaczenie;
	}


	
	public enum Type {
	QUESTY,
	PRZEDMIOTY,
	BRAK
	}
}
