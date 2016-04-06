import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class customBackground extends JPanel {
	counters ian = new counters();

	BufferedImage background;
	BufferedImage arrowImage;
	CopyOnWriteArrayList<arrow> arrowList;
	CopyOnWriteArrayList<enemy> enemyList;
	BufferedImage enemyImage;

	long enemyTimer = -1;
	int levelTracker = 0;
	int ammo = 30;

	customBackground(String x) {

		arrowList = new CopyOnWriteArrayList<arrow>();
		enemyList = new CopyOnWriteArrayList<enemy>();
		try {
			background = ImageIO.read(this.getClass().getResourceAsStream(x));
			arrowImage = ImageIO.read(this.getClass().getResourceAsStream("arrowImage.png"));
			enemyImage = ImageIO.read(this.getClass().getResourceAsStream("axeEnemy.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);

		for (arrow a : arrowList) {
			a.draw(g);
		}
		for (enemy e : enemyList) {
			e.paint(g);

		}

		ian.draw(g);
	}

	void addArrow(int x, int y) {
		arrowList.add(new arrow(198, 60, 100, 100, 10, 10, x, y, arrowImage));
		repaint();
	}

	void updateArrows() {
		for (arrow a : arrowList) {
			a.update();
			checkCollision();

		}

	}

	void update() {
		for (enemy e : enemyList) {
			e.update();
			checkCollision();
		}
	}

	void addEnemy() {
		if (enemyTimer == -1) {
			enemyTimer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - enemyTimer >= 1500) {
			enemyList.add(new enemy(1329, 300, 200, 200, 1, enemyImage));
			enemyTimer = -1;
		}
	}

	void checkCollision() {
		for (enemy e : enemyList) {
			for (arrow a : arrowList) {
				if (e.getBox().intersects(a.getBox())) {
					System.out.println("collision");
					enemyList.remove(e);
					arrowList.remove(a);
					levelTracker += 1;
					ian.ammo--;
					if (ammo == 0) {
						JOptionPane.showMessageDialog(null, "GAME OVER");
					} else {

					}
					if (levelTracker == 20 && ammo >= 1) {
						JOptionPane.showMessageDialog(null, "Level 2!");
						ammo = 60;
					} else {

					}
					if (levelTracker == 60 && ammo >= 1) {
						JOptionPane.showMessageDialog(null, "Level 3!");
					} else {

					}
				}
			}
		}
	}
}
