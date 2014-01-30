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
			this.cel = "Odpowiedz poprawnie na zagadke pani z dziekanatu. \nZagadka brzmi: 'Co chodzi na czterech nogach gdy jest mÅ‚odÄ™, "
					+ "gdy bÄ™dzie starsze na dwÃ³ch, \na gdy jeszcze starsze na trzech?'";
			this.czyZagadka = true;
			this.dobraOdp.add("czlowiek");
			this.dobraOdp.add("cz³owiek");
			this.nagroda = new Przedmiot();
			nagroda.setnazwa("Urlop Dziekañski");
			nagroda.setopis("To jest zaœwiadczenie o przyznanym urlopie dziekañskim. Mo¿na iœæ do domu.");
			break;
		case 2:
			this.nazwa = "Budowa wehiku³u";
			this.cel = "Zbierz wszystkie potrzebne czêœci do wehiku³u czasu. Gdy je zdobêdziesz podejdŸ do sto³u, usi¹dŸ i zbuduj wehiku³.";
			this.czyZagadka = false;
			break;
		case 3:
			this.nazwa = "Zabij gryzonia";
			this.cel = "Karczmarka poprosi³a ciê o unicestwienie szczura. Zrób to szybko.";
			this.czyZagadka = false;
			this.nagroda = new Przedmiot();
			nagroda.setnazwa("Drut");
			nagroda.setopis("To jest metalowy drut. Prawdopodbnie stalowy. Powinien wystarczyæ do naprawy wehiku³u.");
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
