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
				_opis = "Znajdujesz siÄ™ na auli przy oknie, trochÄ™ dziwne miejsce na oglÄ…danie widokÃ³w.";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_okno.jpg");
				break;
			case 2:
				_opis = "Stoisz niedaleko tablicy, rzadko moÅ¼na w tym miejscu zobaczyÄ‡ studenta";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_podtablica.jpg");
				break;
			case 3:
				_opis = "JesteÅ› pod tablicÄ…, chcesz coÅ› napisaÄ‡?";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_tablica.jpg");
				break;
			case 4:
				_opis = "Znajduje siÄ™ tam profesor";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula_profesor.jpg");
				break;
			case 5:
				_opis = "DuÅ¼o siedzeÅ„ jest wolnych, moÅ¼esz wybieraÄ‡";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/siedzenia_aula.jpg");
				break;
			case 6:
				_opis = "Po auli moÅ¼esz chodziÄ‡";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_aula.jpg");
				break;
			case 7:
				_opis = "Tutaj koÅ„czy siÄ™ aula";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/sciana_aula_korytarz_bok.jpg");
				break;
			case 8:
				_opis = "Tutaj koÅ„czy siÄ™ aula";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/sciana_aula_korytarz_dol.jpg");
				break;
			case 9:
				_opis = "Przez drzwi moÅ¼esz wyjÅ›Ä‡ lub wejÅ›Ä‡ do auli";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/drzwi_aula_korytarz.jpg");
				break;
			case 10:
				_opis = "Tutaj koÅ„czy siÄ™ aula";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/rog_korytarz_aula.jpg");
				break;
			case 11:
				_opis = "Znajdujesz siÄ™ na korytarzu, stÄ…d dojdziesz na aule jak i do dziekanatu.";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/podloga_korytarz.jpg");
				break;
			case 12:
				_opis = "Choinka, bo Å›wiÄ™ta.";
				cMC = false;
				_tlo = new File("./files/images/kafelki/dziekanat/choinka.jpg");
				break;
			case 13:
				_opis = "Schody sÄ… w remoncie, nie moÅ¼na na nie wchodziÄ‡";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/schody_lewe.jpg");
				break;
			case 14:
				_opis = "Schody sÄ… w remoncie, nie moÅ¼na na nie wchodziÄ‡";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/schody_prawe.jpg");
				break;
			case 15:
				_opis = "Tu jest rÃ³g dziekanatu.";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/rog_dziekanat_korytarz.jpg");
				break;
			case 16:
				_opis = "Tam jest Å›ciana.";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/sciana_dziekanat_korytarz.jpg");
				break;
			case 17:
				_opis = "Dziekanat, tu mogÄ… CiÄ™ spotkaÄ‡ same nieszczÄ™Å›cia.";
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
				_opis = "TÄ™dy moÅ¼esz szybko z dziekanatu uciec.";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/dziekanat/drzwi_dziekanat.jpg");
				break;
			}
		} else if (Start.numerPoziomu == 2) {
			switch (numerKafelka) {
			case 1:
				_opis = "Tu roœnie trawa przed twoim domem. Bawi³eœ siê tutaj zanim dosta³eœ pierwszy komputer!";
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
				_opis = "Tutaj s¹ krzaki";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/krzak.jpg");
				break;
			case 4:
				_opis = "Œciana odgradzaj¹ca Ciebie od tego pe³nego zieleni i œwiat³a œwiata ";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/sciana.jpg");
				break;
			case 5:
				_opis = "Znajduj¹ siê tutaj drzwi od gara¿u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_gora_lewe.jpg");
				break;
			case 6:
				_opis = "Znajduj¹ siê tutaj drzwi od gara¿u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_dol_lewe.jpg");
				break;
			case 7:
				_opis = "Znajduj¹ siê tutaj drzwi od gara¿u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_dol_prawe.jpg");
				break;
			case 8:
				_opis = "Coœ kolorowego tam jest, musia³bym siê bli¿ej przyjrzeæ by wiedzieæ co to";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/podloga.jpg");
				break;
			case 9:
				_opis = "Po pod³odze mo¿na chodziæ";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/podloga.jpg");
				break;
			case 10:
				_opis = "Znajduj¹ siê tutaj drzwi od gara¿u";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/drzwi_gora_prawe.jpg");
				break;
			case 11:
				_opis = "W szafkach mo¿na znale¿æ przeró¿ne ciekawe przedmioty";
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
				_opis = "Na krzeœle mo¿esz sobie odpocz¹æ";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/krzeslo.jpg");
				break;
			case 15:
				_opis = "Có¿ to mo¿e byæ? Musia³ bym siê lepiej przyjrzeæ";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/podloga.jpg");
				break;
			case 16:
				_opis = "Du¿o w tym gara¿u mam pude³. Nawet nie wiem co w którym jest";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/pudelko.jpg");
				break;
			case 17:
				_opis = "Jakaœ spre¿yna tam chyba le¿y";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/podloga.jpg");
				break;
			case 18:
				_opis = "Tam s¹ narzêdzia, nie bierz ich bez zgody ojca";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/podloga.jpg");
				break;
			case 19:
				_opis = "Coœ tam cobie le¿y";
				cMC = true;
				_tlo = new File(
						"./files/images/kafelki/garaz/cos.jpg");
				break;
			case 20:
				_opis = "W szafkach mo¿na znaleŸæ du¿o ró¿nych ciekawych, rzeczy";
				cMC = false;
				_tlo = new File(
						"./files/images/kafelki/garaz/szafka_prawy_bok.jpg");
				break;
			} }
			else if (Start.numerPoziomu == 3) {
				switch (numerKafelka) {
				case 1:
					_opis = "Œciana";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/sciana_prawa.jpg");
					break;
				case 2:
					_opis = "Bia³y, no prawie bia³y œnieg";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/snieg.jpg");
					break;
				case 3:
					_opis = "Scie¿k¹ dojdziesz do karczmy";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/sciezka1.jpg");
					break;
				case 4:
					_opis = "Œcie¿k¹ dojdziesz do karczmy ";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/sciezka2.jpg");
					break;
				case 5:
					_opis = "Œcie¿k¹ dojdziesz do karczmy";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/sciezka3.jpg");
					break;
				case 6:
					_opis = "Œciana";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/rog_prawy.jpg");
					break;
				case 7:
					_opis = "Œciana";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/rog_lewy.jpg");
					break;
				case 8:
					_opis = "Œciana";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/sciana_gora.jpg");
					break;
				case 9:
					_opis = "Znajduj¹ siê tutaj drzwi do karczmy";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/drzwi.jpg");
					break;
				case 10:
					_opis = "Tu jest tylko podloga";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/podloga.jpg");
					break;
				case 11:
					_opis = "Puste krzes³o";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/krzeslo_n.jpg");
					break;
				case 12:
					_opis = "Puste krzes³o";
					cMC = true;
					_tlo = new File("./files/images/kafelki/karczma/krzeslo_w.jpg");
					break;
				case 13:
					_opis = "Puste krzes³o";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/krzeslo_e.jpg");
					break;
				case 14:
					_opis = "Puste krzeslo";
					cMC = true;
					_tlo = new File(
							"./files/images/kafelki/karczma/krzeslo_s.jpg");
					break;
				case 15:
					_opis = "Stolik";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/stolik.jpg");
					break;
				case 16:
					_opis = "Stoj¹ tu beczki z piwem, w koñcu to karczma";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/beczki.jpg");
					break;
				case 17:
					_opis = "Lada, w poblizu powinnien ktos byc";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/lada1.jpg");
					break;
				case 18:
					_opis = "Lada";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/lada2.jpg");
					break;
				case 19:
					_opis = "Lada";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/lada3.jpg");
					break;
				case 20:
					_opis = "Widzê chyba jak¹s tabliczkê.";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/tabliczka.jpg");
					break;
				case 21:
					_opis = "Siedzi tutaj karczmarka";
					cMC = false;
					_tlo = new File(
							"./files/images/kafelki/karczma/karczmarka.jpg");
					break;
				
				}
			}
				else if (Start.numerPoziomu == 4) {
					switch (numerKafelka) {
					case 1:
						_opis = "Jakaœ œcie¿ka";
						cMC = true;
						_tlo = new File(
								"./files/images/kafelki/laka/sciezka1.jpg");
						break;
					case 2:
						_opis = "Ciekawe dok¹d prowadzi ta œcie¿ka";
						cMC = true;
						_tlo = new File(
								"./files/images/kafelki/laka/sciezka2.jpg");
						break;
					case 3:
						_opis = "Œcie¿ka";
						cMC = true;
						_tlo = new File(
								"./files/images/kafelki/laka/sciezka3.jpg");
						break;
					case 4:
						_opis = "Œcie¿ka";
						cMC = true;
						_tlo = new File(
								"./files/images/kafelki/laka/sciazka4.jpg");
						break;
					case 5:
						_opis = "Tu jest drzewo, pod którym ktoœ siedzi";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/drzewo1.jpg");
						break;
					case 6:
						_opis = "Pod drzewem ktoœ siedzi";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/drzewo2.jpg");
						break;
					case 7:
						_opis = "Drzewo";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/drzewo3.jpg");
						break;
					case 8:
						_opis = "Znajduje siê tutaj drzewo, pod nim ktoœ siedzi";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/drzewo4.jpg");
						break;
					case 9:
						_opis = "£¹ka, wszêdzie trawa!";
						cMC = true;
						_tlo = new File(
								"./files/images/kafelki/laka/trawa.jpg");
						break;
					case 10:
						_opis = "Jezioro";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/j5.jpg");
						break;
					case 11:
						_opis = "Jezioro";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/j1.jpg");
						break;
					case 12:
						_opis = "B³êkitne jezioro";
						cMC = false;
						_tlo = new File("./files/images/kafelki/laka/j3.jpg");
						break;
					case 13:
						_opis = "Jeziorko";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/j4.jpg");
						break;
					case 14:
						_opis = "Jezioro";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/j2.jpg");
						break;
					case 15:
						_opis = "Krzaki";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/krzak.jpg");
						break;
					case 16:
						_opis = "Du¿y kamieñ";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/kamien.jpg");
						break;
					case 17:
						_opis = "Tam ktoœ siedzi";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/postac.jpg");
						break;
					case 18:
						_opis = "Le¿¹ tutaj chyba notatki tego pana";
						cMC = false;
						_tlo = new File(
								"./files/images/kafelki/laka/notatki.jpg");
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
