import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Scene2 extends Level {
	public Scene2() {
		boxX = 100;
		boxY = 100;
		initialBoxX = 100;
		initialBoxY = 100;
		addObstacles(rect1, rect2, rect3, rect4);
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
		return winRect.contains(boxX+10,boxY+10);
	}

	@Override
	public Level nextLevel() {
		// TODO Auto-generated method stub
		return new Scene3();
	}

	Rectangle rect1 = new Rectangle(0, 0, 600, 30);
	Rectangle rect2 = new Rectangle(0, 0, 30, 450);
	Rectangle rect3 = new Rectangle(0, 400, 600, 30);
	Rectangle rect4 = new Rectangle(570, 0, 30, 450);
	Rectangle winRect = new Rectangle(515, 320, 55, 80);


	@Override
	public void drawCourse(Graphics g) {
		fillRect(rect1, g);
		fillRect(rect2, g);
		fillRect(rect3, g);
		fillRect(rect4, g);
		g.setColor(Color.MAGENTA);
		fillRect(winRect,g);
	}

	@Override
	public void drawBox(Graphics g) {
		g.setColor(Color.RED.brighter());
		g.fillRect(boxX, boxY, 20, 20);
		g.setColor(Color.RED.darker());
		g.drawRect(boxX, boxY, 20, 20);
	}

}
