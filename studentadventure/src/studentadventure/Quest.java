package studentadventure;

import java.util.LinkedList;
import java.util.List;

public class Quest {
	private String nazwa;
	private String cel;
	private boolean czyZagadka;
	private List<String> dobraOdp;
	private Przedmiot nagroda;

	public Quest(int idQuesta) {
		dobraOdp = new LinkedList<String>();
		switch (idQuesta) {
		case 1:
			this.nazwa = "Zagadka pani z dziekanatu";
			this.cel = "Odpowiedz poprawnie na zagadke pani z dziekanatu. \nZagadka brzmi: 'Co chodzi na czterech nogach gdy jest młodę, "
					+ "gdy będzie starsze na dwóch, \na gdy jeszcze starsze na trzech?'";
			this.czyZagadka = true;
			this.dobraOdp.add("czlowiek");
			this.dobraOdp.add("cz�owiek");
			this.nagroda = new Przedmiot();
			nagroda.setnazwa("Urlop Dzieka�ski");
			nagroda.setopis("To jest za�wiadczenie o przyznanym urlopie dzieka�skim. Mo�na i�� do domu.");
			break;
		case 2:
			this.nazwa = "Budowa wehiku�u";
			this.cel = "Zbierz wszystkie potrzebne cz�ci do wehiku�u czasu. Gdy je zdob�dziesz podejd� do sto�u, usi�d� i zbuduj wehiku�.";
			this.czyZagadka = false;
			break;
		case 3:
			this.nazwa = "Zabij gryzonia";
			this.cel = "Karczmarka poprosi�a ci� o unicestwienie szczura. Zr�b to szybko.";
			this.czyZagadka = false;
			this.nagroda = new Przedmiot();
			nagroda.setnazwa("Drut");
			nagroda.setopis("To jest metalowy drut. Prawdopodbnie stalowy. Powinien wystarczy� do naprawy wehiku�u.");
			break;
		}
	}

	public Przedmiot getNagroda() {
		return nagroda;
	}

	public void setNagroda(Przedmiot nagroda) {
		this.nagroda = nagroda;
	}

	public boolean isCzyZagadka() {
		return czyZagadka;
	}

	public void setCzyZagadka(boolean czyZagadka) {
		this.czyZagadka = czyZagadka;
	}

	public List<String> getDobraOdp() {
		return dobraOdp;
	}

	public void setDobraOdp(List<String> dobraOdp) {
		this.dobraOdp = dobraOdp;
	}

	public boolean sprawdzOdpowiedz(String odpGracza) {
		boolean test = false;
		for (String actOdp : dobraOdp) {
			if (odpGracza.contains(actOdp)) {
				test = true;
				break;
			}
		}
		return test;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}
}
