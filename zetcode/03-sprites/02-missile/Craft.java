import java.awt.Image;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Craft {

	private int mDx;
	private int mDy;
	private int mX;
	private int mY;
	private Image mImage;

	private ArrayList<Missile> mMissiles;

	private final String IMAGE_FILE = "craft.png";
	private final int CRAFT_SIZE = 20;

	public Craft() {
		ImageIcon ii = new ImageIcon(IMAGE_FILE);
		mImage = ii.getImage();
		mMissiles = new ArrayList<Missile>();
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

	public ArrayList<Missile> getMissiles() {
		return mMissiles;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			fire();
		}

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

	public void fire() {
		mMissiles.add(new Missile(mX+CRAFT_SIZE, mY+CRAFT_SIZE/2));
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
