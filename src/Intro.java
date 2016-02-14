import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Intro implements ActionListener, MouseListener {
	JFrame frame;
	customBackground panel;
	JButton instructions;
	JButton play;
	JButton back;
	customBackground gamebackground;
	Boolean inGame = false;
	Timer time;
	int money = 0;
	JLabel moneyV;
	sounds s = new sounds();

	public static void main(String[] args) {
		Intro c = new Intro();
	}

	Intro() {

		frame = new JFrame("Intro Screen");
		panel = new customBackground("background.jpg");
		moneyV = new JLabel("Money:"+money);
		frame.addMouseListener(this);
		instructions = new JButton("How To Play");
		play = new JButton("Play Game");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		time = new Timer(1000/120,this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == instructions) {
			/// panel.remove(play);
			/// panel.remove(instructions);
			JOptionPane.showMessageDialog(null,
					"This game is a scenario in which your base is being attacked by invaders.\nYOU must defend the base to restore peace and order.\nYou start with a bow + arrow that does little damage but as you kill invaders,\nyou will gain money that you can use to upgrade your weapon.\nClick to shoot.\nGood Luck");
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
			frame.add(moneyV);
			frame.repaint();
			time.start();
			/// game x = new game();
			/// x.mouseClicked(null);
			/// x.mousePressed(null);
			/// x.mouseReleased(null);

		}
		
		if(e.getSource()==time){
			gamebackground.updateArrows();
			gamebackground.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (inGame == true) {

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (inGame == true) {
			s.playSound("arrowR.wav");
			
			gamebackground.addArrow(e.getX(), e.getY());
			money+=1;
			moneyV.setText("Money:"+money);
					} 
		else {

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

		}
	}

}
