import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class arrow {
	int x;
	int y;
	int width;
	int height;
	int speed;
	int damage;
	///int destinationX;
	///int destinationY;
	BufferedImage arrowImage;
	arrow(int x, int y, int width, int height, int speed, int damage) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.damage = damage;
		try {
			arrowImage = ImageIO.read(this.getClass().getResourceAsStream("arrowImage.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void draw(Graphics g){
	
		g.drawImage(arrowImage,x,y,width,height,null);
	}
	void update(){
		x++;
		y++;
	}
}
