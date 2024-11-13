import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDAOImple implements StudentDAO{

	// 싱글톤 디자인 패턴 적용

	// 1. private static 자기 자신 타입의 멤버 변수
	private static StudentDAOImple instance = null;

	private String URL= "jdbc:mysql://localhost:3306/haksa";
	private String USER = "root";
	private String PASSWORD = "1234";
	// 2. private 생성자
	private StudentDAOImple() {

	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static StudentDAOImple getInstance() {
		if (instance == null) {
			instance = new StudentDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		// Statement와 상속 관계
		int result = 0;
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Conenction(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // 빼먹을 것을 찾아야함 라이브러리 추가를 해야함
			System.out.println("DB 연결 성공");

			String sql="insert into student(id,pw,name,class_year,email) values(?,?,?,?,?)";
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(sql); // 실행은 아니고 준비만 해놓은 상태

			// 파라미터는 함수에 전달되는 값들을 받는 변수들을 의미하고, 인덱스는 자료 구조에서 특정 요소의 위치를 가리키는 번호입니다.
			// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getClassyear());
			pstmt.setString(5, vo.getEmail());
			// SQL 쿼리의 ? 순서와 parameterIndex의 값을 동일하게 지정
			// 예시) ?가 첫 번째이면 parameterIndex = 1

			// setInt() : DB의 Number 타입
			// setString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삽입됐습니다.");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result; // 0 : 실패, 1 : 성공 돌려준다면 조금더 유연한 프로그램이 만들어짐
	} // return result를 쓰려면 위치가 중요함

	// 로그인 메소드
	public boolean login(String id, String pw) {
		boolean loggedIn = false; // 로그인 상태를 나타내는 boolean 변수
									// 사용자가 로그인하지 않았기 때문에 false로 초기화
									// 로그인에 성공하면 true로 바뀜

		Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체
		PreparedStatement pstmt = null; // SQL 문을 실행하기 위한 PreparedStatement 객체
		ResultSet rs = null; // 쿼리 결과를 저장하기 위한 ResultSet 객체

		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			String sql="select * from student where id=? and pw=?";
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(sql);
			// SQL 문을 실행할 PreparedStatement 객체 생성 이미 생성함

			// 6. PreparedStatement 객체 생성 및 값 설정
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			// 7. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery(); // SQL 문을 실행하고 결과를 ResultSet에 저장
			loggedIn = rs.next(); // 결과가 있으면 로그인 성공
			boolean result = loggedIn;
			
			if (result == true ) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}
			

		} catch (Exception e) { // SQL 예외 처리
			e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
		} finally {
			try {
				// 8. 자원 해제
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) { // 자원 해제 중 예외 처리
				e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
			}
		}

		return loggedIn; // 로그인 상태를 반환
	}

	@Override
	public StudentVO select(String email) {
		StudentVO vo = new StudentVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			String sql="select * from student where email=?";
			// DB 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// 6. SQL 문장 작성 ?가 하나이고 검색할 것만 하면 되니 하나만 있으면 됨
			pstmt.setString(1, email); // 1은 물음표 개수
			// SQL 문장 실행
			rs = pstmt.executeQuery();

			// 결과 처리
			if (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int classyear = rs.getInt(4);
				String studentemail = rs.getString(5);
				vo = new StudentVO(id, pw, name, classyear, studentemail);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}

	@Override
	public int update(String email, StudentVO vo) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		// Statement와 상속 관계
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성

			System.out.println("정보 수정 중");
			String sql="update stuedent set id=?,pw=?,name=?,class_year=? where email=?";
			pstmt = conn.prepareStatement(sql);

			// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			// 업데이트된 데이터를 기반으로 평균값 다시 계산
			// insert 메서드와 update 메서드에서 데이터를 데이터베이스에 삽입하거나 업데이트하기 전에
//			평균값을 다시 계산하고 GradeVO 객체에 설정합니다.
//			 그리고 쿼리 실행 전에 vo.getAvg()를 사용하여 계산된 평균값을 데이터베이스에 저장합니다.

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getClassyear());
			pstmt.setString(5, email);
			
			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 수정됐습니다.");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result; // 그냥 변환이 되었는지 아닌지만 판단하기 때문에 성공했으면 1 아니면 0
	}

	@Override
	public int delete(String email) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
//		Statement와 상속 관계
		try {
			// 3. Oracle JDBC 드라이버를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// 4. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			String sql="delete from student where email=?";
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, email);

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();

			// 8. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삭제됐습니다.");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result; // 성공 : 1 , 실패 : 0
	}

}