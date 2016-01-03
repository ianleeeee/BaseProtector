import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Intro implements ActionListener{
	JFrame frame;
	customBackground panel;
	JButton instructions;
	JButton play;
	JButton back;

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
		
	}
}
