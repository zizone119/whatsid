package ch08;

import java.io.File;

public class FileDir {

	public static void main(String[] args) {
		String directory = "C:/Windows";
		File f1=new File(directory);
		if(f1.isDirectory()) {
			System.out.println("검색 디렉토리 "+directory);
			System.out.println("====================");
			String s[]=f1.list();
			for(int i=0;i<s.length;i++) {
				File f = new File(directory + "/" + s[i]);
				if(f.isDirectory()) System.out.println(s[i]+" : 디렉터리");
				else System.out.println(s[i]+" : 파일");
			}
		}else System.out.println("not directory");
	}

}
