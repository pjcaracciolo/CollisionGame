import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

//Collision Game
//Author: Paul Caracciolo
//Date: Aug 10, 2016
//Email: pjcaracc@rams.colostate.edu

public abstract class Level extends JPanel implements KeyListener, MouseMotionListener {

	public Level() {
		addKeyListener(this);
		addMouseMotionListener(this);
		setVisible(true);
		setFocusable(true);
	}

	private ArrayList<Rectangle> obstacles = new ArrayList<Rectangle>();

	@Override
	public void mouseMoved(MouseEvent e) {
		mX = e.getX();
		mY = e.getY();
		System.out.println("Yay");
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	int mX = 0, mY = 0;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN.brighter());
		drawCourse(g);
		drawBox(g);
		if (failedLevel()) {
			boxX = initialBoxX;
			boxY = initialBoxY;
		}
		if (completedLevel()) {
			System.out.println("Level Complete!");
			Display.getFrames()[0].dispatchEvent(new WindowEvent(Display.getFrames()[0], WindowEvent.WINDOW_CLOSING));
			new Display(nextLevel());
		}
		g.setColor(Color.BLACK);
		g.drawString("Mouse Pos: (" + mX + "," + mY + ")", 10, 20);
	}

	int boxX, boxY, initialBoxX, initialBoxY;

	public abstract boolean failedLevel();

	public abstract boolean completedLevel();

	public abstract Level nextLevel();

	public abstract void drawCourse(Graphics g);

	public abstract void drawBox(Graphics g);

	public void fillRect(Rectangle r, Graphics g) {
		g.fillRect(r.x, r.y, r.width, r.height);
	}

	public void drawRect(Rectangle r, Graphics g) {
		g.drawRect(r.x, r.y, r.width, r.height);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			boxX += 5;
			break;
		case KeyEvent.VK_LEFT:
			boxX -= 5;
			break;
		case KeyEvent.VK_DOWN:
			boxY += 5;
			break;
		case KeyEvent.VK_UP:
			boxY -= 5;
			break;
		}
		System.out.println("Success + " + boxX + " " + boxY);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void addObstacles(Rectangle... rectangles) {
		for (Rectangle r : rectangles)
			obstacles.add(r);
	}

	public ArrayList<Rectangle> getObstacles() {
		return obstacles;
	}
}
