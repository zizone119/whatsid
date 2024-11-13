package ch10;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<4;i++) {
			System.out.print("이름을 입력하세요.");
			String s = sc.next();
			a.add(s);
		}
		for(int i=0;i<a.size();i++) System.out.print(a.get(i)+" ");
		int longestIdx=0;
		for(int i=0;i<a.size();i++) {
			if(a.get(longestIdx).length()<a.get(i).length()) longestIdx=i;
		}
		System.out.println("\n가장 이름이 긴 사람은 "+a.get(longestIdx));
	}

}
