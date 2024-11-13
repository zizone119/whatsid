import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CoinMain extends JFrame {
	static int money = 0;

	public CoinMain() {

		setTitle("CoinCounter");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(0x4CA7EC));

		JLabel sum = new JLabel("Amount");
		sum.setFont(new Font("Serif",Font.BOLD,17));
		JTextField input = new JTextField(10);
		Button b = new Button("Calculate");
		b.setBackground(new Color(0x47EF14));
		Button r = new Button("Reset");
		r.setBackground(new Color(0xF63838));
		
		sum.setBounds(30, 10, 60, 20);
		input.setBounds(100, 10, 80, 20);
		b.setBounds(190, 10, 70, 20);
		r.setBounds(270, 10, 40, 20);
		int[] step = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		input.setHorizontalAlignment(JTextField.CENTER);

		c.add(sum);
		c.add(input);
		c.add(b);
		c.add(r);

		JLabel[] unit = new JLabel[10];
		JTextField[] cnt = new JTextField[10];
		Checkbox[] ck = new Checkbox[10];
		for (int i = 0; i < step.length; i++) {
			unit[i] = new JLabel();
			cnt[i] = new JTextField("0",10);
			ck[i] = new Checkbox();

			unit[i].setBounds(50, 30 * (i + 1) + 10, 80, 20);
			cnt[i].setBounds(100, 30 * (i + 1) + 10, 80, 20);
			ck[i].setBounds(230, 30 * (i + 1) + 10, 20, 20);

			unit[i].setText(Integer.toString(step[i]));
			ck[i].setState(true);
			cnt[i].setEditable(false);
			cnt[i].setHorizontalAlignment(JTextField.CENTER);
			c.add(unit[i]);
			c.add(cnt[i]);
			c.add(ck[i]);
		}

		r.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				input.setText("");
				for (int i = 0; i < step.length; i++) {
					cnt[i].setText("0");
					ck[i].setState(true);
				}
				repaint();
			}
		});
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (input.getText().equals("")) {
					return;
				}
				money = Integer.parseInt(input.getText());
				for (int i = 0; i < step.length; i++) {
					if (ck[i].getState() == false)
						cnt[i].setText("0");
					else {
						cnt[i].setText(Integer.toString(money / step[i]));
						money %= step[i];
					}
				}
				repaint();
			}
		});
		setSize(340, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CoinMain();
	}

}
