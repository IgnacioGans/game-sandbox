import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private Timer mTimer;
	private Craft mCraft;
	private ArrayList<Alien> mAliens;
	private boolean mIngame;
	private int BOARD_WIDTH;
	private int BOARD_HEIGHT;

	private int[][] pos = {
		{2380, 29}, {2500, 59}, {1380, 89},
		{780, 109}, {580, 139}, {680, 239}, 
		{790, 259}, {760, 50}, {790, 150},
		{980, 209}, {560, 45}, {510, 70},
		{930, 159}, {590, 80}, {530, 60},
		{940, 59}, {990, 30}, {920, 200},
		{900, 259}, {660, 50}, {540, 90},
		{810, 220}, {860, 20}, {740, 180},
		{820, 128}, {490, 170}, {700, 30}
	};

	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		mIngame = true;

		setSize(400,300);

		mCraft = new Craft();

		initAliens();

		mTimer = new Timer(5,this);
		mTimer.start();
	}

	public void addNotify() {
		super.addNotify();
		BOARD_WIDTH = getWidth();
		BOARD_HEIGHT = getHeight();
	}

	public void initAliens() {
		mAliens = new ArrayList<Alien>();

		for (int i = 0; i < pos.length; i++) {
			mAliens.add(new Alien(pos[i][0], pos[i][1]));
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (mIngame) {
			Graphics2D g2d = (Graphics2D) g;
			if (mCraft.isVisible()) {
				g2d.drawImage(mCraft.getImage(), mCraft.getX(), mCraft.getY(), this);
			}

			ArrayList ms = mCraft.getMissiles();
			for (int i = 0; i < ms.size(); i++) {
				Missile m = (Missile)ms.get(i);
				g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}

			for (int i = 0; i < mAliens.size(); i++) {
				Alien a = mAliens.get(i);
				if (a.isVisible()) {
					g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
				}
			}

			g2d.setColor(Color.WHITE);
			g2d.drawString("Aliens left: " + mAliens.size(), 5, 15);
		}

		else {
			String msg = "Game over";
			Font small = new Font("Helvetica", Font.BOLD, 14);
			FontMetrics metr = this.getFontMetrics(small);

			g.setColor(Color.WHITE);
			g.setFont(small);
			g.drawString(msg, (BOARD_WIDTH - metr.stringWidth(msg))/2, BOARD_HEIGHT/2);
		}

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (mAliens.isEmpty()) {
			mIngame = false;
		}

		ArrayList ms = mCraft.getMissiles();
		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile)ms.get(i);
			if (m.isVisible()) {
				m.move();
			}
			else {
				ms.remove(i);
				i--;
			}
		}

		for (int i = 0; i < mAliens.size(); i++) {
			Alien a = (Alien) mAliens.get(i);
			if (a.isVisible()) {
				a.move();
			}
			else {
				mAliens.remove(i);
				i--;
			}
		}

		mCraft.move();
		checkCollisions();
		repaint();
	}

	public void checkCollisions() {
		Rectangle r3 = mCraft.getBounds();
		for (int j = 0; j < mAliens.size(); j++) {
			Alien a = (Alien)mAliens.get(j);
			Rectangle r2 = a.getBounds();

			if (r3.intersects(r2)) {
				mCraft.setVisible(false);
				a.setVisible(false);
				mIngame = false;
			}
		}

		ArrayList ms = mCraft.getMissiles();
		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile)ms.get(i);
			Rectangle r1 = m.getBounds();
			for (int j = 0; j < mAliens.size(); j++) {
				Alien a = (Alien)mAliens.get(j);
				Rectangle r2 = a.getBounds();

				if (r1.intersects(r2)) {
					m.setVisible(false);
					a.setVisible(false);
				}
			}
		}
	}

	private class TAdapter extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			mCraft.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			mCraft.keyPressed(e);
		}
	}


}
