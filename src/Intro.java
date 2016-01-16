import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Intro implements ActionListener {
	JFrame frame;
	customBackground panel;
	JButton instructions;
	JButton play;
	JButton back;
	customBackground gamebackground;

	public static void main(String[] args) {
		Intro c = new Intro();
	}

	Intro() {

		frame = new JFrame("Intro Screen");
		panel = new customBackground("background.jpg");

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
				System.out.println("TEST");
				frame.remove(panel);
				gamebackground = new customBackground("gamesceneARCHER.png");
				frame.add(gamebackground);
				gamebackground.repaint();
				frame.setSize(1533,540);
				frame.repaint();
				game x = new game();
				x.mouseClicked(null);
				x.mousePressed(null);
				x.mouseReleased(null);
		
			}
		}
	}


