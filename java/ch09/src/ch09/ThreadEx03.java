package ch09;
class BBB implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("재미있는 자바 "+i);
		}
	}
	
}
public class ThreadEx03 {

	public static void main(String[] args) {
		BBB b = new BBB();
		Thread t = new Thread(b);
		t.run();
	}

}
