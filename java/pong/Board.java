import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private Timer timer;
	private Paddle p1;
	private int BOARD_WIDTH;
	private int BOARD_HEIGHT;

	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		p1 = new Paddle(30,0);

		setSize(400,300);
		timer = new Timer(5, this);
		timer.start();
	}

	public void addNotify() {
		super.addNotify();
		BOARD_HEIGHT = getHeight();
		BOARD_WIDTH = getWidth();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if (p1.isVisible()) {
			g2d.drawImage(p1.getImage(), p1.getX(), p1.getY(), this);
		}
		g2d.setColor(Color.BLACK);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		// if ((p1.getY() > 0) && (p1.getY() < BOARD_HEIGHT)) {
		p1.move();
		// }
		repaint();
	}

	private class TAdapter extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			p1.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			p1.keyPressed(e);
		}
	}
}
