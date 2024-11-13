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

public class TeacherInsertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId, txtPw, txtName, txtSubject, txtEmail;
	private JFrame frame;
	private DefaultTableModel tableModel;

	private TeacherDAO dao;
	private JButton btnFindid;
	private JLabel lblsubject_1;
	
	public TeacherInsertFrame() {
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
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(125, 96, 144, 33);
		contentPane.add(txtName);
		
		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(125, 139, 144, 33);
		contentPane.add(txtSubject);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(125, 182, 144, 33);
		contentPane.add(txtEmail);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 14, 101, 24);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(12, 53, 101, 24);
		contentPane.add(lblPw);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 96, 101, 24);
		contentPane.add(lblName);
		
		JLabel lblsubject = new JLabel("과목");
		lblsubject.setBounds(12, 139, 101, 24);
		contentPane.add(lblsubject);
		
		JButton btnInsert = new JButton("회원 등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertTeacher();
				
			}
		});
		btnInsert.setBounds(12, 263, 117, 38);
		contentPane.add(btnInsert);
		
		btnFindid = new JButton("ID 찾기");
		btnFindid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherIdFindFrame teacherIdFindFrame = new TeacherIdFindFrame();
				teacherIdFindFrame.frame.setVisible(true);

				// 현재 창을 숨깁니다.
				frame.setVisible(false);
			}
		});
		btnFindid.setBounds(157, 263, 112, 38);
		contentPane.add(btnFindid);
		
		lblsubject_1 = new JLabel("이메일");
		lblsubject_1.setBounds(12, 182, 101, 24);
		contentPane.add(lblsubject_1);
		
		
	}

	protected void insertTeacher() {
		
		String id1 = txtId.getText();

		String pw1 = txtPw.getText();

		String name1 = txtName.getText();
		
		String subject1 = txtSubject.getText();
		
		String email1 = txtEmail.getText();
		
		if (id1.isBlank() || pw1.isBlank() || name1.isBlank() || subject1.isBlank() || email1.isBlank()) {
			JOptionPane.showMessageDialog(frame, "모든 입력 필드를 채워주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			return; // 에러가 발생했으므로 더 이상 진행하지 않고 메서드를 종료합니다.
		}
		
		String id = txtId.getText();

		String pw = txtPw.getText();

		String name = txtName.getText();
		
		String subject = txtSubject.getText();
		
		String email = txtEmail.getText();

		// GradeVO 객체를 생성하여 값을 설정합니다.
		TeacherVO vo = new TeacherVO();
		vo.setteacherId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setSubject(subject);
		vo.setEmail(email);
        
		// DAO를 통해 등록합니다.
		int result = dao.insert(vo);

		// 회원 등록 완료 메시지를 띄웁니다.
		// 회원 등록 결과에 따라 메시지를 표시합니다.
		if (result == 1) {
			JOptionPane.showMessageDialog(frame, "회원 등록이 완료되었습니다.");
		} else {
			JOptionPane.showMessageDialog(frame, "id가 중복입니다. 다시 시도하세요.", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
}