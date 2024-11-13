import javax.swing.JOptionPane;

// 어디서든 갖고 갈수 있는 공용 변수가 됨
// JDBC에서 DB 접속에 사용될 상수들, SQL 문장들 정의
//Oracle DB 정보 인터페이스. DB 연결을 위한 상수. 사용자 정보
//테이블 및 컬럼 정보. 쿼리 작성
public interface OracleStudentQuery {
		
	public static final String TABLE_NAME = "STUDENT";
	public static final String COL_ID = "ID";
	public static final String COL_PW = "PW";
	public static final String COL_NAME = "NAME";
	public static final String COL_CLASS_YEAR = "CLASS_YEAR";
	public static final String COL_EMAIL = "EMAIL";

	// 회원 정보 등록
	public static final String SQL_INSERT = 
	         "INSERT INTO " + TABLE_NAME 
	         + " VALUES (?, ?, ?, ?, ?)";

     // 회원 로그인

    public static final String SQL_LOGIN = 
    		"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + " = ? AND " + COL_PW + " = ?"; 
    
    // 회원 정보 전체 검색
    public static final String SQL_SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_ID;
    
    
    // 회원 정보 상세(이메일) 검색
    // SELECT * FROM USERTABLE WHERE ID = ?
    public static final String SQL_SELECT_BY_EMAIL=
            "SELECT * FROM " + TABLE_NAME +
                    " WHERE " + COL_EMAIL + " = ?";
                  

    // 회원 정보 수정
    // UPDATE USER
    public static final String SQL_UPDATE =
            "UPDATE " + TABLE_NAME +
            " SET " + COL_ID + " = ?, " +
                      COL_PW + " = ?, " +
                      COL_NAME + " = ?, " +
                      COL_CLASS_YEAR + " = ? " +
                      "WHERE " + COL_EMAIL + " = ?";

    // 학생 성적 삭제
    // DELETE GRADE WHERE GRADE_ID = ?
    public static final String SQL_DELETE =
            "DELETE " + TABLE_NAME + " WHERE " +
            		COL_EMAIL + " = ?";

}