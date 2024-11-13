import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppleDrag extends JFrame{
	
	JLabel la = new JLabel();
		
	public AppleDrag(){
		super("apple");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setContentPane(new MyPanel());
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		ImageIcon icon = new ImageIcon("images/image1.jpg");
		Image img= icon.getImage();
		private int x=100;
		private int y=100;
			
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					super.mouseDragged(e);
					x=e.getX();
					y=e.getY();
					repaint();
				}
			});
			
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,this.x,this.y, this.icon.getIconWidth(),this.icon.getIconHeight(),rootPane);
		}
	}
	

	public static void main(String[] args) {
		new AppleDrag();
	}

}
