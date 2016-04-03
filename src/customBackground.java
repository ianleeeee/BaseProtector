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
	ArrayList<enemy> enemyList;
	BufferedImage enemyImage;
	long enemyTimer = -1;

	customBackground(String x) {
		arrowList = new ArrayList<arrow>();
		enemyList = new ArrayList<enemy>();
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
	}

	void addArrow(int x, int y) {
		arrowList.add(new arrow(198, 60, 100, 100, 10, 10, x, y, arrowImage));
		repaint();
	}

	void updateArrows() {
		for (arrow a : arrowList) {
			a.update();

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
		if (System.currentTimeMillis() - enemyTimer >= 2000) {
			enemyList.add(new enemy(1329, 300, 200, 200, 1, enemyImage));
			enemyTimer = -1;
		}
	}

	void checkCollision() {
		for (enemy e : enemyList) {
			for (arrow a : arrowList) {
				if (e.getBox().intersects(a.getBox())) {
					System.out.println("yolo");
				}
			}
		}
	}
}
