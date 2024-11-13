package ch07;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample extends JFrame {

	private MyPanel panel = new MyPanel();

	public Sample() {
		setTitle("graphic");
		setSize(250, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
		}
	}

	public static void main(String[] args) {
		new Sample();
	}

}
