
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class instructions implements ActionListener{
	JFrame frame;
	customBackground panel;
	JTextField directions;



	instructions() {

		frame = new JFrame("How To Play");
		panel = new customBackground("howtoplay.jpg");
		directions = new JTextField("This game is a scenario in which your base is being attacked by invaders.\nYOU must defend the base to restore peace and order.\nYou start with a bow + arrow that does little damage but as you kill invaders,\nyou will gain money that you can use to upgrade your weapon.\nClick to shoot.\nGood Luck");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.add(panel);
		panel.add(directions);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

