package ch09;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickingLabel extends JLabel implements Runnable{

	private long delay;
	public FlickingLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true);
		new Thread(this).start();
	}

	@Override
	public void run() {
		int n=0;
		while(true) {
			if(n==0) setBackground(Color.yellow);
			else setBackground(Color.green);
			n=1-n;
			try {
				Thread.sleep(delay);
			}catch(InterruptedException e) {return;}
		}
	}
	
}

public class FlickingEx extends JFrame{
	public FlickingEx() {
		setTitle("Flicking");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		FlickingLabel fLabel = new FlickingLabel("깜박",500);
		JLabel label = new JLabel("안깜박");
		FlickingLabel fLabel2 = new FlickingLabel("여기도 깜박",300);
		
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);
		
		setSize(300,150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new FlickingEx();
	}

}
