package ch09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread {
	private JLabel timerLabel;

	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	@Override
	public void run() {
		int n = 0;
		while (true) {
			timerLabel.setText(Integer.toString(n++));
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}

		}
	}
}

public class TimerEx extends JFrame{
	public TimerEx() {
		setTitle("Timer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.BOLD,80));
		c.add(timerLabel);
		TimerThread th = new TimerThread(timerLabel);
		setSize(300,170);
		setVisible(true);
		th.start();
	}
	public static void main(String[] args) {
		new TimerEx();
	}

}
