import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx2 {

	ServerSocket serverSocket;
	Socket socket;

	BufferedReader reader;
	BufferedWriter writer;

	BufferedReader keyboardReader;

	public ServerEx2() {
		initData();
	}

	private void initData() {
		try {
			serverSocket = new ServerSocket(9001);
			socket = serverSocket.accept();
			System.out.println("클라이언트가 접속하였습니다.");
			
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			keyboardReader = new BufferedReader(new InputStreamReader(System.in));
			
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			WriterThread person = new WriterThread();
			Thread th = new Thread(person);
			th.start();
			while(true) {
				String msg = "클라이언트 >> " + reader.readLine()+"\n";
				System.out.println(msg);
			}
 			
		}catch (Exception e) {
			
		}finally {
			try {
				reader.close();
				writer.close();
				keyboardReader.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

	class WriterThread implements Runnable{

		@Override
		public void run() {
			while(true) {
				try {
					String serverMsg = "서버 : " + keyboardReader.readLine();
					System.out.println("서버가 작성한 문구 확인 " + serverMsg);
					writer.write(serverMsg + "\n");
					writer.flush();
					
				}catch (Exception e) {

				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ServerEx2();
	}

}
