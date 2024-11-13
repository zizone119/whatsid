import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientEx {

	Socket socket;

	final String IP = "192.168.0.90";
	final int PORT = 9000;
	BufferedReader reader;
	BufferedWriter writer;

	public ClientEx() {
		initData();
	}

	private void initData() {
		while(true) {
			try {
				socket = new Socket(IP, PORT);
				reader = new BufferedReader(new InputStreamReader(System.in));
				String input = reader.readLine();
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer.write(input);
				writer.newLine();//문장의 끝을 알려주어야 함
				writer.flush();
				
			} catch (Exception e) {
				System.out.println("서버가 응답하지 않습니다.");
			}
		}
	}

	public static void main(String[] args) {
		new ClientEx();
	}

}
