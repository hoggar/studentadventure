package studentadventure;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Tile {
	private int x,y;
	private String opis;
	private boolean czyMoznaPoTymChodzic;
	private Image tloKafelka;
	private List<Postac> pobliskieNPC;
	private List<WorldDirections> mozliweKierunki;
	
	public Tile() {
		pobliskieNPC = new ArrayList<Postac>();
		setMozliweKierunki(new ArrayList<WorldDirections>());
	}
	
	public Tile(int numerKafelka, int _x, int _y) throws IOException {
		String _opis = "BRAK";
		boolean cMC = false;
		File _tlo = null;
		Image _tloImage = null;
		
		System.out.println(numerKafelka);
		switch (numerKafelka) {
		case 1:
			_opis = "Znajdujesz się na auli przy oknie, trochę dziwne miejsce na oglądanie widoków.";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/podloga_aula_okno.jpg");
			break;
		case 2:
			_opis = "Stoisz niedaleko tablicy, rzadko można w tym miejscu zobaczyć studenta";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/podloga_aula_podtablica.jpg");
			break;
		case 3:
			_opis = "Jesteś pod tablicą, chcesz coś napisać?";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/podloga_aula_tablica.jpg");
			break;
		case 4:
			_opis = "Znajduje się tam profesor";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/podloga_aula_profesor.jpg");
			break;
		case 5:
			_opis = "Dużo siedzeń jest wolnych, możesz wybierać";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/siedzenia_aula.jpg");
			break;
		case 6:
			_opis = "Po auli możesz chodzić";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/podloga_aula.jpg");
			break;
		case 7:
			_opis = "Tutaj kończy się aula";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/sciana_aula_korytarz_bok.jpg");
			break;
		case 8:
			_opis = "Tutaj kończy się aula";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/sciana_aula_korytarz_dol.jpg");
			break;
		case 9:
			_opis = "Przez drzwi możesz wyjść lub wejść do auli";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/drzwi_aula_korytarz.jpg");
			break;
		case 10:
			_opis = "Tutaj kończy się aula";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/rog_korytarz_aula.jpg");
			break;
		case 11:
			_opis = "Znajdujesz się na korytarzu, stąd dojdziesz na aule jak i do dziekanatu.";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/podloga_korytarz.jpg");
			break;
		case 12:
			_opis = "Choinka, bo święta.";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/choinka.jpg");
			break;
		case 13:
			_opis = "Schody są w remoncie, nie można na nie wchodzić";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/schody_lewe.jpg");
			break;
		case 14:
			_opis = "Schody są w remoncie, nie można na nie wchodzić";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/schody_prawe.jpg");
			break;
		case 15:
			_opis = "Tu jest róg dziekanatu.";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/rog_dziekanat_korytarz.jpg");
			break;
		case 16:
			_opis = "Tam jest ściana.";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/sciana_dziekanat_korytarz.jpg");
			break;
		case 17:
			_opis = "Dziekanat, tu mogą Cię spotkać same nieszczęścia.";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/podloga_dziekanat.jpg");
			break;
		case 18:
			_opis = "Tam siedzi pani, pani z dziekanatu.";
			cMC=false;
			_tlo = new File("./images/kafelki/dziekanat/pani_z_dziekanatu.jpg");
			break;
		case 19:
			_opis = "Tędy możesz szybko z dziekanatu uciec.";
			cMC=true;
			_tlo = new File("./images/kafelki/dziekanat/drzwi_dziekanat.jpg");
			break;
		}
		System.out.println(numerKafelka);
		_tloImage = ImageIO.read(_tlo);
		setTloKafelka(_tloImage);
		setOpis(_opis);
		setCzyMoznaPoTymChodzic(cMC);
		setX(_x);
		setY(_y);
	}
	
	public Image getTloKafelka() {
		return tloKafelka;
	}

	public void setTloKafelka(Image tloKafelka) {
		this.tloKafelka = tloKafelka;
	}

	public Tile(int _x, int _y, String _opis, boolean move) {
		setX(_x);
		setY(_y);
		setOpis(_opis);
		setCzyMoznaPoTymChodzic(move);
		pobliskieNPC = new ArrayList<Postac>();
		setMozliweKierunki(new ArrayList<WorldDirections>());
	}
	
	public boolean dodajNPC(String nazwa, String about) {
		NPC nowy = new NPC();
		nowy.setNazwa(nazwa);
		nowy.setOpis(about);
		pobliskieNPC.add(nowy);
		return true;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public boolean isCzyMoznaPoTymChodzic() {
		return czyMoznaPoTymChodzic;
	}
	public void setCzyMoznaPoTymChodzic(boolean czyMoznaPoTymChodzic) {
		this.czyMoznaPoTymChodzic = czyMoznaPoTymChodzic;
	}
	public List<Postac> getPobliskieNPC() {
		return pobliskieNPC;
	}
	public void setPobliskieNPC(List<Postac> pobliskieNPC) {
		this.pobliskieNPC = pobliskieNPC;
	}

	public List<WorldDirections> getMozliweKierunki() {
		return mozliweKierunki;
	}

	public void setMozliweKierunki(List<WorldDirections> mozliweKierunki) {
		this.mozliweKierunki = mozliweKierunki;
	} 
}
