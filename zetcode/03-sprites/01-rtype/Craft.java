import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Craft {
	private String craft = "craft.png";

	private int mDx;
	private int mDy;
	private int mX;
	private int mY;
	private Image mImage;

	public Craft() {
		ImageIcon ii = new ImageIcon(craft);
		// ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
		mImage = ii.getImage();
		mX = 40;
		mY = 60;
	}

	public void move() {
		mX += mDx;
		mY += mDy;
	}

	public int getX() {
		return mX;
	}

	public int getY() {
		return mY;
	}

	public Image getImage() {
		return mImage;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			mDx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			mDx = 1;
		}

		if (key == KeyEvent.VK_UP) {
			mDy = -1;
		}

		if (key == KeyEvent.VK_DOWN) {
			mDy = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
			mDx = 0;
		}
		if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
			mDy = 0;
		}
	}
}
