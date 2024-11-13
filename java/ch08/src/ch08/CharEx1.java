package ch08;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharEx1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String source = "비어 있어야 비로소 가득해 지는 사랑 \n 영원히 \n 사랑해";
		System.out.println("input name");
		String in = sc.next();
		FileWriter fw = new FileWriter(in);
		fw.write(source);
		fw.close();
		System.out.println("created");
	}

}
