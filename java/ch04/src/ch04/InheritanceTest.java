package ch04;

class A{
	public int aa=10;
	public int bb=1;
}
class B extends A{
	private static int bb=2;
	public static int bb() {
		return bb;
	}
}
class C extends B{
	int cc=3;
}
public class InheritanceTest {

	public static void main(String[] args) {
		C c=new C();
		System.out.println(c.aa);
		System.out.println(B.bb());
		System.out.println(c.bb());
		System.out.println(c.cc);

	}

}
