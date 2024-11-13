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

public class StudentInsertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId, txtPw, txtName, txtClassyear, txtEmail;
	private JFrame frame;
	private DefaultTableModel tableModel;

	private StudentDAO dao;
	private JButton btnFindid;

	public StudentInsertFrame() {
		frame = this;
		dao = StudentDAOImple.getInstance();
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

		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 10, 101, 24);
		contentPane.add(lblId);

		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(12, 54, 101, 24);
		contentPane.add(lblPw);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 98, 101, 24);
		contentPane.add(lblName);

		JButton btnInsert = new JButton("회원 등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertStudent();

			}
		});
		btnInsert.setBounds(12, 263, 114, 38);
		contentPane.add(btnInsert);

		JLabel lblClassyear = new JLabel("학년");
		lblClassyear.setBounds(12, 143, 101, 24);
		contentPane.add(lblClassyear);

		txtClassyear = new JTextField();
		txtClassyear.setColumns(10);
		txtClassyear.setBounds(125, 139, 144, 33);
		contentPane.add(txtClassyear);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(12, 187, 101, 24);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(125, 182, 144, 33);
		contentPane.add(txtEmail);

		btnFindid = new JButton("ID 찾기");
		btnFindid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Loginframe 창을 생성하고 보이도록 설정합니다.
				StudentIdFindFrame studentIdFindFrame = new StudentIdFindFrame();
				studentIdFindFrame.frame.setVisible(true);

				// 현재 창을 숨깁니다.
				frame.setVisible(false);
			}
		});
		btnFindid.setBounds(155, 263, 114, 38);
		contentPane.add(btnFindid);
	}

	public void insertStudent() {

		String id1 = txtId.getText();

		String pw1 = txtPw.getText();

		String name1 = txtName.getText();

		String classyear1 = txtClassyear.getText();

		String email1 = txtEmail.getText();

		if (id1.isBlank() || pw1.isBlank() || name1.isBlank() || classyear1.isBlank() || email1.isBlank()) {
			// 에러 처리: 입력 필드 중 하나 이상이 비어 있음
			JOptionPane.showMessageDialog(frame, "모든 입력 필드를 채워주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			return; // 에러가 발생했으므로 더 이상 진행하지 않고 메서드를 종료합니다
		}

		try {
			String id = txtId.getText();

			String pw = txtPw.getText();

			String name = txtName.getText();

			int classyear = Integer.parseInt(txtClassyear.getText());

			String email = txtEmail.getText();

			// StudentVO 객체를 생성하여 값을 설정합니다.
			StudentVO vo = new StudentVO(); // 학생 정보를 담는 VO 객체를 생성
			vo.setId(id); // vo 객체에 아이디 설정
			vo.setPw(pw);
			vo.setName(name);
			vo.setClassyear(classyear);
			vo.setEmail(email);

			// DAO를 통해 등록합니다.
			int result = dao.insert(vo);

			// 회원 등록 완료 메시지를 띄웁니다.
			// 회원 등록 결과에 따라 메시지를 표시합니다.
			if (result == 1) { // 1 = 성공
				JOptionPane.showMessageDialog(frame, "회원 등록이 완료되었습니다.");
			} else { // 0 = 실패 또는 에러가 떴을때
				JOptionPane.showMessageDialog(frame, "id가 중복입니다. 다시 시도하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException e) {
			// 숫자로 변환할 수 없는 경우 에러 처리
			JOptionPane.showMessageDialog(frame, "학년을 제외한 모든 필드를 문자로 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
}