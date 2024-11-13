package ch08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockCopy {

	public static void main(String[] args) throws IOException {
		File src = new File("bg0.jpg");
		File dest = new File("copy.jpg");
		FileInputStream fi = new FileInputStream(src);
		FileOutputStream fo = new FileOutputStream(dest);
		byte[] buf = new byte[1024*10];
		while(true) {
			int n=fi.read(buf);
			fo.write(buf,0,n);
			if(n<buf.length) break;
		}
		fi.close();
		fo.close();
		
	}

}
