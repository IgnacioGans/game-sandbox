import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Alien {
	private int mX;
	private int mY;
	private int mWidth;
	private int mHeight;
	private boolean mVisible;
	private Image mImage;

	private final String IMAGE_FILE = "alien.png";

	public Alien(int x, int y) {
		ImageIcon ii = new ImageIcon(IMAGE_FILE);
		mImage = ii.getImage();
		mVisible = true;
		
		mWidth = mImage.getWidth(null);
		mHeight = mImage.getHeight(null);
		mX = x;
		mY = y;
	}

	public void move() {
		if (mX < 0) {
			mX = 400;
		}
		mX--;
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

	public void setVisible(boolean visible) {
		mVisible = visible;
	}

	public Image getImage() {
		return mImage;
	}

	public Rectangle getBounds() {
		return new Rectangle(mX, mY, mWidth, mHeight);
	}
}
