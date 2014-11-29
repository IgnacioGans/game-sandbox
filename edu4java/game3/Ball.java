import java.awt.Graphics2D;

public class Ball {
	private int mX = 0;
	private int mY = 0;
	private int mXDir = 1;
	private int mYDir = 1;
	private Game2 mGame;

	public Ball(Game2 game) {
		this.mGame = game;
	}

	void move() {
		if (mX + mXDir < 0) {
			mXDir = 1;
		}
		if (mX + mXDir > mGame.getWidth() - 30) {
			mXDir = -1;
		}
		if (mY + mYDir < 0) {
			mYDir = 1;
		}
		if (mY + mYDir > mGame.getHeight() - 30) {
			mYDir = -1;
		}

		mX = mX+mXDir;
		mY = mY+mYDir;
	}

	public void paint(Graphics2D g) {
		g.fillOval(mX,mY,30,30);
	}
}
