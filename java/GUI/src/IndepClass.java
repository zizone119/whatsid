
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IndepClass extends JFrame {

	public IndepClass() {
		setTitle("sample");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton b = new JButton("Action");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("Action"))
					b.setText("액션");
				else
					b.setText("Action");
			}
		});
		c.add(b);
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new IndepClass();
	}
}
