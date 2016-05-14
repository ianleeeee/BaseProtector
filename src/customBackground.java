import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class customBackground extends JPanel implements ActionListener, MouseListener {

	BufferedImage background;
	BufferedImage arrowImage;
	CopyOnWriteArrayList<arrow> arrowList;
	CopyOnWriteArrayList<enemy> enemyList;
	BufferedImage enemyImage;
	JLabel kills;
	Boolean gameEnd = false;
	counters scoreCounters = new counters();
	towerSTUFF towerhealth = new towerSTUFF();
	long enemyTimer = -1;
	Random random = new Random();
	int ammo = 30;
	int enemyHealth = 2;

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

		scoreCounters.draw(g);
		towerhealth.draw(g);

		for (arrow a : arrowList) {
			a.draw(g);
		}
		for (enemy e : enemyList) {
			e.paint(g);

		}

	}

	void addArrow(int x, int y) {
		arrowList.add(new arrow(198, 60, 100, 100, 10, 10, x, y, arrowImage));
		scoreCounters.ammo--;
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
		repaint();
	}

	void addEnemy() {
		if (enemyTimer == -1) {
			enemyTimer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - enemyTimer >= 1000) {
			int speedRandom = random.nextInt(7);
			if (speedRandom == 0) {
				speedRandom += 1;
			}

			enemyList.add(new enemy(1329, 300, 200, 200, speedRandom, enemyImage));
			enemyTimer = -1;
		}
	}

	void checkCollision() {
		for (enemy e : enemyList) {
			if (e.getX() <= 66) {
				JOptionPane.showMessageDialog(null, "TOWER HIT, -1 HEALTH");
				towerhealth.towerHP--;
				enemyList.remove(e);
				if (towerhealth.towerHP == 0) {
					JOptionPane.showMessageDialog(null, "GAME OVER, TOWER DESTROYED");
					System.exit(1);
				}
			}

			for (arrow a : arrowList) {
				if (e.getBox().intersects(a.getBox())) {
					System.out.println("collision");
					enemyHealth -= 1;
					arrowList.remove(a);
					if (enemyHealth == 0) {
						enemyList.remove(e);
						enemyHealth = 2;
					}
					scoreCounters.levelTracker++;
					if (scoreCounters.ammo <= 0) {
						JOptionPane.showMessageDialog(null, "GAME OVER, NO MORE AMMO");
						gameEnd = true;
						System.exit(1);

					} else {

					}
					if (scoreCounters.levelTracker == 20 && scoreCounters.ammo >= 1) {
						JOptionPane.showMessageDialog(null, "Level 2!");
						scoreCounters.ammo = 45;
					} else {

					}
					if (scoreCounters.levelTracker == 60 && scoreCounters.ammo >= 1) {
						JOptionPane.showMessageDialog(null, "Level 3!");
						scoreCounters.ammo = 11;

					} else {

					}
					if (scoreCounters.levelTracker == 70 && scoreCounters.ammo >= 0) {
						JOptionPane.showMessageDialog(null, "Good job you win");

					} else {

					}

				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("hi");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
