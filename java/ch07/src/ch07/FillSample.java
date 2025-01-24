package ch07;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FillSample extends JFrame{
	
	private Mypanel panel = new Mypanel();
	public FillSample() {
		setTitle("sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(100,350);
		setVisible(true);
	}
	
	class Mypanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.GREEN);
			g.fillRoundRect(10, 130, 50, 50,20,20);
			g.setColor(Color.MAGENTA);
			g.fillArc(10, 190, 50, 50,0,270);
			g.setColor(Color.ORANGE);
			int[] x= {30,10,30,60};
			int[] y= {250,275,300,275};
			g.fillPolygon(x,y,4);
		}
	}
	
	public static void main(String[] args) {
		new FillSample();
	}

}
