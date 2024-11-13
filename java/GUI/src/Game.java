
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a="", b="";
		int x = 0, y = 0;
		while (x == 0) {
			if (a.equals("가위"))
				x = 1;
			else if (a.equals("바위"))
				x = 2;
			else if (a.equals("보"))
				x = 3;
			else {
				System.out.println("철수(가위,바위,보) : ");
				a = sc.next();
			}
		}
		while (y == 0) {
			if (b.equals("가위"))
				y = 1;
			else if (b.equals("바위"))
				y = 2;
			else if (b.equals("보"))
				y = 3;
			else {
				System.out.println("영희(가위,바위,보) : ");
				b = sc.next();
			}
		}

		if (x == y) {
			System.out.println("비겼습니다.");
		} else if (x == 1 && y == 3 || x == 2 && y == 1 || x == 3 && y == 2) {
			System.out.println("철수가 이겼습니다.");
		} else {
			System.out.println("영희가 이겼습니다.");
		}
	}

}
