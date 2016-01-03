import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class customBackground extends JPanel {
	BufferedImage background;

	customBackground(String x) {
		try {
			background = ImageIO.read(this.getClass().getResourceAsStream(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.drawImage(background,0,0,this.getWidth(),this.getHeight(),null);
		Component[]c = this.getComponents();
		for (int i = 0; i < c.length; i++) {
			c[i].repaint();
		}
	}
}
