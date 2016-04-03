import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class enemy {
	int x;
	int y;
	int height;
	int width;
	float speed;
	Rectangle collisionBox;
	BufferedImage enemy;
	int CBwidth = 90;
	int CBheight = 125;
	int CBx = x + 100;
	int CBy = y + 100;

	enemy(int x, int y, int width, int height, float speed, BufferedImage enemy) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.enemy = enemy;
		this.speed = speed;
		collisionBox = new Rectangle(CBx, CBy, CBwidth, CBheight);
	}

	public void paint(Graphics g) {
		g.drawImage(enemy, x, y, width, height, null);
		g.setColor(Color.red);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}

	public void update() {
		collisionBox.setBounds(CBx, CBy, CBwidth, CBheight);
		CBx = x + 110;
		CBy = y + 75;

		x -= speed;

	}

	Rectangle getBox() {
		return collisionBox;
	}
}
