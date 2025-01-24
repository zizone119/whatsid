package ch07;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FontSample extends JFrame {

	private MyPanel panel = new MyPanel();

	public FontSample() {
		setTitle("sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(350, 470);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawString("I love Java", 30, 30);
			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("How much?", 30, 60);
			g.setColor(new Color(0x00ff00ff));
			for (int i = 1; i <= 5; i++) {
				g.setFont(new Font("Jokerman", Font.ITALIC, i * 10));
				g.drawString("This much!!", 30, 60 + i * 60);
			}

		}
	}

	public static void main(String[] args) {
		new FontSample();
	}

}