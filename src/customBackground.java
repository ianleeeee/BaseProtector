import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class customBackground extends JPanel {
	BufferedImage background;
	BufferedImage arrowImage;
	ArrayList<arrow> arrowList;
	customBackground(String x) {
		arrowList = new ArrayList<arrow>();
		try {
			background = ImageIO.read(this.getClass().getResourceAsStream(x));
			arrowImage = ImageIO.read(this.getClass().getResourceAsStream("arrowImage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);

		for(arrow a:arrowList){
			a.draw(g);
		}
		
	}
	void addArrow(int x, int y){
		arrowList.add(new arrow(198,60,100,100,10,10,x,y,arrowImage));
		repaint();
	}
	void updateArrows(){
		for(arrow a:arrowList){
			a.update();
		}
	}
}
