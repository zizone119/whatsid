public class TeacherVO {
	// 멤버 변수
	private String teacherid; // TEACHERID varchar2(20) pk
	private String pw; // PW VARCHAR2(20)
    private String name; // Name varchar2(20)
    private String subject; // subject varchar2(20)
    private String email; // EMAIL varchar2(20)
    
	// 기본 생성자
    public TeacherVO() {
    }


	// 매개 변수 생성자
    public TeacherVO(String teacherid, String pw, String name, String subject, String email) {
    	super();
    	this.teacherid = teacherid;
    	this.pw = pw;
    	this.name = name;
    	this.subject = subject;
    	this.email = email;
    }

   //getter/setter
	public String getteacherId() {
		return teacherid;
	}


	public void setteacherId(String teacherid) {
		this.teacherid = teacherid;
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
	
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
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
		return "TeacherVO [teacherid=" + teacherid + ", pw=" + pw + ", name=" + name + ", subject=" + subject
				+ ", email=" + email + "]";
	}
}