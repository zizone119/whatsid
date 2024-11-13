import java.util.Scanner;

public class ThreeSixNine {

	public static void main(String[] args) {		
		for(int i=1;i<=99;i++) {
			int t=i%10;
			if(t!=0&&t%3==0) System.out.println(i+ "박수 짝");
		}
	}

}
