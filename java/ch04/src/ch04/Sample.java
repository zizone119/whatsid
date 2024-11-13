package ch04;

public class Sample {

	int count=10;
	static int num=20;
	public int sum(int x,int y) {
		return x+y;
	}
	static public int mul(int x,int y) {
		return x*y;
	}
	
	public static void main(String[] args) {
		System.out.println(args[0]+args[1]);
		System.out.println(Integer.parseInt(args[0])+Integer.parseInt(args[1]));

	}
	
}
