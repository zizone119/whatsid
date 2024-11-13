package ch10;

import java.util.HashMap;
import java.util.Scanner;

public class PopulatinoEX {

	public static void main(String[] args) {
		HashMap<String, Integer> popul = new HashMap<String, Integer>();
		System.out.println("나라 이름과 인구를 입력하세요.(예: kreaa 5000)");
		String nation = new String();
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			nation = sc.next();
			if(nation.equals("그만")) break;
			num = sc.nextInt();
			popul.put(nation, (Integer)num);
		}
		while(true) {
			System.out.print("인구 검색 >> ");
			nation = sc.next();
			if(nation.equals("그만")) break;
			if(popul.containsKey(nation)==false) {
				System.out.println(nation+" 나라는 없습니다.");
			}
			else System.out.println(nation+" 인구는 "+popul.get(nation));
		}
		
	}

}
