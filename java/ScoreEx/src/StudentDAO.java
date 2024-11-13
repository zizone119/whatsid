import java.util.ArrayList;


// * 인터페이스 DAO 메소드 설계 방식
// - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
// - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
// - 함수의 이름 : 역할에 따라 이름 작성

public interface StudentDAO {
 
	// 학생 정보 등록
    public abstract int insert(StudentVO vo);
      
    public abstract boolean login(String id, String pw);
    
    public abstract StudentVO select(String email);
    
    public abstract int update(String email, StudentVO vo);
    
    public abstract int delete(String email);
}