import java.applet.AudioClip;

import javax.swing.JApplet;

public class sounds {
	public static void main(String[] args) {
		sounds D = new sounds();
	}

	sounds() {

	}

	void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

}
