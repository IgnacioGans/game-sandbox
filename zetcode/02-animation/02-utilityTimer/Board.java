import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	private final int width = 350;
	private final int height = 350;
	private final int initX = -40;
	private final int initY = -40;
	private final int initDelay = 100;
	private final int periodInterval = 25;

	private Image star;
	private Timer timer;
	private int x,y;

	public Board() {
		initBoard();
	}

	private void loadImage() {
		ImageIcon ii = new ImageIcon("star.png");
		star = ii.getImage;
	}

	private void initBoard() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width, height));
		setDoubleBuffered(true);

		loadImage();

		x = initX;
		y = initY;

		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), initDelay, periodInterval);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawStar(g);
	}

	private void drawStar(g) {
		g.drawImage(star, x, y, this);
		Toolkit.getDefaultToolkit().sync();
	}

	private class ScheduleTask extends TimerTask {
		@Override
		public void run() {
			x++;
			y++;
			if (y > height) {
				x = initX;
				y = initY;
			}
			repaint();
		}
	}
}
