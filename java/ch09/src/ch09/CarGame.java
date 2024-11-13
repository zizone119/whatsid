package ch09;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame {
	
	class MyThread extends Thread{
		private JLabel label;
		private int x,y;
		
		public MyThread(String fname,int x, int y) {
			this.x=x;
			this.y=y;
			label = new JLabel("car");
			ImageIcon icon = new ImageIcon(fname);
			label.setIcon(icon);
			label.setBounds(x,y,100,100);
			add(label);
		}
		
		@Override
		public void run() {
			for(int i=0;i<200;i++) {
				x+=10*Math.random();
				label.setBounds(x,y,100,100);
				repaint();
				try {
					Thread.sleep(100);
				}catch (Exception e) {
					return;
				}
			}
		}
	}
	
	public CarGame() {
		setTitle("Car Game");;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,200);
		setLayout(null);
		setVisible(true);
		
		MyThread car1= new MyThread("car1.png", 100,0);
		MyThread car2= new MyThread("car2.png", 100,50);
		MyThread car3= new MyThread("car3.png", 100,100);
		
		car1.start();
		car2.start();
		car3.start();
	}

	public static void main(String[] args) {
		new CarGame();
	}

}
