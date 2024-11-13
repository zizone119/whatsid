package ch09;

class AAA extends Thread{
	public AAA(String str) {
		setName(str);
	}
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(i + getName());
		}
		System.out.println("끝" + getName());
	}
}
public class ThreadEx02 {

	public static void main(String[] args) {
		AAA a = new AAA(" : 배우기 쉬운 자바");
		a.start();
		AAA b = new AAA(" : 배우기 어려운 자바");
		b.start();
		AAA c = new AAA(" : 할만한 자바");
		c.start();
	}

}
