package ch04;

class AAA1{
	public int a;
	public String toString() {
		return "재정의한 AAA1";
	}
}

public class Sample3 {

	public static void main(String[] args) {
		AAA1 a = new AAA1();
		System.out.println(a);
		System.out.println(a.toString());
	}

}
