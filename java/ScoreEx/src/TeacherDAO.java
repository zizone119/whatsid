import java.util.ArrayList;

public interface TeacherDAO {
	public abstract int insert(TeacherVO vo);
	public abstract boolean teacherlogin(String id, String pw, String subject);
	public abstract ArrayList<TeacherVO> select();
	public abstract TeacherVO selectteacher(String email);
	public abstract int updateteacher(String email, TeacherVO vo);
	public abstract int deleteteacher(String email);
	
}
