package studentadventure;

public class NPC extends Postac {
	private String opis; //opis NPC

	public NPC(int id) {
		walecznosc=false;
		switch (id) {
		case 1:
			this.opis="Pani z dziekanatu. Moge wziąć od niej urlop";
			this.x=1;
			this.y=9;
			this.nazwa="dziekanat";
			break;
		default:
			System.err.println("BRAK NPC");
			System.exit(0);
			break;
		}
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
