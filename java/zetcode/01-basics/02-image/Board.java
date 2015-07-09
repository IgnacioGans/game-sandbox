import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Image mImg;

	public Board() {
		initBoard();
	}

	private void initBoard() {
		loadImage();
		int w = mImg.getWidth(this);
		int h = mImg.getHeight(this);
		setPreferredSize(new Dimension(w,h));
	}

	private void loadImage() {
		ImageIcon ii = new ImageIcon("derp.png");
		mImg = ii.getImage();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(mImg, 0, 0, null);
	}
}
