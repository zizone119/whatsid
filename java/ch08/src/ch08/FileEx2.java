package ch08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileEx2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("input name");
		String s = sc.next();
		FileOutputStream fos= new FileOutputStream(s);
		for(int i=1;i<260;i++) {
			fos.write(i);
		}
		fos.close();
		System.out.println(s);
	}
}
