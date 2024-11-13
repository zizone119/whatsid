import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress ib[] = InetAddress.getAllByName("www.naver.com");
		for(int i=0;i<ib.length;i++) {
			System.out.println(ib[i]);
		}
	}
}
