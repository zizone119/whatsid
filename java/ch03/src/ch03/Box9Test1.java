package ch03;

class Box9{
	private int w,h,d,v;
	public Box9(int w,int h,int d) {
		this.w=w;
		this.h=h;
		this.d=d;
		volume();
	}
	private void volume()
	{	
		v=w*h*d;
	}
	public int getVol() {
		return v;
	}
}
public class Box9Test1 {

	public static void main(String[] args) {
		Box9 myb = new Box9(2,3,4);
		System.out.println(myb.getVol());
	}

}
