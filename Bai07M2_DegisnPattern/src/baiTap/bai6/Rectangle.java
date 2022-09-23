package baiTap.bai6;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Rectangle extends JPanel implements Shape{


	private static final long serialVersionUID = 1L;

	@Override
	public void draw(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(20, 50, 220, 150);
		
	}

}
