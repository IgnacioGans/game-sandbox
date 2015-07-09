import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private final int width = 350;
	private final int height = 350;
	private final int initX = -40;
	private final int initY = -40;
	private final int delay = 25;

	private Image star;
	private Timer timer;
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
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawStar(g);
	}

	private void drawStar(Graphics g) {
		g.drawImage(star,x,y,this);
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x++;
		y++;

		if (y > height) {
			y = initY;
			x = initX;
		}
		repaint();
	}
}
