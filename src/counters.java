import java.awt.Graphics;

public class counters {
	int ammo = 20;

	void draw(Graphics g) {
		g.drawString("YOUR AMMO IS" +ammo, 10, 10);
	}

	void update() {

	}
}
