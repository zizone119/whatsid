import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientEx2 {

	Socket socket;
	final String IP = "192.168.0.90";
	final int PORT = 9001;

	BufferedReader keyboardReader;
	BufferedWriter writer;
	BufferedReader socketReader;

	public ClientEx2() {
		initData();
	}

	private void initData() {
		System.out.println("클라이언트에서 서버 접속 요청");
		try {
			socket = new Socket(IP,PORT);
			keyboardReader = new BufferedReader(new InputStreamReader(System.in));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			new Thread(new ReadThread()).start();
			
			while(true) {
				System.out.println("키보드 입력 대기");
				String input = keyboardReader.readLine();
				writer.write(input);
				writer.newLine();
				writer.flush();
			}
			
		}catch (Exception e) {
			
		}finally {
			try {
				keyboardReader.close();
				writer.close();
				socketReader.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	class ReadThread implements Runnable{

		@Override
		public void run() {
			while(true) {
				try {
					String serverMsg = socketReader.readLine();
					System.out.println("서버 >> " + serverMsg);
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
	}

	public static void main(String[] args) {
		new ClientEx2();
	}

}
