import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {
	private final int width = 350;
	private final int height = 350;
	private final int initX = -40;
	private final int initY = -40;
	private final int delay = 25;

	private Image star;
	private Thread animator;
	private int x,y;

	public Board() {
		initBoard();
	}

	private void loadImage() {
		ImageIcon ii = new ImageIcon("star.png");
		star = ii.getImage();
	}

	private void initBoard() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width, height));
		setDoubleBuffered(true);

		loadImage();

		x = initX;
		y = initY;
	}

	@Override
	public void addNotify() {
		super.addNotify();

		animator = new Thread(this);
		animator.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawStar(g);
	}

	private void drawStar(Graphics g) {
		g.drawImage(star, x, y, this);
		Toolkit.getDefaultToolkit().sync();
	}

	private void cycle() {
		x++;
		y++;

		if (y > height) {
			y = initY;
			x = initX;
		}
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
		beforeTime = System.currentTimeMillis();
		while (true) {
			cycle();
			repaint();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = delay - timeDiff;
			if (sleep < 0) {
				sleep = 2;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}

			beforeTime = System.currentTimeMillis();
		}
	}
}
