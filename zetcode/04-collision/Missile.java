import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {
	private int mX, mY;
	private Image mImage;
	boolean mVisible;

	private final String IMAGE_FILE = "missile.png";
	private final int BOARD_WIDTH = 390;
	private final int MISSILE_SPEED = 2;

	public Missile(int x, int y) {
		ImageIcon ii = new ImageIcon(IMAGE_FILE);
		mImage = ii.getImage();
		mVisible = true;
		mX = x;
		mY = y;
	}

	public Image getImage() {
		return mImage;
	}

	public int getX() {
		return mX;
	}

	public int getY() {
		return mY;
	}

	public boolean isVisible() {
		return mVisible;
	}

	public void move() {
		mX += MISSILE_SPEED;
		if (mX > BOARD_WIDTH) {
			mVisible = false;
		}
	}
}
