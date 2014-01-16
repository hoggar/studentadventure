package studentadventure;

public class Quest {
	private String nazwa;
	private String cel;
	private boolean czyZagadka;
	private String dobraOdp;
	private Przedmiot nagroda;
	
	public Quest(int idQuesta) {
		switch(idQuesta) {
		case 1:
			this.nazwa="Zagadka pani z dziekanatu";
			this.cel="Odpowiedz poprawnie na zagadke pani z dziekanatu. \nZagadka brzmi: 'Co chodzi na czterech nogach gdy jest młodę, "
					+ "gdy będzie starsze na dwóch, \na gdy jeszcze starsze na trzech?'";
			this.czyZagadka=true;
			this.dobraOdp="czlowiek";
			this.nagroda = new Przedmiot();
			nagroda.setnazwa("Urlop Dziekański");
			nagroda.setopis("To jest zaświadczenie o przyznanym urlopie dziekańskim. Można iść do domu.");
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
	public String getDobraOdp() {
		return dobraOdp;
	}
	public void setDobraOdp(String dobraOdp) {
		this.dobraOdp = dobraOdp;
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
