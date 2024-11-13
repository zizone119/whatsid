import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//DAO(Data Access Object) :
//- 데이터의 전송을 담당하는 역할

public class GradeDAOImple implements GradeDAO {

	// 싱글톤 디자인 패턴 적용 // 객체를 생성할때마다 껍데기가 남는데 그 껍데기를 하나만 계속 쓰게 하는 것 메모리 아낌

	// 1. private static 자기 자신 타입의 변수 선언
	private static GradeDAOImple instance = null;

	private String URL= "jdbc:mysql://localhost:3306/haksa";
	private String USER = "root";
	private String PASSWORD = "1234";
	// 2. private 생성자
	private GradeDAOImple() { // 파일 필요없음

	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static GradeDAOImple getInstance() {
		if (instance == null) {
			instance = new GradeDAOImple();
		}
		return instance;
	}

	// 전체 검색 데이터 list에서 size를 리턴
	public int getSize() {
		return select().size();
	}

	@Override
	public int insert(GradeVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		// Statement와 상속 관계
		int result = 0;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			// 4. DB와 Conenction(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // 빼먹을 것을 찾아야함 라이브러리 추가를 해야함
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			String sql="insert into grade(student_id,student_name,class_year,korean,english,math,avg) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql); // 실행은 아니고 준비만 해놓은 상태

			// 파라미터는 함수에 전달되는 값들을 받는 변수들을 의미하고, 인덱스는 자료 구조에서 특정 요소의 위치를 가리키는 번호입니다.
			// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			// 삽입된 데이터를 기반으로 평균값 다시 계산

			double avg = (vo.getKor() + vo.getEng() + vo.getMath()) / 3.0;
			vo.setAvg(avg);

			pstmt.setInt(1, vo.getStudentId());
			pstmt.setString(2, vo.getStudentName());
			pstmt.setInt(3, vo.getClassYear());
			pstmt.setInt(4, vo.getKor());
			pstmt.setInt(5, vo.getEng());
			pstmt.setInt(6, vo.getMath());
			pstmt.setDouble(7, vo.getAvg());
			// SQL 쿼리의 ? 순서와 parameterIndex의 값을 동일하게 지정
			// 예시) ?가 첫 번째이면 parameterIndex = 1

			// setInt() : DB의 Number 타입
			// setString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입

			// 7. SQL 문장 실행(DB 서버로 SQL 전송)
			try {
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("id 중복");
			}

			// 8. DB 서버가 보낸 결과 확인/처리

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

	@Override
	public ArrayList<GradeVO> select() {
		
		// 반환할 ArrayList 생성
		ArrayList<GradeVO> list = new ArrayList<>(); 

		// Connection, PreparedStatement, ResultSet을 선언하여 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			String sql="select * from grade";
			pstmt = conn.prepareStatement(sql);

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();

			// 7. DB 서버가 보낸 결과 확인/처리
			// ResultSet.next() :
			// ResultSet에서 다음 행(row, record)이 있으면
			// true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경

			// ResultSet에서 결과를 반복하여 가져와서 GradeVO 객체를 생성하고 리스트에 추가
			while (rs.next()) { // 레코드가 존재할 때까지 // db에 있는 1 - student_name, 2 - studnet-named 그 값을 불러오는 것

				int studentid = rs.getInt(1);
				String studentname = rs.getString(2);
				int classyear = rs.getInt(3);
				int kor = rs.getInt(4);
				int eng = rs.getInt(5);
				int math = rs.getInt(6);
				double avg = rs.getDouble(7);

				GradeVO vo = new GradeVO(studentid, studentname, classyear, kor, eng, math);
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		 // 조회된 학생 정보가 담긴 리스트 반환
		return list;
	}

	@Override
	public GradeVO select(int studentId) {
		GradeVO vo = new GradeVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// DB 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. Connection 객체를 사용하여 Statement 객체를 생성
			String sql="select * from grade where student_id=?";
			pstmt = conn.prepareStatement(sql);

			// 6. SQL 문장 작성 ?가 하나이고 검색할 것만 하면 되니 하나만 있으면 됨
			pstmt.setInt(1, studentId);

			// SQL 문장 실행
			rs = pstmt.executeQuery();

			// 결과 처리
			if (rs.next()) {
				int studentid = rs.getInt(1);
				String studentname = rs.getString(2);
				int classyear = rs.getInt(3);
				int kor = rs.getInt(4);
				int eng = rs.getInt(5);
				int math = rs.getInt(6);

				vo = new GradeVO(studentid, studentname, classyear, kor, eng, math);
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
	public int update(int studentId, GradeVO vo) {
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
			String sql="update grade set student_name=?, class_year=?, korean=?, english=?,math=?, avg=? where student_id=?";
			pstmt = conn.prepareStatement(sql);

			// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			// 업데이트된 데이터를 기반으로 평균값 다시 계산
			// insert 메서드와 update 메서드에서 데이터를 데이터베이스에 삽입하거나 업데이트하기 전에
//			평균값을 다시 계산하고 GradeVO 객체에 설정합니다.
//			 그리고 쿼리 실행 전에 vo.getAvg()를 사용하여 계산된 평균값을 데이터베이스에 저장합니다.
			double avg = (vo.getKor() + vo.getEng() + vo.getMath()) / 3.0;
			vo.setAvg(avg);

			pstmt.setString(1, vo.getStudentName());
			pstmt.setInt(2, vo.getClassYear());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			pstmt.setDouble(6, vo.getAvg());
			pstmt.setInt(7, studentId);

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
	public int delete(int studentId) {
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
			String sql = "delete from grade where student_id=?";
			// 5. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(sql);

			// 6. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setInt(1, studentId);

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