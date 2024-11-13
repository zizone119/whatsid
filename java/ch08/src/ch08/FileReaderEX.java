package ch08;
import java.io.*;
public class FileReaderEX {

	public static void main(String[] args) throws IOException {
		FileReader fin= null;
		fin = new FileReader("c:/windows/system.ini");
		int i;
		while((i=fin.read())!=-1) {
			System.out.print((char)i);
		}
		fin.close();
	}

}
