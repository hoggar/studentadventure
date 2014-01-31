package studentadventure;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class MapaPanel extends JPanel {
	private static final int MAP_SIZE = 10;
	private static final int TILE_SIZE = 30;

	public MapaPanel() {
		System.out.println("bu2");
		repaint();

	}

	public void paint(Graphics g) {
		// super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		if (Start.czy_walka == false) {

			// Rysowanie mapy
			for (int y = 0; y < MAP_SIZE; y++) {
				for (int x = 0; x < MAP_SIZE; x++) {
					g2d.drawImage(Start.mapa[x][y].getTloKafelka(), x
							* TILE_SIZE, y * TILE_SIZE, this);

				}
			}

			// Rysowanie przeciwnika
			if (Start.przeciwnik != null)
				g2d.drawImage(Start.przeciwnik.getObrazekPostaci(),
						Start.przeciwnik.getX() * TILE_SIZE,
						Start.przeciwnik.getY() * TILE_SIZE, this);

			for (Przedmiot aktPrzedmiot : Start.przedmiotyNaMapie) {
				g2d.drawImage(aktPrzedmiot.grafikaPrzedmiotu,
						aktPrzedmiot.getX() * TILE_SIZE, aktPrzedmiot.getY()
								* TILE_SIZE, this);
			}

			// Rysowanie bohatera
			g2d.drawImage(Start.bohater.getObrazekPostaci(),
					Start.bohater.getX() * TILE_SIZE, Start.bohater.getY()
							* TILE_SIZE, this);
		} else {
			System.out.println("rysuje");

			Image heroImage = null;
			Image monsterImage = null;
			Image fight = null;
			g2d.clearRect(0, 0, 300, 300);

			Font hpFont = new Font("Verdana", Font.PLAIN, 15);
			g2d.setFont(hpFont);
			heroImage = Start.bohater.fightImage;
			monsterImage = Start.przeciwnik.getFightImage();
			g2d.drawImage(heroImage, 15, 55, this);
			g2d.drawImage(monsterImage, 200, 100, this);
			// g2d.drawImage(fight, 100, 130, this);

			String herohp = "HP: " + Start.bohater.getHpAkt() + "/"
					+ Start.bohater.getHpMAX();
			String monsterhp = "HP: " + Start.przeciwnik.getHpAkt() + "/"
					+ Start.przeciwnik.getHpMAX();

			g2d.drawString(herohp, 10, 40);
			g2d.drawString(monsterhp, 200, 80);
		}
	}
}
