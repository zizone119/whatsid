package ch05;

abstract class Figure{
	abstract void draw();
}
interface Sh{
	public void area(double a, double b);
}
class Tri extends Figure implements Sh{

	@Override
	void draw() {
		System.out.println("triangle");
	}

	@Override
	public void area(double a, double b) {
		System.out.println(a*b/2);
	}
	
}
class Rec extends Figure implements Sh{

	@Override
	void draw() {
		System.out.println("rectangle");
	}

	@Override
	public void area(double a, double b) {
		System.out.println(a*b);
	}
	
}
class Oval extends Figure implements Sh{

	@Override
	void draw() {
		System.out.println("oval");
	}

	@Override
	public void area(double a, double b) {
		System.out.println(a*b*3.14);
	}
	
}

class PolyDraw{
	public void pdraw(Figure f) {
		f.draw();
	}
	public void pArea(Sh f,double a,double b) {
		f.area(a,b);
	}
}

public class AbstractTest {

	public static void main(String[] args) {
		PolyDraw p = new PolyDraw();
		Figure f1 = new Tri();
		Figure f2 = new Rec();
		Figure f3 = new Oval();
		Sh s1 = new Tri();
		Sh s2 = new Rec();
		Sh s3 = new Oval();
		p.pdraw(f1);
		p.pArea(s1,2,3);
		p.pdraw(new Rec());
		p.pArea(new Rec(),2,3);
		p.pdraw(f3);
		p.pArea(s3,2,3);
	}

}
