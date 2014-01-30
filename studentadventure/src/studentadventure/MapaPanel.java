package studentadventure;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MapaPanel extends JPanel {
	private static final int MAP_SIZE = 10;
	private static final int TILE_SIZE = 30;

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// Rysowanie mapy
		for (int y = 0; y < MAP_SIZE; y++) {
			for (int x = 0; x < MAP_SIZE; x++) {
				g2d.drawImage(Start.mapa[x][y].getTloKafelka(), x * TILE_SIZE,
						y * TILE_SIZE, this);

			}
		}

		// Rysowanie przeciwnika
		if (Start.przeciwnik != null)
			g2d.drawImage(Start.przeciwnik.getObrazekPostaci(),
					Start.przeciwnik.getX() * TILE_SIZE,
					Start.przeciwnik.getY() * TILE_SIZE, this);

		for (Przedmiot aktPrzedmiot : Start.przedmiotyNaMapie) {
			g2d.drawImage(aktPrzedmiot.grafikaPrzedmiotu, aktPrzedmiot.getX()
					* TILE_SIZE, aktPrzedmiot.getY() * TILE_SIZE, this);
		}

		// Rysowanie bohatera
		g2d.drawImage(Start.bohater.getObrazekPostaci(), Start.bohater.getX()
				* TILE_SIZE, Start.bohater.getY() * TILE_SIZE, this);
	}
}
