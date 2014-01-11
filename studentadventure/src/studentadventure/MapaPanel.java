package studentadventure;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MapaPanel extends JPanel {
	private static final int MAP_SIZE = 10;
	private static final int TILE_SIZE = 30;
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		for(int y=0; y<MAP_SIZE; y++) {
			for(int x=0; x<MAP_SIZE; x++) {
				g2d.drawImage(Start.mapa[x][y].getTloKafelka(), x*TILE_SIZE, y*TILE_SIZE, this);
			}
		}
		Font heroFont = new Font("Verdana", Font.PLAIN, 20);
		g2d.setFont(heroFont);
		//g2d.drawString("B", Start.bohater.getX()*TILE_SIZE+TILE_SIZE, Start.bohater.getY()*TILE_SIZE+TILE_SIZE);
	}
}
