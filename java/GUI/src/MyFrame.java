
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ContentPane extends JFrame{

	public ContentPane() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("myframe");
		
		Container c= getContentPane();
		c.setLayout(null);
		
		JLabel la = new JLabel("Hello");
		la.setLocation(130,50);
		la.setSize(50,20);
		c.add(la);
		
		for(int i=1;i<=9;i++) {
			JButton b= new JButton(Integer.toString(i));
			b.setLocation(i*15,i*15);
			b.setSize(50,20);
			c.add(b);
		}
		
		for(int i=10;i<18;i++) {
			JButton b= new JButton(Integer.toString(i));
			b.setLocation(i*15,18*15-i*15);
			b.setSize(50,20);
			c.add(b);
		}
		
		setSize(400,200);
		setVisible(true);
	}
}

public class MyFrame{

	public static void main(String[] args) {
		new ContentPane();	
	}

}
