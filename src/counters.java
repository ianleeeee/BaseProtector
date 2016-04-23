import java.awt.Graphics;

public class counters {
	int ammo = 30;
	int levelTracker = 0;

	void draw(Graphics g) {

		g.drawString("YOUR AMMO IS:" + ammo + "  ENEMIES ELIMINATED:" + levelTracker, 610, 10);

		// g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);

	}

	void update() {
		
	}
}
