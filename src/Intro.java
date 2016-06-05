import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Intro implements ActionListener, MouseListener {
	JFrame frame;
	customBackground panel;
	JButton instructions;
	JButton play;
	JButton back;
	customBackground gamebackground;
	Timer time;

	/// int money = 0;
	Boolean inGame = false;
	/// JLabel moneyV;
	AudioClip sound;
	sounds s = new sounds();

	public static void main(String[] args) {
		Intro c = new Intro();
	}

	Intro() {

		frame = new JFrame("Intro Screen");
		panel = new customBackground("background.jpg");

		/// moneyV = new JLabel("Money:" + money);
		frame.addMouseListener(this);
		instructions = new JButton("How To Play");
		play = new JButton("Play Game");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sound = JApplet.newAudioClip(getClass().getResource("arrowR.wav"));
		panel.setLayout(null);
		instructions.setBounds(150, 125, 200, 50);
		play.setBounds(150, 225, 200, 50);

		instructions.setBackground(Color.cyan);
		instructions.setOpaque(true);
		play.setBackground(Color.cyan);
		play.setOpaque(true);
		frame.add(panel);

		panel.add(instructions);
		panel.add(play);
		frame.setSize(500, 500);
		panel.validate();
		panel.repaint();
		play.addActionListener(this);
		instructions.addActionListener(this);
		time = new Timer(1000 / 120, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == instructions) {
			/// panel.remove(play);
			/// panel.remove(instructions);
			JOptionPane.showMessageDialog(null,
					"This game is a scenario in which your base is being attacked by invaders." + "\nYOU must defend the base to restore peace and order.\nYou have a bow + arrow ."
							+ "\nClick to shoot. Enemies have 2 lives.\nGood Luck\n\n LEVEL 1: 25 ammo to kill 10 enemies\n"
							+ "\n LEVEL 2: 45 ammo to kill 20 enemies\n\n LEVEL 3: 25 ammo to kill 10 enemies");
							/// directions.setBounds(150,175,500,500);
							/// panel.validate();
							/// panel.repaint();

			/// for (int i = 0; i < panel.getComponentCount(); i++) {
			/// System.out.println(panel.getComponent(i));
			/// }}
		}

		if (e.getSource() == play) {
			inGame = true;
			System.out.println("TEST");
			frame.remove(panel);
			gamebackground = new customBackground("gamesceneARCHER.png");
			frame.add(gamebackground);

			gamebackground.repaint();
			frame.setSize(1533, 540);

			/// gamebackground.add(moneyV);
			frame.repaint();
			time.start();
			/// game x = new game();
			/// x.mouseClicked(null);
			/// x.mousePressed(null);
			/// x.mouseReleased(null);

		}

		if (e.getSource() == time) {
			gamebackground.updateArrows();
			gamebackground.repaint();

		}
		gamebackground.addEnemy();
		gamebackground.update();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (inGame == true) {

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.mousePressed(e);
		if (inGame == true) {
			s.playSound(sound);
			System.out.println("HOLA");
			gamebackground.addArrow(e.getX(), e.getY());

		} else {

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (inGame == true) {

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (inGame == true) {

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (inGame = true) {
			System.out.println("out");

		}
	}

}
