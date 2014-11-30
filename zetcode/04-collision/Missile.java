import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile extends Entity {
	// protected final String IMAGE_FILE = "missile.png";
	private final int BOARD_WIDTH = 390;
	private final int MISSILE_SPEED = 2;

	public Missile(int x, int y) {
		IMAGE_FILE = "missile.png";
		this.init(x,y);
	}

	public void move() {
		mX += MISSILE_SPEED;
		if (mX > BOARD_WIDTH) {
			mVisible = false;
		}
	}
}
