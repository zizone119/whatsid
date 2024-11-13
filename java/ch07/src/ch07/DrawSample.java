package ch07;

import java.awt.*;
import javax.swing.*;

public class DrawSample extends JFrame {
	private MyPanel panel = new MyPanel();

	public DrawSample() {
		setTitle("sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 420);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.ITALIC, 40));
			g.drawString("Go Gator", 10, 150);
			g.setClip(100, 20, 150, 150);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.drawString("Go Gator", 10, 150);
		}
	}

	public static void main(String[] args) {
		new DrawSample();
	}
}
