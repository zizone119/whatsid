package ch09;

class AA extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("재미있는 자바 : "+i);
		}
	}
}

public class ThreadEx01 {

	public static void main(String[] args) {
		AA a = new AA();
		a.start();
	}

}
