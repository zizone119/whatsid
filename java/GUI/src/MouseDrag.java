import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class MouseDrag extends JFrame {
	MyPanel panel = new MyPanel();
	public MouseDrag() {
		super("sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setContentPane(panel);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();
		private int ovalX = 100, ovalY = 100;
		private final int RADIUS = 20;

		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					super.mouseDragged(e);
					ovalX=e.getX();
					ovalY=e.getY();
					repaint();
				}
			});
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					super.mousePressed(e);
					ovalX=e.getX();
					ovalY=e.getY();
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), rootPane);
			g.setColor(Color.green);
			g.fillOval(ovalX, ovalY, RADIUS, RADIUS);
		}
	}

	public static void main(String[] args) {
		new MouseDrag();
	}

}
