import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	JFrame frame;
	private JTextField textId, textPw;

	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE); // 배경색 설정
		frame.setBounds(100, 100, 578, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("성적 관리 프로그램");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 10, 266, 66);
		frame.getContentPane().add(lblNewLabel);

		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.PLAIN, 34));
		textId.setColumns(10);
		textId.setBounds(136, 194, 318, 55);
		frame.getContentPane().add(textId);

		textPw = new JTextField();
		textPw.setFont(new Font("굴림", Font.PLAIN, 34));
		textPw.setColumns(10);
		textPw.setBounds(136, 261, 318, 55);
		frame.getContentPane().add(textPw);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.PLAIN, 44));
		lblId.setBounds(12, 194, 107, 55);
		frame.getContentPane().add(lblId);

		JLabel lblpw = new JLabel("PW");
		lblpw.setFont(new Font("굴림", Font.PLAIN, 44));
		lblpw.setBounds(12, 261, 78, 55);
		frame.getContentPane().add(lblpw);

		JButton btnstudentjoin = new JButton("회원가입");
		btnstudentjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInsertFrame insertFrame = new StudentInsertFrame();
				insertFrame.setVisible(true);
			}
		});
		btnstudentjoin.setFont(new Font("굴림", Font.PLAIN, 24));
		btnstudentjoin.setBounds(193, 395, 211, 46);
		btnstudentjoin.setBackground(new Color(30, 144, 255)); // 버튼 색상 설정
		btnstudentjoin.setForeground(Color.BLACK); // 버튼 글자색 설정
		frame.getContentPane().add(btnstudentjoin);

		JButton btnStudentLogin = new JButton("학생용로그인");
		btnStudentLogin.setFont(new Font("굴림", Font.PLAIN, 14));
		btnStudentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id1 = textId.getText();
				String pw1 = textPw.getText();

				if (id1.isBlank() || pw1.isBlank()) {
					JOptionPane.showMessageDialog(frame, "ID와 PW을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					return; // 에러가 발생했으므로 더 이상 진행하지 않고 메서드를 종료합니다
				}

				// 사용자가 입력한 ID와 비밀번호 가져오기
				String id = textId.getText();
				String pw = textPw.getText();

				// DAO를 통해 로그인 처리
				StudentDAO dao = StudentDAOImple.getInstance(); // dao의 하나의 몸체를 만들어줌
				boolean loggIn = dao.login(id, pw); // 그리고 dao 안에 login이라는 메소드에 id, pw를 담아줌

				if (loggIn) {
					// 로그인 성공 시 처리
					StudentGradeFrame studentGradeFrame = new StudentGradeFrame();
					studentGradeFrame.frame.setVisible(true);
					frame.setVisible(false); // 현재 창을 숨깁니다.
				} else {
					// 로그인 실패 시 처리
					// 예: 경고 메시지 표시
					JOptionPane.showMessageDialog(frame, "아이디 또는 비밀번호가 일치하지 않습니다.", "로그인 실패",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnStudentLogin.setBounds(278, 23, 121, 34);
		btnStudentLogin.setBackground(new Color(30, 144, 255)); // 버튼 색상 설정
		btnStudentLogin.setForeground(Color.BLACK); // 버튼 글자색 설정
		frame.getContentPane().add(btnStudentLogin);

		JButton btnTeacherLogin = new JButton("교사용로그인");
		btnTeacherLogin.setFont(new Font("굴림", Font.PLAIN, 14));
		btnTeacherLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLoginFrame teacherloginFrame = new TeacherLoginFrame();
				teacherloginFrame.setVisible(true);
				frame.setVisible(false); // 현재 창을 숨깁니다.
			}
		});
		btnTeacherLogin.setBounds(411, 23, 121, 34);
		btnTeacherLogin.setBackground(new Color(30, 144, 255)); // 버튼 색상 설정
		btnTeacherLogin.setForeground(Color.BLACK); // 버튼 글자색 설정

		frame.getContentPane().add(btnTeacherLogin);
	}
}