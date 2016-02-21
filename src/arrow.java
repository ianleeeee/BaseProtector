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
	int destinationX;
	int destinationY;
	float angle;
	float hypot;
	int xDif;
	int yDif;
	BufferedImage arrowImage;

	arrow(int x, int y, int width, int height, int speed, int damage, int destinationX, int destinationY,
			BufferedImage a) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.damage = damage;
		this.destinationY = destinationY;
		this.destinationX = destinationX;
		xDif = destinationX - x;
		yDif = destinationY - y;
		this.arrowImage = a;
		angle = (float) Math.atan(yDif / xDif);
		hypot = (float) Math.sqrt((xDif * xDif) + (yDif * yDif));

		System.out.println(xDif);
		System.out.println(yDif);

	}

	void draw(Graphics g) {

		g.drawImage(arrowImage, x, y, width, height, null);
	}

	void update() {
		//x += speed * Math.cos(xDif / hypot);
		//y += speed * Math.sin(yDif / hypot);
		if (y>destinationY) {
			y+=-3;
		}
		if(y<destinationY){
			y+=3;
		}
		x+=speed;
	}
}
