package ch08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Phone {

	public static void main(String[] args) throws IOException {
		File dest = new File("phone.txt");
		FileWriter fi = new FileWriter(dest);
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str = sc.nextLine();
			if(str.equals("그만")) break;
			fi.write(str,0,str.length());
			fi.write("\r\n",0,2);
		}
		fi.close();
		FileReader fr = new FileReader("phone.txt");
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			System.out.println(str);
		}
		br.close();
		fr.close();
	}

}
