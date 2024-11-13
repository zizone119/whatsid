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
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TeacherLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId, txtPw, txtSubject ;
	private JFrame frame;
	private DefaultTableModel tableModel;

	private TeacherDAO dao;
	
	public TeacherLoginFrame() {
		frame = this;
		dao = TeacherDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 297, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(125, 10, 144, 33);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setColumns(10);
		txtPw.setBounds(125, 53, 144, 33);
		contentPane.add(txtPw);
		
		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(125, 96, 144, 33);
		contentPane.add(txtSubject);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 14, 101, 24);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(12, 53, 101, 24);
		contentPane.add(lblPw);
		
		JLabel lblsubject = new JLabel("과목");
		lblsubject.setBounds(12, 96, 101, 24);
		contentPane.add(lblsubject);
		
		JButton btnIogin = new JButton("로그인");
		btnIogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id1 = txtId.getText();
				String pw1 = txtPw.getText();
				String subject1 = txtSubject.getText();

				if (id1.isBlank() || pw1.isBlank() || subject1.isBlank()) {
					JOptionPane.showMessageDialog(frame, "ID, PW, 과목을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					return; // 에러가 발생했으므로 더 이상 진행하지 않고 메서드를 종료합니다
				}
				
				
				// 사용자가 입력한 ID와 비밀번호 가져오기
				String id = txtId.getText();
				String pw = txtPw.getText();
				String subject = txtSubject.getText();

				// DAO를 통해 로그인 처리
				TeacherDAO dao = TeacherDAOImple.getInstance();
				boolean loggIn = dao.teacherlogin(id, pw, subject);

				if (loggIn) {
					// 로그인 성공 시 처리
					GradeMainFrame gradeMainFrame = new GradeMainFrame();
					gradeMainFrame.frame.setVisible(true);
					frame.setVisible(false); // 현재 창을 숨깁니다.
				} else {
					// 로그인 실패 시 처리
					// 예: 경고 메시지 표시
					JOptionPane.showMessageDialog(frame, "아이디 또는 비밀번호가 일치하지 않습니다.", "로그인 실패",
					JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIogin.setBounds(12, 271, 119, 45);
		contentPane.add(btnIogin);
		
		JButton btnInsert = new JButton("회원가입");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherInsertFrame teacherinsertFrame = new TeacherInsertFrame();
				teacherinsertFrame.setVisible(true);	
			
			}
		});
		btnInsert.setBounds(100, 271, 119, 45);
		contentPane.add(btnInsert);
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Loginframe 창을 생성하고 보이도록 설정합니다.
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.frame.setVisible(true);

				// 현재 창을 숨깁니다.
				frame.setVisible(false);
			}
		});
		btnInsert.setBounds(150, 271, 119, 45);
		contentPane.add(btnLogout);
	}
	
}