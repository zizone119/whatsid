package ch03;

class Box4{
	int w,h,d;
	public Box4(int w,int h,int d) {
		this.w=w;
		this.h=h;
		this.d=d;
	}
}

public class Box4Test1 {

	public static void main(String[] args) {
		Box4 myb=new Box4(2,3,4);
		System.out.println(myb.w*myb.h*myb.d);

	}

}
