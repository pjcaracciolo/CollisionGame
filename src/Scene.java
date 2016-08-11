import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JPanel;

public class Scene extends Level {

	public Scene() {
		boxX = 40;
		boxY = 40;
		initialBoxX = 40;
		initialBoxY = 40;
		addObstacles(topZone, rect1, rect2, rect3, rect4, rect5, rect6, rect7);
	}

	Rectangle topZone = new Rectangle(0, 0, 600, 30);
	Rectangle rect1 = new Rectangle(0, 0, 30, 450);
	Rectangle rect2 = new Rectangle(100, 0, 30, 300);
	Rectangle rect3 = new Rectangle(0, 400, 600, 30);
	Rectangle rect4 = new Rectangle(350, 0, 30, 300);
	Rectangle rect5 = new Rectangle(225, 110, 30, 300);
	Rectangle rect6 = new Rectangle(475, 110, 30, 300);
	Rectangle rect7 = new Rectangle(570, 0, 30, 450);
	Rectangle rect8 = new Rectangle(504, 355,66, 45);


	@Override
	public void drawCourse(Graphics g) {
		g.setColor(Color.GREEN.brighter());
		fillRect(topZone, g);
		g.fillRect(0, 0, 30, 450);
		g.fillRect(100, 0, 30, 300);
		g.fillRect(0, 400, 600, 30);
		fillRect(rect4, g);
		fillRect(rect5, g);
		fillRect(rect6, g);
		fillRect(rect7, g);
		g.setColor(Color.MAGENTA);
		fillRect(rect8,g);
	}

	@Override
	public void drawBox(Graphics g) {
		g.setColor(Color.RED.brighter());
		g.fillRect(boxX, boxY, 20, 20);
		g.setColor(Color.RED.darker());
		g.drawRect(boxX, boxY, 20, 20);
	}

	@Override
	public boolean failedLevel() {
		for (Rectangle r : getObstacles())
			if (r.contains(boxX + 10, boxY + 10))
				return true;
		return false;
	}

	@Override
	public boolean completedLevel() {
		// TODO Auto-generated method stub
		return rect8.contains(new Point(boxX + 10,boxY + 10));
	}

	@Override
	public Level nextLevel() {
		// TODO Auto-generated method stub
		return new Scene2();
	}

}
