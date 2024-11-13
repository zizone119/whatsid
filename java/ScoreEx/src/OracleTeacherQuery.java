public interface OracleTeacherQuery {
		
	public static final String TABLE_NAME = "TEACHER";
	public static final String COL_TEACHERID = "TEACHERID";
	public static final String COL_PW = "PW";
	public static final String COL_NAME = "NAME";
	public static final String COL_SUBJECT = "SUBJECT";
	public static final String COL_EMAIL = "EMAIL";

	// 회원 정보 등록
	public static final String SQL_INSERT = 
	         "INSERT INTO " + TABLE_NAME 
	         + " VALUES (?, ?, ?, ?, ?)";

    // - 회원 정보 전체 검색
	// SELECT * FROM USERTABLE;
     public static final String SQL_SELECT = 
	         "SELECT * FROM " + TABLE_NAME;

     // 회원 로그인
    public static final String SQL_TEACHER_LOGIN = 
    		"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_TEACHERID + " = ? AND " + COL_PW + " = ? AND " + COL_SUBJECT + " = ?"; 
    
    
    // 교사 정보 상세(과목) 검색
    // SELECT * FROM USERTABLE WHERE ID = ?
    public static final String SQL_SELECT_BY_EMAIL=
            "SELECT * FROM " + TABLE_NAME +
                    " WHERE " + COL_EMAIL + " = ?";
                  

    // 교사 정보 수정
    // UPDATE USER
    public static final String SQL_UPDATE =
            "UPDATE " + TABLE_NAME +
            " SET " + COL_TEACHERID + " = ?, " +
                      COL_PW + " = ?, " +
                      COL_NAME + " = ?, " +
                      COL_SUBJECT + " = ? " +
                      "WHERE " + COL_EMAIL + " = ?";

    // 교사 정보 삭제
    // DELETE GRADE WHERE GRADE_ID = ?
    public static final String SQL_DELETE =
            "DELETE " + TABLE_NAME + " WHERE " +
            		COL_EMAIL + " = ?";

}