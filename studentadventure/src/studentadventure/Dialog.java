package studentadventure;

public class Dialog {
	
	String slowo;
	String znaczenie;
	
	public Dialog(String s, String z) {
		slowo=s;
		znaczenie=z;
	}
	
	public String getSlowo() {
		return slowo;
	}

	public void setSlowo(String slowo) {
		this.slowo = slowo;
	}

	public String getZnaczenie() {
		return znaczenie;
	}

	public void setZnaczenie(String znaczenie) {
		this.znaczenie = znaczenie;
	}

	public enum Type {
	POWITANIE,
	POZEGNANIE,
	ODPOWIEDZ,
	ZADANIE,
	BRAK
	}
	
}
