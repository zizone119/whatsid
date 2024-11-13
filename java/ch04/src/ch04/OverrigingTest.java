package ch04;
class AA{
	public int x=500;
	public int y=1000;
}
class BB extends AA{
	public String x="java";
	public String xx=x+super.x;
	public String yy=""+y+super.y;
}
public class OverrigingTest {

	public static void main(String[] args) {
		BB b=new BB();
		System.out.println(b.x+b.y);
		System.out.println(b.xx);
		System.out.println(b.yy);
	}

}
