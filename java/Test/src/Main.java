import java.awt.Container;

import javax.swing.JFrame;

public class Main extends JFrame {
	public Main() {
		setTitle("main");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container frame = new Container();
		frame.setLayout(null);
		
		setSize(getMaximumSize());
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
