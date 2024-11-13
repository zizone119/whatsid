import java.util.ArrayList;


// * 인터페이스 DAO 메소드 설계 방식
// - 함수의 리턴타입 : 돌려주는 데이터 형태에 따라 선언
// - 함수의 매개변수 : 전송되는 데이터 형태에 따라 선언
// - 함수의 이름 : 역할에 따라 이름 작성

public interface GradeDAO {
 
    // 교사는 모든 기능 사용 가능
    // 성적 입력 (teacher id) 교사만 학생 성적 등록 가능
    public abstract int insert(GradeVO vo);

    // 성적 전체 리스트 검색 (teacher id), 교사만 전체 리스트 검색 가능
    public abstract ArrayList<GradeVO> select();

    // 학생은 성적 정보 인덱스 검색만 가능
    public abstract GradeVO select(int studentId);

    // 성적 정보 인덱스 수정 (teacher id)교사만 학생의 정보 수정 가능
    public abstract int update(int studentId, GradeVO vo);

    // 성적 정보 인덱스 삭제 (teacher id)교사만 학생의 정보 삭제 가능
    public abstract int delete(int studentId);
}