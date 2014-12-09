import javax.swing.ImageIcon;

public class Ball extends Sprite implements Commons {
	private int xdir;
	private int ydir;

	protected String ball = "ball.png";

	public Ball() {
		xdir = 1;
		ydir = -1;

		ImageIcon ii = new ImageIcon(ball);
		image = ii.getImage();

		width = image.getWidth(null);
		height = image.getHeight(null);

		resetState();
	}

	public void move() {
		x += xdir;
		y += ydir;

		if (x == 0) {
			setXDir(1);
		}

		if (x == BALL_RIGHT) {
			setXDir(-1);
		}

		if (y == 0) {
			setYDir(1);
		}
	}

	public void resetState() {
		x = 230;
		y = 355;
	}

	public void setXDir(int xdir) {
		this.xdir = xdir;
	}

	public void setYDir(int ydir) {
		this.ydir = ydir;
	}
}
