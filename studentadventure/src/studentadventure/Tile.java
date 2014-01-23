package studentadventure;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Tile {
	private int x, y;
	private String opis;
	private boolean czyMoznaPoTymChodzic;
	private Image tloKafelka;

	public Tile() {

	}

	public Tile(int numerKafelka, int _x, int _y) throws IOException {
		String _opis = "BRAK";
		boolean cMC = false;
		File _tlo = null;
		Image _tloImage = null;

		if (Start.numerPoziomu == 1) {
			System.out.println(numerKafelka);
			switch (numerKafelka) {
			case 1:
				_opis = "Znajdujesz się na auli przy oknie, trochę dziwne miejsce na oglądanie widoków.";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_okno.jpg");
				break;
			case 2:
				_opis = "Stoisz niedaleko tablicy, rzadko można w tym miejscu zobaczyć studenta";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_podtablica.jpg");
				break;
			case 3:
				_opis = "Jesteś pod tablicą, chcesz coś napisać?";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_tablica.jpg");
				break;
			case 4:
				_opis = "Znajduje się tam profesor";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_profesor.jpg");
				break;
			case 5:
				_opis = "Dużo siedzeń jest wolnych, możesz wybierać";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/siedzenia_aula.jpg");
				break;
			case 6:
				_opis = "Po auli możesz chodzić";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula.jpg");
				break;
			case 7:
				_opis = "Tutaj kończy się aula";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/sciana_aula_korytarz_bok.jpg");
				break;
			case 8:
				_opis = "Tutaj kończy się aula";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/sciana_aula_korytarz_dol.jpg");
				break;
			case 9:
				_opis = "Przez drzwi możesz wyjść lub wejść do auli";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/drzwi_aula_korytarz.jpg");
				break;
			case 10:
				_opis = "Tutaj kończy się aula";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/rog_korytarz_aula.jpg");
				break;
			case 11:
				_opis = "Znajdujesz się na korytarzu, stąd dojdziesz na aule jak i do dziekanatu.";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_korytarz.jpg");
				break;
			case 12:
				_opis = "Choinka, bo święta.";
				cMC = false;
				_tlo = new File("./files/images/kafelki/dziekanat/choinka.jpg");
				break;
			case 13:
				_opis = "Schody są w remoncie, nie można na nie wchodzić";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/schody_lewe.jpg");
				break;
			case 14:
				_opis = "Schody są w remoncie, nie można na nie wchodzić";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/schody_prawe.jpg");
				break;
			case 15:
				_opis = "Tu jest róg dziekanatu.";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/rog_dziekanat_korytarz.jpg");
				break;
			case 16:
				_opis = "Tam jest ściana.";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/sciana_dziekanat_korytarz.jpg");
				break;
			case 17:
				_opis = "Dziekanat, tu mogą Cię spotkać same nieszczęścia.";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_dziekanat.jpg");
				break;
			case 18:
				_opis = "Tam siedzi pani, pani z dziekanatu.";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/pani_z_dziekanatu.jpg");
				break;
			case 19:
				_opis = "Tędy możesz szybko z dziekanatu uciec.";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/drzwi_dziekanat.jpg");
				break;
			}
		} else if (Start.numerPoziomu == 2) {
			switch (numerKafelka) {
			case 1:
				_opis = "Tu ro�nie trawa przed twoim domem. Bawi�e� si� tutaj zanim dosta�e� pierwszy komputer!";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/trawa.jpg");
				break;
			case 2:
				_opis = "Podjazd do garazu";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/podjazd.jpg");
				break;
			case 3:
				_opis = "Tutaj s� krzaki";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/krzak.jpg");
				break;
			case 4:
				_opis = "�ciana odgradzaj�ca Ciebie od tego pe�nego zieleni i �wiat�a �wiata ";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/sciana.jpg");
				break;
			case 5:
				_opis = "Znajduj� si� tutaj drzwi od gara�u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_gora_lewe.jpg");
				break;
			case 6:
				_opis = "Znajduj� si� tutaj drzwi od gara�u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_dol_lewe.jpg");
				break;
			case 7:
				_opis = "Znajduj� si� tutaj drzwi od gara�u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_dol_prawe.jpg");
				break;
			case 8:
				_opis = "Co� kolorowego tam jest, musia�bym si� bli�ej przyjrze� by wiedzie� co to";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/kulki.jpg");
				break;
			case 9:
				_opis = "Po pod�odze mo�na chodzi�";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/podloga.jpg");
				break;
			case 10:
				_opis = "Znajduj� si� tutaj drzwi od gara�u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_gora_prawe.jpg");
				break;
			case 11:
				_opis = "W szafkach mo�na znale�� przer�ne ciekawe przedmioty";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/szafka_lewy_bok.jpg");
				break;
			case 12:
				_opis = "Biurko";
				cMC = false;
				_tlo = new File("./files/images/kafelki/garaz/biurko_lewe.jpg");
				break;
			case 13:
				_opis = "Biurko";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/biurko_prawe.jpg");
				break;
			case 14:
				_opis = "Na krze�le mo�esz sobie odpocz��";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/krzeslo.jpg");
				break;
			case 15:
				_opis = "C� to mo�e by�? Musia� bym si� lepiej przyjrze�";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/cos2.jpg");
				break;
			case 16:
				_opis = "Du�o w tym gara�u mam pude�. Nawet nie wiem co w kt�rym jest";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/pudelko.jpg");
				break;
			case 17:
				_opis = "Jaka� spre�yna tam chyba le�y";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/sprezyna.jpg");
				break;
			case 18:
				_opis = "Tam s� narz�dzia, nie bierz ich bez zgody ojca";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/narzedzia.jpg");
				break;
			case 19:
				_opis = "Co� tam cobie le�y";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/cos.jpg");
				break;
			case 20:
				_opis = "W szafkach mo�na znale�� du�o r�nych ciekawych, rzeczy";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/szafka_prawy_bok.jpg");
				break;
			}

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
}
