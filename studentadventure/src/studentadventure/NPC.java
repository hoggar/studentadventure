package studentadventure;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NPC extends Postac {
	private String opis; //opis NPC
	private String nazwaXML;
	private static List<String> kwestieBrakuZrozumienia;  

	public NPC(int id) {
		if(kwestieBrakuZrozumienia == null) {
			kwestieBrakuZrozumienia = new LinkedList<String>();
			kwestieBrakuZrozumienia.add("Nie rozumiem co Pan mówi");
			kwestieBrakuZrozumienia.add("¯e co proszê?");
			kwestieBrakuZrozumienia.add("Nie wiem czy dobrze rozumiem. Mo¿e Pan powtórzyæ?");
			kwestieBrakuZrozumienia.add("Proszê mówiæ po ludzku!");
			kwestieBrakuZrozumienia.add("Proszê?");
			kwestieBrakuZrozumienia.add("Co?");
			kwestieBrakuZrozumienia.add("Nie rozumiem");
		}
		
		walecznosc=false;
		switch (id) {
		case 1:
			this.nazwa="Pani z dziekanatu";
			this.opis="Pani z dziekanatu. Moge wziÄ…Ä‡ od niej urlop";
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
	
	public String dajNiezrozumienie() {
		int rozmiarList = kwestieBrakuZrozumienia.size();
		Random losowacz = new Random();
		String kwestia = kwestieBrakuZrozumienia.get(losowacz.nextInt(rozmiarList));
		return kwestia;
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
		return "DzieÅ„ dobry!";
	}
}
