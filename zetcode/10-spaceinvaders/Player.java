import java.awt.event.KeyEvent;
import java.swing.ImageIcon;

public class Player extends Sprite implements Commons {
	private final int START_X = 270;
	private final int START_Y = 280;

	private final String path = "./img/player.png";
	private int mWidth;

	public Player() {
		ImageIcon ii = new ImageIcon(path);
		setImage(ii.getImage());
		mWidth = getImage().getWidth(null);
		setX(START_X);
		setY(START_Y);
	}

	public void act() {
		x += dx;
		if (x <= 2) {
			x = 2;
		}
		if (x >= BOARD_WIDTH - 2*mWidth) {
			x = BOARD_WIDTH - 2*mWidth;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			dx = -2;
		}
		else if (key == KeyEvent.VK_RIGHT) {
			dx = 2;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
			dx = 0;
		}
	}
}
