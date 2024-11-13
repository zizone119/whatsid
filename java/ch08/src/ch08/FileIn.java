package ch08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIn {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("input name");
		String s = sc.next();
		FileInputStream fis = new FileInputStream(s);
		int i;
		while((i=fis.read())!=-1) {
			System.out.print(i+" ");
		}
		fis.close();
		System.out.println("end");
	}

}
