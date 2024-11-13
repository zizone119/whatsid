package ch05;

class Rectangle5{
	public int w,h;
	public Rectangle5(int w,int h) {
		this.w=w;
		this.h=h;
	}
	public int rArea() {
		return w*h;
	}
}
class Cube5 extends Rectangle5{
	public int d;
	public Cube5(int w,int h,int d) {
		super(w,h);
		this.d=d;
	}
	public int cArea() {
		return super.rArea()*d;
	}
}

public class CastTest {

	public static void main(String[] args) {
		Rectangle5 r = new Cube5(10,20,30);
		System.out.println(r.rArea());
		Cube5 c = (Cube5) r;
		System.out.println(c.cArea());

	}

}
