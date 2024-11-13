package ch05;

abstract class Shape {
	abstract void draw();

	abstract void computeArea(int w, int h);
}

class Rectange1 extends Shape {
	int t=1;
	@Override
	void draw() {
		System.out.println("draw");
	}

	@Override
	void computeArea(int w, int h) {
		System.out.println(w * h);
	}

}

class Triange1 extends Shape {
	int t=2;
	@Override
	void draw() {
		System.out.println("draw");
	}

	@Override
	void computeArea(int w, int h) {
		System.out.println((w * h)/2);
	}

}

public class Sample5 {

	public static void main(String[] args) {
		Shape r=new Rectange1();
		r.draw();
		r.computeArea(2, 3);
		r=new Triange1();
		r.draw();
		r.computeArea(2, 3);
	}

}
