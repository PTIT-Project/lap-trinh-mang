package clientcaro;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PlayNow extends Thread {

	private JPanel user;

	public PlayNow(JPanel user) {
		this.user = user;
	}

	@Override
	public void run() {
		while (true) {
			user.setBorder(new LineBorder(Color.YELLOW));
			try {
				Thread.sleep(500);
				user.setBorder(new LineBorder(Color.GREEN));
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}
		}
	}
}
