package baiTap.bai6;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends JPanel implements Shape {

	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawOval(30, 30, 200, 200);
	}

}
