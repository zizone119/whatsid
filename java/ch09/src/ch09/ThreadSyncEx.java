package ch09;

public class ThreadSyncEx {

	public static void main(String[] args) {
		Runnable thread = new CreateThead();
		Thread t1= new Thread(thread);
		Thread t2= new Thread(thread);
		t1.setName("스레드 1");
		t2.setName("스레드 2");
		t1.start();
		t2.start();
	}
}

class Money{
	private int myMoney = 10000;
	public int getMyMoney() {
		return myMoney;
	}
	public synchronized boolean withdraw(int money) {
		if(myMoney>=money) {
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			myMoney-=money;
			return true;
		}
		else return false;
	}
}

class CreateThead implements Runnable{
	
	Money myMoney = new Money();
	@Override
	public void run() {
		while(myMoney.getMyMoney()>0) {
			int money = (int)(Math.random()*5+1)*1000;
			boolean denied = !myMoney.withdraw(money);
			if(denied) {
				System.out.printf("%s %d 출금 거부",Thread.currentThread().getName(),money);
			}else {
				System.out.printf("스레드 : %s 출금 : %d원 남은 금액: %d원\n",Thread.currentThread().getName(),money,myMoney.getMyMoney());
			}
		}
	}
	
}