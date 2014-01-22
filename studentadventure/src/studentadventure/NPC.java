package studentadventure;

public class NPC extends Postac {
	private String opis; //opis NPC
	private String nazwaXML;

	public NPC(int id) {
		walecznosc=false;
		switch (id) {
		case 1:
			this.nazwa="Pani z dziekanatu";
			this.opis="Pani z dziekanatu. Moge wziąć od niej urlop";
			this.x=1;
			this.y=9;
			this.nazwaXML="dziekanat";
			break;
		default:
			System.err.println("BRAK NPC");
			System.exit(0);
			break;
		}
	}
	
	public String getNazwaXML() {
		return nazwaXML;
	}

	public void setNazwaXML(String nazwaXML) {
		this.nazwaXML = nazwaXML;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public String powitanie() {
		return "Dzień dobry!";
	}
}
