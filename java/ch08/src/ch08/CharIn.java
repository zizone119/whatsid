package ch08;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharIn {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println("input name");
		String g= s.next();
		FileReader fr = new FileReader(g);
		int i;
		while((i=fr.read())!=-1) {
			System.out.print((char)i);
		}
		fr.close();
	}

}
