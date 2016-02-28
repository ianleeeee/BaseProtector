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

	enemy(int x, int y, int width, int height, float speed, BufferedImage enemy) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.enemy = enemy;
		this.speed = speed;
		collisionBox = new Rectangle(x, y, width, height);
	}

	public void paint(Graphics g) {
		g.drawImage(enemy, x, y, width, height, null);
	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);
		x -= speed;
		
	}
}
