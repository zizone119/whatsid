public class GradeVO {
	// 멤버 변수
	private int studentId; // 학생 번호
	private String studentName; // 학생 이름
	private int classyear; // 학년 정보
	private int kor; // 국어 점수
	private int eng; // 영어 점수
	private int math; // 수학 점수
	private double avg; // 평균 점수
	private int rank; // 학생 등수

	// 기본 생성자
	public GradeVO() {
		super();
	}

	// 매개 변수 생성자
	public GradeVO(int studentId, String studentName, int classyear, int kor, int eng, int math) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.classyear = classyear;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		Double Avg = (kor + eng + math) / 3.0; // 실수로 나누어 평균 계산
		this.avg = Avg;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getClassYear() {
		return classyear;
	}

	public void setClassYear(int classyear) {
		this.classyear = classyear;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "GradeVO [studentId=" + studentId + ", studentName=" + studentName + ", classyear=" + classyear
				+ ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg=" + avg + ", rank =" + rank + "]";
	}
}