package ch08;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferdIO {

	public static void main(String[] args) throws IOException {
		FileReader fin = new FileReader("test.txt");
		int c;
		BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
		while((c=fin.read())!=-1) {
			out.write(c);
		}
		new Scanner(System.in).nextLine();
		out.flush();
		fin.close();
		out.close();
	}
}
