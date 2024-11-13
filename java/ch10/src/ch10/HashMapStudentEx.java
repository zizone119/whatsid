package ch10;

import java.util.HashMap;
import java.util.Scanner;

class Student{
	private int id;
	private String tel;
	public Student(int id, String tel) {
		this.id=id;
		this.tel=tel;
	}
	public int getId() {
		return this.id;
	}
	public String getTel() {
		return this.tel;
	}
}


public class HashMapStudentEx {

	public static void main(String[] args) {
		HashMap<String, Student> map= new HashMap<String, Student>();
		map.put("aaa", new Student(1,"111"));
		map.put("bbb", new Student(2,"222"));
		map.put("ccc", new Student(3,"333"));
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("검색할 이름?");
			String name = scanner.nextLine();
			if(name.equals("exit")) break;
			Student student = map.get(name);
			if(student==null) System.out.println(name+"는 없는 사람입니다.");
			else System.out.println("id : "+student.getId()+", 전화 : "+student.getTel());
		}
		scanner.close();
	}

}
