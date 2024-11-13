package ch03;

class Box3{
	int w,h,d;
	long idNum;
	static long id=0;
	public Box3() {
		idNum = ++id;
	}
}

public class Box3Test1 {

	public static void main(String[] args) {
		Box3 myb1= new Box3();
		Box3 myb2= new Box3();
		Box3 myb3= new Box3();
		Box3 myb4= new Box3();
		System.out.println(myb4.idNum);
	}

}
