import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class StudentGradeFrame {

	JFrame frame;
	private JTextArea txtAreaLog_1;
	private static GradeDAO dao;
	private Component currentComponent;
	
	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
	private JTable table;
	private String[] colNames = { "학번", "학년", "이름", "국어", "수학", "영어", "평균", "석차" }; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public StudentGradeFrame() {
		try {
			dao = GradeDAOImple.getInstance();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnselectstudentid = new JButton("학번검색");
		btnselectstudentid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String TxtAreaLog_1 = txtAreaLog_1.getText();

				if (TxtAreaLog_1.isBlank() || TxtAreaLog_1.equals("학번입력")) {
					JOptionPane.showMessageDialog(frame, "학번을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					return; // 에러가 발생했으므로 더 이상 진행하지 않고 메서드를 종료합니다.

				}
				
				String studentid = txtAreaLog_1.getText();
				// textAreaLog_1에 있는 텍스트를 문자열 studentid로 받아줌
				int Studentid;
				try {
					Studentid = Integer.parseInt(studentid);
				} catch (NumberFormatException e1) {
					return;
				}
				// String studentid를 정수로 바꿔주고 Stdentid라는 새로운 int Studentid로 받아줌
				// studentid로 받으면 위에 이미 string으로 받은 것이 있으니 에러가 뜸
				ArrayList<GradeVO> list = dao.select();
				
			
				if (list.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "학생 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
					// 학생 정보가 없는 경우, 해당 문구를 출력하고 테이블에 아무것도 표시하지 않도록 처리
					tableModel.setRowCount(0); // 테이블 초기화
				} else {
					System.out.println("학생 정보가 있습니다.");
					// 학생 정보가 있는 경우, 해당 문구를 출력하고 테이블에 정보를 표시
					selectGradeTable(Studentid);
					// 마지막으로 int로 받은 Studentid 값을 GradeTable로 받아 보여지게 함
					// 테이블에 보여지게만 하면 되니 이거만 있으면 되고 만약 0을 넣으면
					// 모든 값이 영으로 나오게 된다
				}
				

			}
		});
		btnselectstudentid.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnselectstudentid.setBounds(96, 71, 110, 34);
		frame.getContentPane().add(btnselectstudentid);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(302, 10, 490, 312);
		frame.getContentPane().add(scrollPane);

		// 테이블 초기화
		tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));

		scrollPane.setViewportView(table);

		JLabel lblstudentid_1 = new JLabel("학번검색");
		lblstudentid_1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentid_1.setBounds(12, 10, 76, 34);
		frame.getContentPane().add(lblstudentid_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(96, 10, 180, 34);
		frame.getContentPane().add(scrollPane_1);
		
				txtAreaLog_1 = new JTextArea();
				scrollPane_1.setViewportView(txtAreaLog_1);
				txtAreaLog_1.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						txtAreaLog_1.setText(""); // 텍스트 설정
					}
				});
						txtAreaLog_1.setFont(new Font("굴림", Font.PLAIN, 17));
						txtAreaLog_1.setColumns(5);
		
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
		btnLogout.setBounds(685, 336, 107, 23);
		frame.getContentPane().add(btnLogout);

	} // end initialize()

	
	protected void selectGradeTable(int studentid) {
		ArrayList<GradeVO> list = dao.select();

	    list.sort(Comparator.comparingDouble(GradeVO::getAvg).reversed());

	    int studentRank = -1; // 학생의 등수를 초기화

	    // 등수를 설정하기 위해 순서대로 1부터 시작하여 증가
	    int rank = 1;
	    for (GradeVO vo : list) {
	        vo.setRank(rank++);
	        if (vo.getStudentId() == studentid) { // 학번으로 검색한 학생을 찾으면
	            studentRank = vo.getRank(); // 해당 학생의 등수를 가져옴
	            break;
	        }
	    }

	    // 학생의 등수가 -1이 아니라면 (학생을 찾은 경우)
	    if (studentRank != -1) {
	        // 테이블에 해당 학생 정보를 표시
	        tableModel.setRowCount(0); // 테이블 초기화
	        for (GradeVO vo : list) {
	            if (vo.getStudentId() == studentid) { // 검색한 학생의 정보만 추가
	                records[0] = vo.getStudentId();
	                records[1] = vo.getClassYear();
	                records[2] = vo.getStudentName();
	                records[3] = vo.getKor();
	                records[4] = vo.getEng();
	                records[5] = vo.getMath();
	                records[6] = vo.getAvg();
	                records[7] = vo.getRank();
	                tableModel.addRow(records);
	            }
	        }
	    } else {
	        // 학생 정보가 없는 경우, 테이블 초기화하여 아무것도 표시하지 않음
	        tableModel.setRowCount(0);
	        JOptionPane.showMessageDialog(frame, "학생 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
	    }
	}
	protected void selectAllGradeTable() {
		ArrayList<GradeVO> list = dao.select();

		if (list.isEmpty()) {
			JOptionPane.showMessageDialog(frame, "학생 정보가 없습니다", "오류", JOptionPane.ERROR_MESSAGE);
			tableModel.setRowCount(0); // 테이블 초기화
		} else {
			System.out.println("학생 정보가 있습니다.");

			// 등수를 계산하기 위해 리스트를 평균 점수를 기준으로 내림차순으로 정렬
			list.sort(Comparator.comparingDouble(GradeVO::getAvg).reversed());

			// 등수를 설정하기 위해 순서대로 1부터 시작하여 증가
			int rank = 1;
			for (GradeVO vo : list) {
				vo.setRank(rank++);
			}

			tableModel.setRowCount(0);

			// 테이블
			for (int i = 0; i < list.size(); i++) {
				GradeVO vo = list.get(i);
				records[0] = vo.getStudentId();
				records[1] = vo.getClassYear();
				records[2] = vo.getStudentName();
				records[3] = vo.getKor();
				records[4] = vo.getEng();
				records[5] = vo.getMath();
				records[6] = vo.getAvg();
				records[7] = vo.getRank(); // 등수도 표시
				tableModel.addRow(records);
			}

		}

	}// end selectAllGradeTable()
} // end GradeMainframe