import java.awt.Graphics;

public class towerSTUFF {

	int towerHP = 10;

	void draw(Graphics g) {
		g.drawString("  YOUR TOWER HEALTH IS:" + towerHP, 880, 10);

		// g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);

	}

	void update() {

	}
}
