import java.awt.event.KeyEvent;

public class Paddle extends Entity {
	private int dy;

	public Paddle(int x, int y) {
		spritePath = "./img/paddle.png";
		init(x,y);
		this.visible = true;
	}

	public void move() {
		y += dy;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			dy = -1;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
			dy = 0;
		}
	}
}
