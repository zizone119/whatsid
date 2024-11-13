package ch09;

class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("save");
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			save();
		}
	}
}

public class DemonEx {

	public static void main(String[] args) {
		AutoSaveThread a = new AutoSaveThread();
		a.setDaemon(true);
		a.start();		
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("end");
	}

}
