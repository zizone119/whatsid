package ch02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner stdin = new Scanner(System.in);
		while (true) {
			int dap = ran.nextInt(99);
			int l = 0, r = 99;
			int cnt = 1;
			boolean go = true;
			System.out.println("컴퓨터의 추측을 맞춰보세요(0~99)");
			while (true) {
				System.out.println(cnt+"번째 ("+l+"-"+r+")>>");
				int res=stdin.nextInt();
				if(res==dap) {
					System.out.println("정답!!!");
					System.out.println(cnt+"번만에 맞추셨습니다.");
					break;
				}
				else if(res>dap) r=res-1;
				else l=res+1;
				cnt++;
			}
			System.out.print("게임을 계속할까요?(y/n)");
			while (true) {
				String str = stdin.next();
				if (str.equals("y")) {
					break;
				} 
				else if (str.equals("n")) {
					go = false;
					break;
				}
				else {
					System.out.println("y 또는 n으로 입력하세요.");
				}
			}
			if(go==false)
			{
				System.out.println("게임이 종료되었습니다.");
				break;
			}
		}
	}
}
