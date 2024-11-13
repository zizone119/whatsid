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

public class GradeMainFrame {

	JFrame frame;
	private JTextField textstudentid, textstudentname, textclassyear, textkorean, textenglish, textmath;
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
	public static void main(String[] args) {
		try {
			dao = GradeDAOImple.getInstance();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public GradeMainFrame() {
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

		JLabel lblstudentid = new JLabel("학번");
		lblstudentid.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentid.setBounds(12, 10, 38, 34);
		frame.getContentPane().add(lblstudentid);

		JLabel lblstudentname = new JLabel("이름");
		lblstudentname.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentname.setBounds(12, 96, 38, 34);
		frame.getContentPane().add(lblstudentname);

		JLabel lblkorean = new JLabel("국어");
		lblkorean.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblkorean.setBounds(12, 140, 38, 34);
		frame.getContentPane().add(lblkorean);

		JLabel lblenglish = new JLabel("영어");
		lblenglish.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblenglish.setBounds(12, 184, 38, 34);
		frame.getContentPane().add(lblenglish);

		JLabel lblmath = new JLabel("수학");
		lblmath.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblmath.setBounds(12, 228, 38, 34);
		frame.getContentPane().add(lblmath);

		textstudentid = new JTextField();
		textstudentid.setFont(new Font("굴림", Font.PLAIN, 18));
		textstudentid.setColumns(10);
		textstudentid.setBounds(73, 10, 217, 34);
		frame.getContentPane().add(textstudentid);

		textclassyear = new JTextField();
		textclassyear.setFont(new Font("굴림", Font.PLAIN, 18));
		textclassyear.setColumns(10);
		textclassyear.setBounds(73, 54, 217, 34);
		frame.getContentPane().add(textclassyear);

		textstudentname = new JTextField();
		textstudentname.setFont(new Font("굴림", Font.PLAIN, 18));
		textstudentname.setColumns(10);
		textstudentname.setBounds(73, 98, 217, 34);
		frame.getContentPane().add(textstudentname);

		textkorean = new JTextField();
		textkorean.setFont(new Font("굴림", Font.PLAIN, 18));
		textkorean.setColumns(10);
		textkorean.setBounds(73, 142, 217, 34);
		frame.getContentPane().add(textkorean);

		textenglish = new JTextField();
		textenglish.setFont(new Font("굴림", Font.PLAIN, 18));
		textenglish.setColumns(10);
		textenglish.setBounds(73, 186, 217, 34);
		frame.getContentPane().add(textenglish);

		textmath = new JTextField();
		textmath.setFont(new Font("굴림", Font.PLAIN, 18));
		textmath.setColumns(10);
		textmath.setBounds(73, 230, 217, 34);
		frame.getContentPane().add(textmath);

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertGrade();
				selectAllGradeTable();
				textstudentid.setText("");
				textclassyear.setText("");
				textstudentname.setText("");
				textkorean.setText("");
				textenglish.setText("");
				textmath.setText("");

			}
		});
		btnInsert.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnInsert.setBounds(0, 336, 110, 34);
		frame.getContentPane().add(btnInsert);

		JButton btnselect = new JButton("전체 검색");
		btnselect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllGradeTable(); // table에 보여지기 위해
			}
		});
		btnselect.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnselect.setBounds(111, 336, 110, 34);
		frame.getContentPane().add(btnselect);

		JButton btnselectstudentid = new JButton("학번검색");
		btnselectstudentid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String studentid = txtAreaLog_1.getText();
				// textAreaLog_1에 있는 텍스트를 문자열 studentid로 받아줌
				int Studentid = Integer.parseInt(studentid);
				// String studentid를 정수로 바꿔주고 Stdentid라는 새로운 int Studentid로 받아줌
				// studentid로 받으면 위에 이미 string으로 받은 것이 있으니 에러가 뜸
				ArrayList<GradeVO> list = dao.select();

				if (list.isEmpty()) {
					System.out.println("학생 정보가 없습니다.");
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
		btnselectstudentid.setBounds(220, 336, 110, 34);
		frame.getContentPane().add(btnselectstudentid);

		
		JButton btndelete = new JButton("삭제");
		btndelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteGrade();
				txtAreaLog_1.setText("");
			}
		});
		btndelete.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btndelete.setBounds(441, 336, 110, 34);
		frame.getContentPane().add(btndelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(302, 10, 490, 312);
		frame.getContentPane().add(scrollPane);

		JLabel lblclassyear = new JLabel("학년");
		lblclassyear.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblclassyear.setBounds(12, 52, 38, 34);
		frame.getContentPane().add(lblclassyear);

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
				Object value = table.getValueAt(row, 0); // row 열(가로), col 행(세로) col을 0으로 만들어줘서 다른 곳을 눌러도 학번만 뜨도록 설정
				System.out.println(value); // value값이 테이블 정보
				GradeUpdateClickFrame studentid = new GradeUpdateClickFrame(value.toString()); // GradeUpdateClickframe 창을 보여지게 하는 것
				// 새로운 객체를 만들어줘서 GradeUpdateClickframe에서 studentid라는 객체를 쓸 수 있게 함
				studentid.setVisible(true); // 그리고 studentid의 값이 보여지도록 설정 창을 보여지게 하는 것
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));

		scrollPane.setViewportView(table);

		JLabel lblstudentid_1 = new JLabel("학번검색");
		lblstudentid_1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblstudentid_1.setBounds(12, 288, 76, 34);
		frame.getContentPane().add(lblstudentid_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(93, 288, 180, 34);
		frame.getContentPane().add(scrollPane_1);
		
				txtAreaLog_1 = new JTextArea();
				scrollPane_1.setViewportView(txtAreaLog_1);
				txtAreaLog_1.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						txtAreaLog_1.setText(""); // 텍스트 설정
					}
				});
				
						txtAreaLog_1.setText("학번입력");
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

	protected void insertGrade() {
		// 학번, 학년, 이름, 국어, 영어, 수학 값을 가져옵니다.
		int studentid = Integer.parseInt(textstudentid.getText());
		int classYear = Integer.parseInt(textclassyear.getText());
		String studentName = textstudentname.getText();
		int kor = Integer.parseInt(textkorean.getText());
		int eng = Integer.parseInt(textenglish.getText());
		int math = Integer.parseInt(textmath.getText());

		// GradeVO 객체를 생성하여 값을 설정합니다.
		GradeVO vo = new GradeVO();
		vo.setStudentId(studentid);
		vo.setClassYear(classYear);
		vo.setStudentName(studentName);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMath(math);

		// DAO를 통해 등록합니다.
		dao.insert(vo);
	}

	protected void selectGradeTable(int studentid) {
		// DAO를 통해 모든 학생의 성적 정보를 가져옵니다.
		ArrayList<GradeVO> list = dao.select();

		// 학생의 평균 점수를 기준으로 내림차순으로 정렬합니다.
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

	protected void updateGrade() {
// size 필요없이 그냥 db로 하면 됨
		int studentnumber = Integer.parseInt(txtAreaLog_1.getText());

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
		} else if (result == 0) {
			// 업데이트가 실패했을 경우에 대한 처리 
			JOptionPane.showMessageDialog(frame, "학생 정보 수정에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			// 필요한 경우 실패에 대한 처리 수행

		} else {
			// index가 범위를 벗어날 때의 처리
			JOptionPane.showMessageDialog(frame, "학번이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);

		}
	}

	protected void deleteGrade() {
		int index;
		try {
			index = Integer.parseInt(txtAreaLog_1.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "학번을 정확히 입력하세요.");
			return;
		}

		int result = dao.delete(index);
		if (result == 1) {
			JOptionPane.showMessageDialog(frame, "학생 성적 삭제 완료!");
		} else if (result == 0) {
			// 업데이트가 실패했을 경우에 대한 처리
			JOptionPane.showMessageDialog(frame, "학생 성적 삭제에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			// 필요한 경우 실패에 대한 처리 수행

		} else {
			// index가 범위를 벗어날 때의 처리
			JOptionPane.showMessageDialog(frame, "학번이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
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