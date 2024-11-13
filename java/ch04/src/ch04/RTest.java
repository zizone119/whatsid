package ch04;

import java.util.Scanner;

class R{
	String ra="라면";
	String wa="물";
	String on="양파";
	void bo() {
		System.out.println(wa+"을 끓인다");
	}
	void co() {
		System.out.println(ra+"과 "+on+"을 넣고 완성");
	}
}

class RR extends R{
	String to="떡";
	void top() {
		System.out.println(to+"를 넣는다");
	}
}

class CR extends R{
	String to="치즈";
	void top() {
		System.out.println(to+"를 넣는다");
	}
}

public class RTest {
	public static void main(String[] args) {
		int s=0;
		Scanner stdin= new Scanner(System.in);
		do {
			System.out.println("만들고 싶은 라면을 고르세요. 1:일반라면 2:떡라면 3:치즈라면 99:종료");
			s=stdin.nextInt();
			if(s==1) {
				R r = new R();
				r.bo();
				r.co();
			}
			if(s==2) {
				RR rr = new RR();
				rr.bo();
				rr.top();
				rr.co();
			}
			if(s==3) {
				CR cr = new CR();
				cr.bo();
				cr.top();
				cr.co();
			}
		}while(s!=99);
	}
}
