import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class customBackground extends JPanel {
	BufferedImage background;
	ArrayList<arrow> arrowList;
	customBackground(String x) {
		arrowList = new ArrayList<arrow>();
		try {
			background = ImageIO.read(this.getClass().getResourceAsStream(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
		Component[] c = this.getComponents();
		for (int i = 0; i < c.length; i++) {
			c[i].repaint();
		}
		for(arrow a:arrowList){
			a.draw(g);
		}
		
	}
	void addArrow(){
		arrowList.add(new arrow(198,60,100,100,10,10));
		repaint();
	}
	void updateArrows(){
		for(arrow a:arrowList){
			a.update();
		}
	}
}
