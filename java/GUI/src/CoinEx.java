import java.util.Scanner;

import javax.swing.JFrame;

public class CoinEx extends JFrame {
		
	public static void main(String[] args) {
		
		System.out.println("금액을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int[] unit= {50000,10000,5000,1000,500,100,50,10,1};
		int sum = sc.nextInt();
		for(int i=0;i<unit.length;i++) {
			System.out.println(unit[i]+"원 짜리 : "+sum/unit[i]+"개");
			sum%=unit[i];
		}
	}

}
