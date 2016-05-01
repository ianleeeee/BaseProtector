
///hold this for now
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class instructions implements ActionListener {
	JFrame frame;
	customBackground panel;
	JTextField directions;

	instructions() {

		frame = new JFrame("How To Play");
		panel = new customBackground("howtoplay.jpg");
		directions = new JTextField(
				"This game is a scenario in which your base is being attacked by invaders.\nYOU must defend the base to restore peace and order.\nYou have a bow + arrow .\nClick to shoot.\nGood Luck\n\n LEVEL 1: 25 ammo to kill 20 enemies\n\n LEVEL 2: 45 ammo to kill 40 enemies\n\n LEVEL 3: 11 ammo to kill 10 enemies");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.add(panel);
		panel.add(directions);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
