package ch10;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class StudentList {
	private String major;
	private int num;
	private double avg;

	public StudentList(String major, int num, double avg) {
		this.major = major;
		this.num = num;
		this.avg = avg;
	}

	public String getMajor() {
		return this.major;
	}

	public int getNum() {
		return this.num;
	}

	public double getAvg() {
		return this.avg;
	}
}

public class StudentHashMapEx {

	public static void main(String[] args) {
		HashMap<String, StudentList> hm = new HashMap<String, StudentList>();
		hm.put("황기태", new StudentList("모바일", 1, 4.1));
		hm.put("이재문", new StudentList("안드로이드", 2, 3.9));
		hm.put("김남윤", new StudentList("웹공학", 3, 4.25));
		hm.put("최찬미", new StudentList("빅데이터", 4, 3.5));

		Collection<String> c = hm.keySet();
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			String st = it.next();
			StudentList sl = hm.get(st);
			System.out.println(st + "," + sl.getMajor() + "," + sl.getNum() + "," + sl.getAvg());
		}

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("학생 이름 >> ");
			String name = sc.next();
			if (name.equals("그만"))
				break;
			StudentList sl = hm.get(name);
			if (sl == null)
				System.out.println(name + " 학생은 없습니다.");
			else
				System.out.println(name + "," + sl.getMajor() + "," + sl.getNum() + "," + sl.getAvg());
		}
	}

}
