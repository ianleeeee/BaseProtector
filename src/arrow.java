import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

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
	Rectangle collisionBoxArrow;
	int CBAwidth = 75;
	int CBAheight = 40;
	int CBAx = x + 25;
	int CBAy = y + 25;

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
		angle = (float) Math.atan((double)xDif/yDif);
		hypot = (float) Math.sqrt((xDif) + (yDif));

		System.out.println(xDif);
		System.out.println(yDif);
		collisionBoxArrow = new Rectangle(CBAx, CBAy, CBAwidth, CBAheight);
	}

	void draw(Graphics g) {
		AffineTransform rotator = new AffineTransform();
		Graphics2D g2 = (Graphics2D)  g;
		rotator.rotate(-angle+(Math.PI/2),x,y);
		g2.setTransform(rotator);
		
		g2.drawImage(arrowImage, x, y, width, height, null);
		rotator.rotate(angle +(Math.PI/2), x,y);
		g2.setTransform(rotator);
		// g.drawRect(collisionBoxArrow.x, collisionBoxArrow.y,
		// collisionBoxArrow.width, collisionBoxArrow.height);
	}

	void update() {
		x += speed * Math.sin(angle);
		y += speed * Math.cos(angle);
		/// if (y > destinationY) {
		/// y += -3;
		// }
		// if (y < destinationY) {
		// y += 3;
		// }
		// x += speed;
		collisionBoxArrow.setBounds(CBAx, CBAy, CBAwidth, CBAheight);
		CBAx = x + 25;
		CBAy = y + 25;
	}

	Rectangle getBox() {
		return collisionBoxArrow;
	}
}
