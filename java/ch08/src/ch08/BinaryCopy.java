package ch08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryCopy {

	public static void main(String[] args) throws IOException {
		File src = new File("bg0.jpg");
		File dest = new File("copybg.jpg");
		int c;
		FileInputStream fi = new FileInputStream(src);
		FileOutputStream fo = new FileOutputStream(dest);
		while((c=fi.read())!=-1) {
			fo.write((byte)c);
		}
		fi.close();
		fo.close();
	}

}
