package ch10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {

	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("찾고싶은 단어는?");
			String eng = scanner.next();
			if(eng.equals("exit")) {
				System.out.println("종료합니다.");
			}
			String kor = dic.get(eng);
			if(kor==null) {
				System.out.println(eng+"는 없는 단어입니다.");
			}
			else System.out.println(kor);
		}
	}
}
