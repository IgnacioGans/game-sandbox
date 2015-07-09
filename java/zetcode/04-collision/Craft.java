import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Craft extends Entity {

	private int mDx;
	private int mDy;
	private ArrayList<Missile> mMissiles;

	// private final String IMAGE_FILE = "craft.png";
	private final int CRAFT_SIZE = 20;

	public Craft() {
		IMAGE_FILE = "craft.png";
		this.init(40,60);
		mMissiles = new ArrayList<Missile>();
	}

	public void move() {
		mX += mDx;
		mY += mDy;
		if (mX < 1) {
			mY = 1;
		}
		if (mY < 1) {
			mY = 1;
		}
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
