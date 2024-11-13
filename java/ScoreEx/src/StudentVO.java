// 데이터 클래스
public class StudentVO {
	// 멤버 변수
	private String id; // ID varchar2(20) pk
	private String pw; // PW VARCHAR2(20)
	private String name; // Name varchar2(20)
	private int classyear; // ClASSYEAR number(20)
	private String email; // EMAIL varchar2(20)

	// 기본 생성자
	public StudentVO() {
	}

	// 매개 변수 생성자
	public StudentVO(String id, String pw, String name, int classyear, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.classyear = classyear;
		this.email = email;
	}
    
	// getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassyear() {
		return classyear;
	}

	public void setClassyear(int classyear) {
		this.classyear = classyear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString()
	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", " + "pw=" + pw + ", " + "name=" + name + ", " + "classyear=" + classyear + ","
				+ " email=" + email + "]";
	}

}