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
		ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
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

	public void keyPressed(Event e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			dx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 1;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -1;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 1;
		}
	}

	public void keyReleased(Event e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
			dx = 0;
		}
		if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
			dy = 0;
		}
	}
}
