import java.awt.Rectangle;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Entity {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected String spritePath;
	protected Image image;
	protected boolean visible;

	protected void init(int x, int y) {
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

	public void move() {
		// MUST be reimplemented in subclasses
	}
}
