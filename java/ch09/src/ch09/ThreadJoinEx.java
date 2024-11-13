package ch09;

class MyThread2 extends Thread{
	@Override
	public void run() {
		super.run();
		for(int i=0;i<5;i++) {
			System.out.println("myThread2 : "+i);
			try {
				sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class ThreadJoinEx {

	public static void main(String[] args) {
		MyThread2 t2 = new MyThread2();
		t2.start();
		System.out.println("스레드 종료까지 대기");
		try {
			t2.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("스레드 종료");
	}

}
