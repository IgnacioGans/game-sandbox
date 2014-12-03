import java.awt.Rectangle;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Entity {
	private int x;
	private int y;
	private int width;
	private int height;
	private String spritePath;
	private Image image;
	private boolean visible;

	private void init(int x, int y) {
		ImageIcon ii = new ImageIcon(spritePath);
		image = ii.getImage();

		width = image.getWidth(null);
		height = image.getHeight(null);

		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
