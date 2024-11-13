package ch08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopy {

	public static void main(String[] args) throws IOException {
		File src = new File("c:/windows/system.ini");
		File dest = new File("test.txt");
		int c;
		FileReader fr = new FileReader(src);
		FileWriter fw = new FileWriter(dest);
		while((c=fr.read())!=-1) {
			fw.write((char)c);
		}
		fr.close();
		fw.close();
		System.out.println(src.getPath() +"--->"+dest.getPath());
	}

}
