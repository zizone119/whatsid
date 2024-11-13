import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageDraw extends JFrame {
	public ImageDraw() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setContentPane(new MyPanel());
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();
		private JButton button = new JButton("hide/show");
		private boolean showFlag = true;
		public MyPanel() {
			setLayout(new FlowLayout());
			add(button);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					showFlag=!showFlag;
					repaint();
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(showFlag) g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
			
		}
	}

	public static void main(String[] args) {
		new ImageDraw();
	}

}
