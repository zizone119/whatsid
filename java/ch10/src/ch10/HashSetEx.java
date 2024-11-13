package ch10;

import java.util.Collections;
import java.util.HashSet;

public class HashSetEx {

	public static void main(String[] args) {
		HashSet<Integer> odd = new HashSet<Integer>();
		HashSet<Integer> even = new HashSet<Integer>();
		for(int i=1;i<=5;i+=2) {
			odd.add(i);
			even.add(i+1);
		}
		boolean setChanged = odd.add(5);
		System.out.println(setChanged);
		setChanged=even.add(12);
		System.out.println(setChanged);
		System.out.println(odd);
		System.out.println(even);
		System.out.println(Collections.min(odd));
		System.out.println(Collections.max(even));
	}

}
