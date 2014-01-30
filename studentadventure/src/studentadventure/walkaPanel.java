package studentadventure;



import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class walkaPanel extends JPanel {
        private static final int MAP_SIZE = 10;
        private static final int TILE_SIZE = 30;
        
        public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                
                Image heroImage = null;
                Image monsterImage = null;
                Image fight = null;
                
                Font hpFont = new Font("Verdana", Font.PLAIN, 15);
                g2d.setFont(hpFont);
                heroImage = Start.bohater.fightImage;
                monsterImage = Start.przeciwnik.getFightImage();
                g2d.drawImage(heroImage, 15, 55, this);
                g2d.drawImage(monsterImage, 200, 100, this);
                g2d.drawImage(fight, 100, 130, this);
                
                String herohp = "HP: "+Start.bohater.getHpAkt()+"/"+Start.bohater.getHpMAX();
                String monsterhp = "HP: "+Start.przeciwnik.getHpAkt()+"/"+Start.przeciwnik.getHpMAX();
                
                g2d.drawString(herohp, 10, 40);
                g2d.drawString(monsterhp, 200, 80);
        }
}