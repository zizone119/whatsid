package ch09;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Clock extends JLabel implements Runnable{
	public Clock() {
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		while(true){
			Calendar cal = Calendar.getInstance();
			int h = cal.get(Calendar.HOUR_OF_DAY);
			int m = cal.get(Calendar.MINUTE);
			int s = cal.get(Calendar.SECOND);
			String str = Integer.toString(h);
			str = str.concat(":");
			str = str.concat(Integer.toString(m));
			str = str.concat(":");
			if(s>=10)str = str.concat(Integer.toString(s));
			else str=str.concat("0"+Integer.toString(s));
			this.setText(str);
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				return;
			}
			repaint();
		}
		
		
	}
	
}
public class TimeEx extends JFrame {

	public TimeEx() {
		setTitle("Clock");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		JLabel clock = new Clock();

		clock.setFont(new Font("Gothic", Font.BOLD, 30));
		clock.setBounds(50, 50, 150, 50);
		c.add(clock);
		c.setBackground(Color.yellow);

		setSize(250, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new TimeEx();
	}

}
