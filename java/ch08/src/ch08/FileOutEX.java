package ch08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.FieldPosition;

public class FileOutEX {

	public static void main(String[] args) throws IOException {
		byte b[]={5,3,5,3,5,8};
		FileOutputStream fout= new FileOutputStream("test.txt");
		for(int i=0;i<b.length;i++) {
			fout.write(b[i]);
		}
		fout.close();
	}

}
