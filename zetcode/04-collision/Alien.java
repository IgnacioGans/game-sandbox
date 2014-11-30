import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Alien extends Entity {
	public Alien(int x, int y) {
		IMAGE_FILE = "alien.png";
		this.init(x,y);
	}

	public void move() {
		if (mX < 0) {
			mX = 400;
		}
		mX--;
	}
}
