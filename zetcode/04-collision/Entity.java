import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Entity {
	protected int mX;
	protected int mY;
	protected int mWidth;
	protected int mHeight;
	protected Image mImage;
	protected boolean mVisible;

	protected static String IMAGE_FILE;

	protected void init(int x, int y) {
		ImageIcon ii = new ImageIcon(IMAGE_FILE);
		mImage = ii.getImage();
		mVisible = true;
		
		mWidth = mImage.getWidth(null);
		mHeight = mImage.getHeight(null);
		mX = x;
		mY = y;
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

	public void move() {
		// MUST be reimplemented in subclasses
	}
}
