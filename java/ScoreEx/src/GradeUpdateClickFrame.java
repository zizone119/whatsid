import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class GradeUpdateClickFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textclassyear, textstudentname, textkorean, textenglish;
	private JFrame frame;
	private DefaultTableModel tableModel;

	private GradeDAO dao;
	private JTextField textmath;
	private JLabel stuidLabel;

	public GradeUpdateClickFrame(String studentid) { // 매개 변수를 생성해줘서 grademainframe에서 보낸 값을 사용할 수 있도록 하는 것)
		frame = this;
		dao = GradeDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 230, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textclassyear = new JTextField();
		textclassyear.setFont(new Font("굴림", Font.PLAIN, 13));
		textclassyear.setColumns(10);
		textclassyear.setBounds(51, 53, 144, 33);
		contentPane.add(textclassyear);

		textstudentname = new JTextField();
		textstudentname.setFont(new Font("굴림", Font.PLAIN, 13));
		textstudentname.setColumns(10);
		textstudentname.setBounds(51, 96, 144, 33);
		contentPane.add(textstudentname);

		JLabel lblstudentid = new JLabel("학번");
		lblstudentid.setBounds(12, 10, 32, 24);
		contentPane.add(lblstudentid);

		JLabel lblclassyear = new JLabel("학년");
		lblclassyear.setBounds(12, 57, 38, 24);
		contentPane.add(lblclassyear);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateGrade();
			}
		});
		btnUpdate.setBounds(51, 281, 114, 38);
		contentPane.add(btnUpdate);

		JLabel lblkorean = new JLabel("국어");
		lblkorean.setBounds(12, 143, 32, 24);
		contentPane.add(lblkorean);

		textkorean = new JTextField();
		textkorean.setFont(new Font("굴림", Font.PLAIN, 13));
		textkorean.setColumns(10);
		textkorean.setBounds(51, 139, 144, 33);
		contentPane.add(textkorean);

		JLabel lblenglish = new JLabel("영어");
		lblenglish.setBounds(12, 187, 32, 24);
		contentPane.add(lblenglish);

		textenglish = new JTextField();
		textenglish.setFont(new Font("굴림", Font.PLAIN, 13));
		textenglish.setColumns(10);
		textenglish.setBounds(51, 183, 144, 33);
		contentPane.add(textenglish);

		JLabel lblmath = new JLabel("수학");
		lblmath.setBounds(12, 229, 32, 24);
		contentPane.add(lblmath);

		textmath = new JTextField();
		textmath.setFont(new Font("굴림", Font.PLAIN, 13));
		textmath.setColumns(10);
		textmath.setBounds(51, 225, 144, 33);
		contentPane.add(textmath);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 10, 144, 34);
		contentPane.add(scrollPane);
		
		stuidLabel = new JLabel(studentid);
		scrollPane.setViewportView(stuidLabel);

		JLabel lblstudentname = new JLabel("이름");
		lblstudentname.setBounds(12, 96, 38, 32);
		contentPane.add(lblstudentname);
	}

	protected void updateGrade() {
		String classYearText = textclassyear.getText();
		String studentName1 = textstudentname.getText();
		String korText = textkorean.getText();
		String engText = textenglish.getText();
		String mathText = textmath.getText();

		if (classYearText.isBlank() || studentName1.isBlank() || korText.isBlank() || engText.isBlank()
				|| mathText.isBlank()) {
			// 에러 처리: 입력 필드 중 하나 이상이 비어 있음
			JOptionPane.showMessageDialog(frame, "모든 입력 필드를 채워주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			return; // 에러가 발생했으므로 더 이상 진행하지 않고 메서드를 종료합니다.
		}

		try {
			int studentnumber = Integer.parseInt(stuidLabel.getText());

			String studentname = textstudentname.getText();
			int classyear = Integer.parseInt(textclassyear.getText());
			int kor = Integer.parseInt(textkorean.getText());
			int eng = Integer.parseInt(textenglish.getText());
			int math = Integer.parseInt(textmath.getText());

			GradeVO vo = new GradeVO(0, studentname, classyear, kor, eng, math);

			int result = dao.update(studentnumber, vo);

			if (result == 1) {
				// 업데이트가 성공했을 경우에 대한 처리
				JOptionPane.showMessageDialog(frame, "학생 정보가 성공적으로 수정되었습니다.");
				// 필요한 경우 추가적인 작업 수행
              }

		} catch (NumberFormatException e) {
			// 숫자로 변환할 수 없는 경우 에러 처리
			JOptionPane.showMessageDialog(frame, "이름을 제외한 모든 필드를 숫자로 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
		} 
	}

}